package Controlador;

import Clases.MySql;
import Modelo.AlmacenClientes;
import Modelo.AlmacenFactura;
import Modelo.AlmacenProductoFac;
import Modelo.AlmacenProductos;
import Modelo.Clientes;
import Modelo.Factura;
import Modelo.Productos;
import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class ControlFactura {

    MySql conec = new MySql();
//_----------------------Llenamos el combobox que tendremos para la opcion agregar productos

    public void cargarCliente(JComboBox c, AlmacenClientes almaClie) {
        try {
            conec.conectar();
            conec.seleccionarClientes(almaClie);
            ArrayList<Clientes> listac = almaClie.getLista();
            for (int i = 0; i < listac.size(); i++) {
                c.addItem(listac.get(i));
            }
        } catch (Exception e) {
        }
    }

    public void cargarProducto(JComboBox c, AlmacenProductos almaProduc) {
        try {
            conec.conectar();
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

//---------------------------------------
    public void AgregarPersonaFactur(String cedula, String NombreApe, String fecha, JTextField txtNumeroFactura) {
        int numeroFactura;
        // Verificar si faltan datos por ingresar
        if (cedula.equals("") || NombreApe.equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar en el apartado de cliente");
        } else {
            try {
                conec.conectar();
                numeroFactura = conec.InsertarFactura(cedula, NombreApe, fecha);
                txtNumeroFactura.setText(String.valueOf(numeroFactura));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public void AgregarProductoFactur(String codigoProducto, String nombreProducto, int cantidad, double precio, int numeroFactura, AlmacenProductoFac almaProducFac, DefaultTableModel dtm, String fecha) {

        try {

            conec.conectar();
            dtm.setRowCount(0);
            almaProducFac.getLista().clear();
            conec.InsertarProductosFactura(numeroFactura, codigoProducto, nombreProducto, cantidad, precio);
            int disponible = conec.ConsultaDisponibleProducto(codigoProducto);
            int total = disponible - cantidad;
            conec.AgregarkardexFacturaVentas(codigoProducto, fecha, numeroFactura, cantidad, total);
            conec.ConsultarProductosFac(almaProducFac, numeroFactura);
            mostrarTablaProductos(almaProducFac, dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

//---------------------Opcion llenar los datos en la tabla accediendo siempre primero desde el array de obejtos
    public void mostrarTablaProductos(AlmacenProductoFac almaProducFac, DefaultTableModel dtm) {
        // Agregar filas a la tabla si la base de datos no está vacía

        for (int i = 0; i < almaProducFac.getLista().size(); i++) {
            dtm.addRow(new Object[]{almaProducFac.getLista().get(i).getNumeroFac(), almaProducFac.getLista().get(i).getCodigoProducto(), almaProducFac.getLista().get(i).getNombreProducto(), almaProducFac.getLista().get(i).getCantidad(), almaProducFac.getLista().get(i).getPrecio(), almaProducFac.getLista().get(i).getSubtotal()});
        }
    }

    public void EliminarFactura(JTextField txtNumeroFactura) {
        int numeroFactura = Integer.parseInt(txtNumeroFactura.getText());
        try {
            conec.conectar();
            conec.eliminarFactura(numeroFactura);
        } catch (HeadlessException e) {
            System.out.println(e);
        }
    }

//---------------------Opcion sacar total fac
    public void SacarTotalFac(AlmacenFactura almaFac, int numeroFactura, JTextField txtTotalVenta) {

        try {
            almaFac.getLista().clear();
            conec.conectar();
            conec.ConsultarFacTotal(almaFac, numeroFactura);
            ArrayList<Factura> listaFac = almaFac.getLista();
            for (int i = 0; i < listaFac.size(); i++) {
                txtTotalVenta.setText("" + listaFac.get(i).getTotal()+"0$");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallos en el total" + e);
        }
    }
    //--------------------------borramos la tabla como una atualisacion---------------

//----------------------------Generador del qr
    public void GenerarQr(String nombre, String fecha, String total, JLabel jlQR) {

        // Verificar si alguno de los valores es null antes de llamar a toString()
        if (nombre == null || fecha == null || total == null) {
            JOptionPane.showMessageDialog(null, "Algunos valores de la fila seleccionada son nulos");
        } else {
            GenerarCodigoQR(nombre, fecha, total, 170, jlQR);
        }

    }

    public void GenerarCodigoQR(String nombre, String fecha, String total, int tamaño, JLabel jlQR) {
        //creamos un String para enviar eso al codigo qr
        String datosCompletos = "                         \"T O Y O T A\" \n            \"FACTURA VENTAS\" \n          - NOMBRE DEL CLIENTE: " + nombre.toUpperCase() + " \n "
                + "           - FECHA: " + fecha + " \n            - TOTAL PAGADO: " + total +"\n        \nLuisoft. -SoftCopyright ©.";
        //mandamos el array los datos completos
        ByteArrayOutputStream out = QRCode.from(datosCompletos).withSize(tamaño, tamaño).to(ImageType.PNG).stream();
        //generamos la imagen
        ImageIcon imageIcon = new ImageIcon(out.toByteArray());
        //enviamos la imagen al Jlabel
        jlQR.setIcon(imageIcon);
    }

    public boolean ControlRUC(String cedula) {
        boolean aux = true;
        String patron = "\\d{13}";
        if (!(cedula.matches(patron))) {
            JOptionPane.showMessageDialog(null, "Ingrese una RUC válido (Contiene 13 números)");
            aux = false;
        } else {
            int primerosdos;
            //Comprobamos si la cedula ingresada contiene 10 dijitos 
            String primerosdosdijitos = cedula.substring(0, 2);
            if (cedula.length() == 13) {
                primerosdos = Integer.parseInt(primerosdosdijitos);
                if (primerosdos >= 1 && primerosdos <= 24) {
                    String nueveprimeros = cedula.substring(0, 9);
                    String digitosImpares = "";
                    String digitosPares = "";
                    for (int i = 0; i < nueveprimeros.length(); i++) {
                        char digito = nueveprimeros.charAt(i);
                        if (i % 2 == 0) {
                            digitosImpares += digito;
                        } else {
                            digitosPares += digito;
                        }
                    }
                    //System.out.println("Dígitos en posiciones impares: " + digitosImpares);
                    //System.out.println("Dígitos en posiciones pares: " + digitosPares);
                    //suma de los dijitos impares
                    int sumaImpares = 0;
                    for (int i = 0; i < digitosImpares.length(); i++) {
                        int digitoImpar = Character.getNumericValue(digitosImpares.charAt(i));
                        int resultado = digitoImpar * 2;
                        if (resultado > 9) {
                            resultado -= 9;
                        }
                        sumaImpares += resultado;
                    }
                    // System.out.println("Suma de los dígitos impares: " + sumaImpares);
                    //suma de los dijitos pares
                    int sumaPares = 0;
                    for (int i = 0; i < digitosPares.length(); i++) {
                        int digitoPar = Character.getNumericValue(digitosPares.charAt(i));
                        int resultado = digitoPar;
                        sumaPares += resultado;
                    }
                    //System.out.println("La suma de los dijitos pares es: " + sumaPares);
                    //Suma total tanto de numeros pares y de numeros impares
                    int sumaTotal;
                    sumaTotal = sumaPares + sumaImpares;
                    //COMPROBACION DEL ULTIMO DIJITO CON LA RESPUESTA DE LA SUMA TOTAL
                    int ultimoDijito;
                    ultimoDijito = sumaTotal % 10;
                    //System.out.println("El dijito ultimo es: " + ultimoDijito);
                    //Al numero 10 se le resta el resultado obtenido
                    int numerofinal = 10 - ultimoDijito;
                    //System.out.println("numero final es: " + numerofinal);
                    String ultimoDijitodelaCedula = cedula.substring(9, 10);
                    // System.out.println("El ultimo dijito es: "+ultimoDijitodelaCedula);
                    if (numerofinal == Integer.parseInt(ultimoDijitodelaCedula)) {
                        String ruc = "001";
                        // System.out.println("aaaaaaa"+cedula.substring(10, 13));
                        if (ruc.equals(cedula.substring(10, 13))) {
                            aux = true;;
                        } else {
                            aux = false;
                            JOptionPane.showMessageDialog(null, "El Ruc ingresado es incorrecto ");
                        }
                    } else {
                        aux = false;
                        JOptionPane.showMessageDialog(null, "El Ruc ingresado es incorrecto ");
                    }
                } else {
                    aux = false;
                    JOptionPane.showMessageDialog(null, "El Ruc ingresado es incorrecto ");
                }
            } else {
                aux = false;
                JOptionPane.showMessageDialog(null, "El Ruc ingresado es incorrecto ");
            }
        }
        return aux;

    }

    public boolean ControlNombreyApellido(String NombreApe) {
        boolean control = true;
        String patron = "^[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ]+(\\s[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ]+)+$";//"^[a-zA-Z]+\\s[a-zA-Z]+$"

        if (!(NombreApe.matches(patron))) {
            control = false;
            JOptionPane.showMessageDialog(null, "Debe ingresar almenos un nombre y un apellido paso patron");
        } else {
            String[] palabras = NombreApe.split(" ");
            if (palabras.length < 2) {
                control = false;
                JOptionPane.showMessageDialog(null, "Debe ingresar almenos un nombre y un apellido  paso longitud");
            }
        }
        //comprobamos si tiene dos palabras
        return control;
    }

    public boolean ControlDireccion(String direccion) {
        boolean control = true;
        String patron = "^[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ]+\\s[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ]+$";//"^[a-zA-Z]+\\s[a-zA-Z]+$"

        if (!(direccion.matches(patron))) {
            control = false;
            JOptionPane.showMessageDialog(null, "La direccion debe contener dos palabras");
        } else {
            String[] palabras = direccion.split(" ");
            if (palabras.length != 2) {
                control = false;
                JOptionPane.showMessageDialog(null, "La direccion debe contener dos palabras");
            }
        }
        //comprobamos si tiene dos palabras
        return control;
    }

    public boolean ControlTelefono(String telefono) {
        boolean control = true;
        String patron = "^[0-9]+$";

        if (!(telefono.matches(patron))) {
            control = false;
            JOptionPane.showMessageDialog(null, "Debe ingresar solo números.");
        }
        return control;
    }

}
