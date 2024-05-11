package Controlador;

import Clases.MySql;
import Modelo.AlmacenProductos;
import Modelo.AlmacenProveedor;
import Modelo.Productos;
import Modelo.Proveedor;
import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author Lenovo
 */
public class ControlProductos {

    MySql conec = new MySql();
//_----------------------Llenamos el combobox que tendremos para la opcion agregar productos

    public void cargarCbProvedor(JComboBox<Proveedor> cbCodigoProveedor, AlmacenProveedor almaProve, AlmacenProductos almaProductos) {

        try {
            conec.conectar();
            conec.seleccionarProveedores(almaProve);
            conec.seleccionarProductos(almaProductos);
            ArrayList<Proveedor> listado = almaProve.getLista();
            for (int i = 0; i < listado.size(); i++) {
                cbCodigoProveedor.addItem(listado.get(i));
            }
            listado.clear();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cargarCbProvedorModificar(JComboBox<Proveedor> cbCodigoProveedor, AlmacenProveedor almaProve, AlmacenProductos almaProductos) {

        try {
            conec.conectar();
            conec.seleccionarProveedores(almaProve);

            //conec.seleccionarProductos(almaProductos);
            ArrayList<Proveedor> listado = almaProve.getLista();
            for (int i = 0; i < listado.size(); i++) {
                cbCodigoProveedor.addItem(listado.get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//---------------------------------------Metodo agregamos los productos NUEVOS  a la tabla de la base de datos
    public int AgregarTabl(JTable tbDatos, String cbProvedorCode, String txtCodigoProduc, String txtNombreProduc, DefaultTableModel dtm) {//metodo agregar productos nuevos a la tabla
        int aux, aux1 = 0;
        if (cbProvedorCode.equals("") || txtCodigoProduc.equals("") || txtNombreProduc.equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
            aux1 = 1;
        } else {
            try {
                conec.conectar();
                aux = conec.insertarProductos("productos", cbProvedorCode, txtCodigoProduc, txtNombreProduc);
                if (aux == 0) {
                    dtm.addRow(new Object[]{cbProvedorCode, txtCodigoProduc, txtNombreProduc});
                    aux1 = 0;
                } else {
                    aux1 = 1;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return aux1;
    }
//---------------------Opcion llenar los datos en la tabla accediendo siempre primero desde el array de obejtos

    public void mostrarTablaProductos(AlmacenProductos almaProductos, DefaultTableModel dtm) {
        boolean baseDatosVacia = llenartbProductos(almaProductos, dtm);

        if (!baseDatosVacia) {
            // Agregar filas a la tabla si la base de datos no está vacía
            for (int i = 0; i < almaProductos.getLista().size(); i++) {
                dtm.addRow(new Object[]{almaProductos.getLista().get(i).getCodigoProveedor(), almaProductos.getLista().get(i).getCodigoProducto(), almaProductos.getLista().get(i).getNombreProducto()});
            }
        }
    }

    public boolean llenartbProductos(AlmacenProductos almaProductos, DefaultTableModel dtm) {
        boolean baseDatosVacia = almaProductos.getLista().isEmpty();

        if (baseDatosVacia) {
            //      JOptionPane.showMessageDialog(null, "La base de datos está vacía. Debes tener al menos un dato en la base para poder utilizar todas las opciones de esta ventana.\nSin datos, no podrás ingresar ni modificar información.\n\nGracias por tu comprensión.");
        }

        return baseDatosVacia;
    }

    public void EliminarProducto(String codigoPRO, DefaultTableModel dtm) {
        try {
            conec.conectar();
            int aux = conec.eliminarProducto(codigoPRO);
            if (aux==1) {
                dtm.removeRow(0);
            }
        } catch (HeadlessException e) {
            System.out.println(e);
        }
    }

//---------------------Opcion editar producto
    public int EditarProducto(JTable tbDatos, DefaultTableModel dtm, String CodigoProveedor, String codigoProducto, String nombreProducto, AlmacenProductos almaProductos) {
        int aux, aux1 = 0;
        try {
            //---------------comprobamos primero si hemos elejido algo de la tabla
            if (CodigoProveedor.equals("") || codigoProducto.equals("") || nombreProducto.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
                aux1 = 0;
            } else {
                conec.conectar();
                aux = conec.ModificarProductos(CodigoProveedor, nombreProducto, codigoProducto);
                if (aux == 1) {
                    JOptionPane.showMessageDialog(null, "Se  han modificado los datos");
                    //almaProductos.getLista().clear();
                    dtm.setRowCount(0);
                    almaProductos.getLista().clear();
                    conec.conectar();
                    conec.seleccionarProductos(almaProductos);
                    mostrarTablaProductos(almaProductos, dtm);
                    aux1 = 1;
                } else {
                    aux1 = 0;
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
        return aux1;
    }

//----------------------------Generador del qr

    public void GenerarQr(Integer filaSeleccionada, JTable tbDatos, JLabel jlQR) {
        // Verificar si no se ha seleccionado ninguna fila o si filaSeleccionada es null
        if (filaSeleccionada == null || filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Elija el producto antes de generar el código QR");
        } else if (tbDatos == null) {
            JOptionPane.showMessageDialog(null, "La tabla de datos es nula no hay valores que generar");
        } else {
            Object valorProveedor = tbDatos.getValueAt(filaSeleccionada, 0);
            Object valorProducto = tbDatos.getValueAt(filaSeleccionada, 1);
            Object valorNombre = tbDatos.getValueAt(filaSeleccionada, 2);

            // Verificar si alguno de los valores es null antes de llamar a toString()
            if (valorProveedor == null || valorProducto == null || valorNombre == null) {
                JOptionPane.showMessageDialog(null, "Algunos valores de la fila seleccionada son nulos");
            } else {
                String cProveedor = valorProveedor.toString();
                String cProducto = valorProducto.toString();
                String Nproducto = valorNombre.toString();

                Productos producto = new Productos(cProveedor, cProducto, Nproducto);
                GenerarCodigoQR(producto, jlQR, 170);
            }
        }
    }

    public void GenerarCodigoQR(Productos producto, JLabel jlQR, int tamaño) {
        //creamos un String para enviar eso al codigo qr
        String datosCompletos = "                         \"T O Y O T A\" \n            - CODIGO DEL PROVEEDOR: " + producto.getCodigoProducto().toUpperCase() + " \n            - CODIGO DEL PRODUCTO: " + producto.getNombreProducto().toUpperCase() + " \n            - PRODUCTO: " + producto.getCodigoProveedor().toUpperCase() + "\nLuisoft. -SoftCopyright ©.";
        //mandamos el array los datos completos
        ByteArrayOutputStream out = QRCode.from(datosCompletos).withSize(tamaño, tamaño).to(ImageType.PNG).stream();
        //generamos la imagen
        ImageIcon imageIcon = new ImageIcon(out.toByteArray());
        //enviamos la imagen al Jlabel
        jlQR.setIcon(imageIcon);
    }
}
