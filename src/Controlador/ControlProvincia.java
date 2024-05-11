package Controlador;

import Clases.MySql;
import Modelo.AlmacenProvincias;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlProvincia {

    MySql conec = new MySql();

//---------------------------------------Metodo agregamos los productos NUEVOS  a la tabla de la base de datos
    public void AgregarTablProvincia(JTable tbDatos, String CodigoProvincias, String nombreProvincia, DefaultTableModel dtm) {//metodo agregar productos nuevos a la tabla
        if (CodigoProvincias.equals("") || nombreProvincia.equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
        } else {
            //mandamos los datos a la tabla en el orden ya predispuesto
            try {
                dtm.addRow(new Object[]{CodigoProvincias, nombreProvincia});

                try {
                    ///ahora enviamos los datos a la base
                    conec.conectar();
                    conec.insertarProvincias(CodigoProvincias, nombreProvincia);
                    System.out.println("se agrego");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }
//---------------------Opcion llenar los datos en la tabla accediendo siempre primero desde el array de obejtos

    public void mostrarTablaProvincia(AlmacenProvincias almaProvincia, DefaultTableModel dtm) {
        boolean baseDatosVacia = llenartbProvincia(almaProvincia, dtm);

        if (!baseDatosVacia) {
            // Agregar filas a la tabla si la base de datos no está vacía
            for (int i = 0; i < almaProvincia.getLista().size(); i++) {
                dtm.addRow(new Object[]{almaProvincia.getLista().get(i).getCodigoProvincia(), almaProvincia.getLista().get(i).getNombreProvincia()});
            }
        }
    }

    public boolean llenartbProvincia(AlmacenProvincias almaProvincia, DefaultTableModel dtm) {

        boolean baseDatosVacia = almaProvincia.getLista().isEmpty();

        if (baseDatosVacia) {
            JOptionPane.showMessageDialog(null, "La base de datos está vacía. Debes tener al menos un dato en la base para poder utilizar todas las opciones de esta ventana.\nSin datos, no podrás ingresar ni modificar información.\n\nGracias por tu comprensión.");
        }
        return baseDatosVacia;
    }

    public void EliminarProvincia(Integer filaSeleccionada, DefaultTableModel dtm) {
        try {
            if (filaSeleccionada == null || filaSeleccionada < 0) {
                JOptionPane.showMessageDialog(null, "Elija el dato a eliminar en la tabla");
            } else {
                Object valorCelda = dtm.getValueAt(filaSeleccionada, 0);
                int filas = dtm.getRowCount();
                for (int i = 0; i < filas; i++) {
                    String valor = dtm.getValueAt(i, 0).toString();
                    if (valor.equals(valorCelda)) {
                        System.out.println(valor);
                        int aux =conec.ElimarProvincia(valor);
                        if (aux==0) {
                            dtm.removeRow(i);
                        }
                        break;
                    }
                }
            }
        } catch (HeadlessException e) {
            System.out.println(e);
        }
    }

//---------------------Opcion editar producto
    public void EditarProvincia(JTable tbDatos, DefaultTableModel dtm, String codigoProvincia, String nombreProvincia, AlmacenProvincias almaProvincia) {
        try {
            //---------------comprobamos primero si hemos elejido algo de la tabla
            if (codigoProvincia.equals("") || nombreProvincia.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
            } else {
                conec.conectar();
                System.out.println(codigoProvincia + nombreProvincia);
                conec.ModificarProvincias(nombreProvincia, codigoProvincia);
                JOptionPane.showMessageDialog(null, "Se  han modificado los datos");
                almaProvincia.getLista().clear();
                dtm.setRowCount(0);
                almaProvincia.getLista().clear();
                conec.conectar();
                conec.seleccionarProvincias(almaProvincia);
                mostrarTablaProvincia(almaProvincia, dtm);
                //System.out.println("se edito con normalidad");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }

    }
//--------------------------borramos la tabla como una atualisacion---------------

    public void LimpiarTabla(JTable tbDatos, DefaultTableModel dtm) {
        for (int i = 0; i < tbDatos.getRowCount(); i++) {
            dtm.removeRow(i);
            i = i - 1;
        }
    }
}
