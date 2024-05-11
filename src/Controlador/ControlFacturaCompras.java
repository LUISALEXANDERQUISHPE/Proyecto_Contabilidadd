package Controlador;

import Clases.MySql;
import Modelo.AlmacenFactComprasProductos;
import Modelo.AlmacenFacturaCompras;
import Modelo.AlmacenProductos;
import Modelo.AlmacenProveedor;
import Modelo.FacturaCompras;
import Modelo.Productos;
import Modelo.Proveedor;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControlFacturaCompras {

    MySql conec = new MySql();
//_----------------------Llenamos el combobox que tendremos para la opcion agregar productos

    public void cargarProveedor(JComboBox c, AlmacenProveedor almaProve) {
        try {
            conec.conectar();
            conec.seleccionarProveedores(almaProve);
            ArrayList<Proveedor> listap = almaProve.getLista();
            for (int i = 0; i < listap.size(); i++) {
                c.addItem(listap.get(i));
            }
        } catch (Exception e) {
        }
    }

    public void cargarcbProductosRelacionados(AlmacenProductos almaProduc, String cedulaProveedor, JComboBox c) {

        try {
            conec.conectar();
            almaProduc.getLista().clear();
            conec.SubConsultaProductos(almaProduc, cedulaProveedor);

            ArrayList<Productos> listap = almaProduc.getLista();
            for (int i = 0; i < listap.size(); i++) {
                c.addItem(listap.get(i));
            }
        } catch (Exception e) {
        }
    }

//---------------------------------------Metodo agregamos los productos NUEVOS  a la tabla de la base de datos
    public void InsertarFacturaCompras(String nombreProveedor, String codigoCompra, String codigoProveedor, String fecha, JTextField txtNumeroFactura) {
        int numeroFactura = 0;
        // Verificar si faltan datos por ingresar

        try {
            conec.conectar();
            if (numeroFactura == -1) {
                JOptionPane.showMessageDialog(null, "No se creo la factura vuelva a intentarlo");
                return;
            } else {
                numeroFactura = conec.insertarFacturaCompra(nombreProveedor, codigoCompra, codigoProveedor, fecha);
                txtNumeroFactura.setText(String.valueOf(numeroFactura));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "En insertar Productos a la factura de compras" + e);
        }

    }

    public void AgregarProductoFacturCompras(int numeroFactura, String codigoProducto, String nombreProducto, int cantidad, double precio, AlmacenFacturaCompras almaFactCompr, DefaultTableModel dtm, AlmacenFactComprasProductos almaFactProducComp, String fecha) {

        try {
            conec.conectar();
            dtm.setRowCount(0); // borro la tabla
            almaFactProducComp.getLista().clear(); // borro el arreglo de AlmacenFacturaComprasProductos

            // Agregar productos a la factura de compras
            conec.AgregarProductosPedidosAfactura(numeroFactura, codigoProducto, nombreProducto, cantidad, precio);
            int disponible = conec.ConsultaDisponibleProducto(codigoProducto);
            int total = disponible + cantidad;
            // Obtener el valor actualizado de "disponible" y actualizar el Kardex
           
            conec.AgregarkardexFacturaCompras(codigoProducto, fecha, numeroFactura, cantidad, total);

            // Realizar las demás operaciones y mostrar la tabla de productos
            String numfac = String.valueOf(numeroFactura);
            conec.subConsultaProductosFacturaCompra(numfac, almaFactProducComp);
            mostrarTablaProductos(almaFactProducComp, dtm);
        } catch (Exception e) {
            System.out.println("Fallo al agregar los productos a la factura de compras: " + e);
        }
    }

//---------------------Opcion llenar los datos en la tabla accediendo siempre primero desde el array de obejtos
    public void mostrarTablaProductos(AlmacenFactComprasProductos almaFactProducComp, DefaultTableModel dtm) {
        // Agregar filas a la tabla si la base de datos no está vacía
        for (int i = 0; i < almaFactProducComp.getLista().size(); i++) {
            dtm.addRow(new Object[]{almaFactProducComp.getLista().get(i).getNumeroFac(), almaFactProducComp.getLista().get(i).getCodigoProducto(), almaFactProducComp.getLista().get(i).getNombreProducto(), almaFactProducComp.getLista().get(i).getCantidad(), almaFactProducComp.getLista().get(i).getPrecio(), almaFactProducComp.getLista().get(i).getSubtotal()});
        }
    }

//---------------------Opcion sacar total fac
    public void SacarTotalFac(AlmacenFacturaCompras almaFacCompras, int numeroFactura, JTextField txtTotalVenta) {

        try {
            almaFacCompras.getLista().clear();
            conec.conectar();
            conec.ConsultarFacTotalCompra(almaFacCompras, numeroFactura);
            ArrayList<FacturaCompras> listaFac = almaFacCompras.getLista();
            for (int i = 0; i < listaFac.size(); i++) {
                txtTotalVenta.setText("" + listaFac.get(i).getTotal()+"0$");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallos en el total" + e);
        }
    }

}
