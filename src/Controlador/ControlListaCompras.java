package Controlador;

import Clases.MySql;
import Modelo.AlmacenFacturaCompras;
import Modelo.AlmacenKardexCompras;
import Modelo.AlmacenListaCompras;
import Modelo.FacturaCompras;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControlListaCompras {

    MySql conec = new MySql();

//---------------------------------------Metodo agregamos los productos NUEVOS  a la tabla de la base de datos
    public void InsertarFacturaCompras(AlmacenListaCompras almaListaCompr, DefaultTableModel dtm) {

        try {
            conec.conectar();
            conec.ConsultarListaCompra(almaListaCompr);
            mostrarTablaProductos(almaListaCompr, dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "En insertar Productos a la factura de compras" + e);
        }

    }

//---------------------Opcion llenar los datos en la tabla accediendo siempre primero desde el array de obejtos
    public void mostrarTablaProductos(AlmacenListaCompras almaListaCompr, DefaultTableModel dtm) {
        // Agregar filas a la tabla si la base de datos no está vacía
        for (int i = 0; i < almaListaCompr.getLista().size(); i++) {
            dtm.addRow(new Object[]{almaListaCompr.getLista().get(i).getNumeroFac(), almaListaCompr.getLista().get(i).getFecha(), almaListaCompr.getLista().get(i).getProveedorNom(), almaListaCompr.getLista().get(i).getTotal()});
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
                txtTotalVenta.setText("" + listaFac.get(i).getTotal());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallos en el total" + e);
        }
    }

    public boolean  borrarFactura(int numeroFac,AlmacenKardexCompras almakarxCom) {
        boolean aux=false;
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = fechaHoraActual.format(formatter);
        try {
            conec.conectar();
            conec.SacarProductosCompras(numeroFac, almakarxCom);
            for (int i = 0; i < almakarxCom.getLista().size(); i++) {
                String codigoProducto=almakarxCom.getLista().get(i).getCodigoP();
                int num2=almakarxCom.getLista().get(i).getCantidad();
                int num1= conec.ConsultaDisponibleProducto(codigoProducto);
                int total= num1-num2;
                conec.AgregarkardexFacturaComprasDevolucion(codigoProducto, fecha, numeroFac, num2, total);
            }
            conec.EliminarfacListaCompras(numeroFac);
            aux=true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallos al borrar la factura Compras controlLista" + e);
        }
        return aux;
    }
}
/* public boolean borrarFacturaVentas(int numeroFac, AlmacenKardexVentas almakarxVen) {
        boolean aux = true;
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = fechaHoraActual.format(formatter);
        try {
            conec.conectar();
            conec.SacarProductosVentas(numeroFac, almakarxVen);
            for (int i = 0; i < almakarxVen.getLista().size(); i++) {
                String codigoProducto = almakarxVen.getLista().get(i).getCodigoP();
                int num2 = almakarxVen.getLista().get(i).getCantidad();
                int num1 = conec.ConsultaDisponibleProducto(codigoProducto);
                int total = num2 + num1;
                conec.AgregarkardexFacturaVentasDevolucion(codigoProducto, fecha, numeroFac, num2, total);
            }
            conec.EliminarfacListaVentas(numeroFac);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallos al borrar la factura controlLista" + e);
        }
        return aux;
    }*/