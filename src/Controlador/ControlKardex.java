package Controlador;

import Clases.MySql;
import Modelo.AlmacenKardex;
import Modelo.AlmacenProductos;
import Modelo.Productos;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlKardex {

    MySql conec = new MySql();

    public void cargarProducto(JComboBox c, AlmacenProductos almaProduc) {
        try {
            conec.conectar();
            almaProduc.getLista().clear();
            conec.seleccionarProductos(almaProduc);
            ArrayList<Productos> listap = almaProduc.getLista();
            for (int i = 0; i < listap.size(); i++) {
                c.addItem(listap.get(i));
            }
        } catch (Exception e) {
        } finally {
            // conec.cerraConexion();
        }
    }


    public void Insertarkardex(AlmacenKardex almaKar, DefaultTableModel dtm, String codigoProducto) {

        try {
            conec.conectar();
            almaKar.getLista().clear();
            conec.ConsultaKardex(codigoProducto, almaKar);
            mostrarTablaMovimientos(almaKar, dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "En insertar movimientos kardex" + e);
        }

    }

//---------------------Opcion llenar los datos en la tabla accediendo siempre primero desde el array de obejtos
    public void mostrarTablaMovimientos(AlmacenKardex almaKar, DefaultTableModel dtm) {
        // Agregar filas a la tabla si la base de datos no está vacía
        
        for (int i = 0; i < almaKar.getLista().size(); i++) {
            dtm.addRow(new Object[]{almaKar.getLista().get(i).getFecha(), almaKar.getLista().get(i).getMovimiento(), almaKar.getLista().get(i).getEntrada(), almaKar.getLista().get(i).getSalida(), almaKar.getLista().get(i).getDisponible()});
        }
    }
}
