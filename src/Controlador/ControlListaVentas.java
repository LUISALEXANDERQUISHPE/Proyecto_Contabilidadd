package Controlador;

import Clases.MySql;
import Modelo.AlmacenKardexVentas;
import Modelo.AlmacenListaVentas;
import Modelo.KardexVentas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlListaVentas {

    MySql conec = new MySql();

//---------------------------------------Metodo agregamos los productos NUEVOS  a la tabla de la base de datos
    public void InsertarFacturaVentas(AlmacenListaVentas almaListaVent, DefaultTableModel dtm) {

        try {
            conec.conectar();
            conec.ConsultarListaVentas(almaListaVent);
            mostrarTablaFacturasVentas(almaListaVent, dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "En insertar las facturas de ventas en la tabla " + e);
        }

    }

//---------------------Opcion llenar los datos en la tabla accediendo siempre primero desde el array de obejtos
    public void mostrarTablaFacturasVentas(AlmacenListaVentas almaListaVent, DefaultTableModel dtm) {
        // Agregar filas a la tabla si la base de datos no está vacía
        for (int i = 0; i < almaListaVent.getLista().size(); i++) {
            dtm.addRow(new Object[]{almaListaVent.getLista().get(i).getNumeroFac(), almaListaVent.getLista().get(i).getFecha(), almaListaVent.getLista().get(i).getProveedorNom(), almaListaVent.getLista().get(i).getTotal()});
        }
    }

//---------------------Opcion sacar total fac
    public boolean borrarFacturaVentas(int numeroFac, AlmacenKardexVentas almakarxVen) {
        boolean aux = false;
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
            aux = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallos al borrar la factura controlLista" + e);
        }
        return aux;
    }

}
