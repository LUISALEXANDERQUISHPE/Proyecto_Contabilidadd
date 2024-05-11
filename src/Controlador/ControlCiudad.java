package Controlador;

import Clases.MySql;
import Modelo.AlmacenCiudad;
import java.awt.HeadlessException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Modelo.AlmacenProvincias;
import Modelo.Proveedor;
import Modelo.Provincia;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class ControlCiudad {

    MySql conec = new MySql();
//_----------------------Llenamos el combobox que tendremos para la opcion agregar productos

    public void cargarCbProvincias(JComboBox cbCodigoProvincia, AlmacenProvincias almaProvincia, AlmacenCiudad almaCiudad) {
        try {
            conec.conectar();
            conec.seleccionarProvincias(almaProvincia);
            conec.seleccionarCiudades(almaCiudad);
           ArrayList<Provincia> listado = almaProvincia.getLista();
            for (int i = 0; i < listado.size(); i++) {
                cbCodigoProvincia.addItem(listado.get(i));
            }
            listado.clear();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//---------------------------------------Metodo agregamos los productos NUEVOS  a la tabla de la base de datos
    public void AgregarTablCiudades(JTable tbDatos, String cbCodigoProvincia, String txtCodigoCiudad, String txtNombreCiudadModificar, DefaultTableModel dtm) {//metodo agregar productos nuevos a la tabla
        if (cbCodigoProvincia.equals("") || txtCodigoCiudad.equals("") || txtNombreCiudadModificar.equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
        } else {
            try {
                ///ahora enviamos los datos a la base
                conec.conectar();
                boolean aux = conec.insertarCiudades(cbCodigoProvincia, txtNombreCiudadModificar, txtCodigoCiudad);
                if (aux == true) {
                    dtm.addRow(new Object[]{cbCodigoProvincia, txtCodigoCiudad, txtNombreCiudadModificar});
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

//---------------------Opcion llenar los datos en la tabla accediendo siempre primero desde el array de obejtos
    public void mostrarTablaCiudades(AlmacenCiudad almaCiudad, DefaultTableModel dtm) {

        boolean baseDatosVacia = llenartbCiudades(almaCiudad, dtm);

        if (!baseDatosVacia) {
            // Agregar filas a la tabla si la base de datos no está vacía
            for (int i = 0; i < almaCiudad.getLista().size(); i++) {
                dtm.addRow(new Object[]{almaCiudad.getLista().get(i).getCodigoProvincia(), almaCiudad.getLista().get(i).getNombreCiudad(), almaCiudad.getLista().get(i).getCodigoCiudad()});
            }
         
        }
    }

    public boolean llenartbCiudades(AlmacenCiudad almaCiudad, DefaultTableModel dtm) {
        boolean baseDatosVacia = almaCiudad.getLista().isEmpty();

        if (baseDatosVacia) {
            JOptionPane.showMessageDialog(null, "La base de datos está vacía. Debes tener al menos un dato en la base para poder utilizar todas las opciones de esta ventana.\nSin datos, no podrás ingresar ni modificar información.\n\nGracias por tu comprensión.");
        }

        return baseDatosVacia;
    }

    public void EliminarCiudad(Integer filaSeleccionada, DefaultTableModel dtm) {
        try {
            if (filaSeleccionada == null || filaSeleccionada < 0) {
                JOptionPane.showMessageDialog(null, "Elija el dato a eliminar en la tabla");
            } else {
                Object valorCelda = dtm.getValueAt(filaSeleccionada,1);
                int filas = dtm.getRowCount();
                for (int i = 0; i < filas; i++) {
                    String valor = dtm.getValueAt(i, 1).toString();
                    if (valor.equals(valorCelda)) {
                        dtm.removeRow(i);
                        conec.ElimarCiudad(valor);
                        break;
                    }
                }
            }
        } catch (HeadlessException e) {
            System.out.println(e);
        }
    }

//---------------------Opcion editar producto
    public void EditarCiudad(JTable tbDatos, DefaultTableModel dtm, String CodigoProvincia, String codigoCiudad, String nombreCiudad, AlmacenCiudad almaCiudad) {
        try {
            //---------------comprobamos primero si hemos elejido algo de la tabla
            if (CodigoProvincia.equals("") || codigoCiudad.equals("") || nombreCiudad.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
            } else {
                conec.conectar();
              
                conec.ModificarCiudad(nombreCiudad, CodigoProvincia, codigoCiudad);
                JOptionPane.showMessageDialog(null, "Se  han modificado los datos");
                almaCiudad.getLista().clear();
                LimpiarTabla(tbDatos, dtm);
                almaCiudad.getLista().clear();
                conec.conectar();
                conec.seleccionarCiudades(almaCiudad);
                mostrarTablaCiudades(almaCiudad, dtm);
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
