package Controlador;

import Clases.MySql;
import Modelo.AlmacenProveedor;
import Modelo.AlmacenProvincias;
import Modelo.Clientes;
import Modelo.Provincia;
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

public class ControlProveedor {

    MySql conec = new MySql();
//_----------------------Llenamos el combobox que tendremos para la opcion agregar productos

    public void cargarCbProvincias(JComboBox c, AlmacenProvincias almaProvincia, AlmacenProveedor almaProve) {
        try {
            conec.conectar();
            conec.seleccionarProveedores(almaProve);
            conec.seleccionarProvincias(almaProvincia);
            ArrayList<Provincia> lista = almaProvincia.getLista();
            for (int i = 0; i < lista.size(); i++) {
                c.addItem(lista.get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public void cargarCbProvinciasModificar(JComboBox c, AlmacenProvincias almaProvincia) {
        try {
            conec.conectar();
            almaProvincia.getLista().clear();
            conec.seleccionarProvincias(almaProvincia);
            ArrayList<Provincia> nueva = almaProvincia.getLista();
            for (int i = 0; i < nueva.size(); i++) {
                c.addItem(nueva.get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//---------------------------------------Metodo agregamos los productos NUEVOS  a la tabla de la base de datos
    public int AgregarTablProveedor(JTable tbDatos, DefaultTableModel dtm, String RUC, String NombreApe, String telefono, String Direccion, String Provincia, String Ciudad, AlmacenProveedor almaProve) {
        boolean aux, confirmar;
        int aux2=0;
        // Verificar si faltan datos por ingresar
        if (RUC.equals("") || NombreApe.equals("") || telefono.equals("") || Direccion.equals("") || Provincia.equals("") || Ciudad.equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
            aux2=0;
        } else {
            // Validar el formato de la RUC,Nombre y apellido , Direccion
            aux = ControlRUC(RUC) && ControlNombreyApellido(NombreApe) && ControlDireccion(Direccion) && ControlTelefono(telefono); //&& ControlDireccion(Direccion);

            if (aux == true) {
                try {
                    conec.conectar();
                    confirmar = conec.InsertarProveedor(RUC, NombreApe, telefono, Direccion, Provincia, Ciudad);

                    // Agregar los datos a la tabla
                    if (confirmar == true) {
                        try {
                            // Insertar los datos en la base de datos
                            dtm.addRow(new Object[]{RUC, NombreApe, telefono, Direccion, Provincia, Ciudad});
                            aux2=1;
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                aux2=0;
            }
        }
        return aux2;
    }

//---------------------Opcion llenar los datos en la tabla accediendo siempre primero desde el array de obejtos
    public void mostrarTablaProveedor(AlmacenProveedor almaProve, DefaultTableModel dtm) {
        boolean baseDatosVacia = llenartbProveedor(almaProve, dtm);

        if (!baseDatosVacia) {
            // Agregar filas a la tabla si la base de datos no está vacía
            for (int i = 0; i < almaProve.getLista().size(); i++) {
                dtm.addRow(new Object[]{almaProve.getLista().get(i).getRuc(), almaProve.getLista().get(i).getNombreApellido(), almaProve.getLista().get(i).getTelefono(), almaProve.getLista().get(i).getDireccion(), almaProve.getLista().get(i).getProvincia(), almaProve.getLista().get(i).getCiudad()});
            }
        }
    }

    public boolean llenartbProveedor(AlmacenProveedor almaProve, DefaultTableModel dtm) {
        boolean baseDatosVacia = almaProve.getLista().isEmpty();

        if (baseDatosVacia) {
            // JOptionPane.showMessageDialog(null, "La base de datos está vacía. Debes tener al menos un dato en la base para poder utilizar todas las opciones de esta ventana.\nSin datos, no podrás ingresar ni modificar información.\n\nGracias por tu comprensión.");
        }

        return baseDatosVacia;
    }

    public void EliminarProveedor(DefaultTableModel dtm, String codigoProve) {
        int aux;
        try {
            conec.conectar();
            aux = conec.EliminarProveedor(codigoProve);
            if (aux == 1) {
                dtm.removeRow(0);
            }

        } catch (HeadlessException e) {
            System.out.println(e);
        }
    }

//---------------------Opcion editar clientes
    public int EditarProveedor(JTable tbDatos, DefaultTableModel dtm, String RUC, String NombreApe, String telefono, String Direccion, String Provincia, String Ciudad, AlmacenProveedor almaProve) {
        boolean aux;
        int xua = 0;
        try {
            //---------------comprobamos primero si hemos elejido algo de la tabla
            if (RUC.equals("") || NombreApe.equals("") || telefono.equals("") || Direccion.equals("") || Provincia.equals("") || Ciudad.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
                xua = 0;
            } else {
                aux = ControlRUC(RUC) && ControlNombreyApellido(NombreApe) && ControlDireccion(Direccion) && ControlTelefono(telefono);
                if (aux == true) {
                    conec.conectar();
                    conec.ModificarProveedores(RUC, NombreApe, telefono, Direccion, Provincia, Ciudad);
                    JOptionPane.showMessageDialog(null, "Se  han modificado los datos");
                    almaProve.getLista().clear();
                    LimpiarTabla(tbDatos, dtm);
                    almaProve.getLista().clear();
                    conec.conectar();
                    conec.seleccionarProveedores(almaProve);
                    mostrarTablaProveedor(almaProve, dtm);
                    xua = 1;
                }
                xua = 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return xua;
    }
    //--------------------------borramos la tabla como una atualisacion---------------

    public void LimpiarTabla(JTable tbDatos, DefaultTableModel dtm) {
        for (int i = 0; i < tbDatos.getRowCount(); i++) {
            dtm.removeRow(i);
            i = i - 1;
        }
    }
//----------------------------Generador del qr

    public void GenerarQr(Integer filaSeleccionada, JTable tbDatos, JLabel jlQR) {
        // Verificar si no se ha seleccionado ninguna fila o si filaSeleccionada es null
        if (filaSeleccionada == null || filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Elija al proveedor antes de generar el código QR");
        } else if (tbDatos == null) {
            JOptionPane.showMessageDialog(null, "La tabla de datos es nula no hay valores que generar");
        } else {
            Object Cedula = tbDatos.getValueAt(filaSeleccionada, 0);
            Object NombreApe = tbDatos.getValueAt(filaSeleccionada, 1);
            Object Direccion = tbDatos.getValueAt(filaSeleccionada, 2);
            Object Provincia = tbDatos.getValueAt(filaSeleccionada, 3);
            Object Ciudad = tbDatos.getValueAt(filaSeleccionada, 4);

            // Verificar si alguno de los valores es null antes de llamar a toString()
            if (Cedula == null || NombreApe == null || Direccion == null || Provincia == null || Ciudad == null) {
                JOptionPane.showMessageDialog(null, "Algunos valores de la fila seleccionada son nulos");
            } else {
                String cCedula = Cedula.toString();
                String cNombreApe = NombreApe.toString();
                String NDireccion = Direccion.toString();
                String Pprovincia = Provincia.toString();
                String Cciudad = Ciudad.toString();

                Clientes clie = new Clientes(cCedula, cNombreApe, NDireccion, Pprovincia, Cciudad);
                GenerarCodigoQR(clie, jlQR, 170);
            }
        }
    }

    public void GenerarCodigoQR(Clientes Clie, JLabel jlQR, int tamaño) {
        //creamos un String para enviar eso al codigo qr
        String datosCompletos = "                         \"T O Y O T A\" \n            - CEDULA DEL PROVEEDOR: " + Clie.getCedula().toUpperCase() + " \n "
                + "           - NOMBRE Y APELLIDO: " + Clie.getNombreApellido().toUpperCase() + " \n            - TELEFONO: " + Clie.getDireccion().toUpperCase() + "\n            - CIUDAD: " + Clie.getProvincia().toUpperCase() + " \n            - PROVINCIA: " + Clie.getCiudad().toUpperCase() + "\nLuisoft. -SoftCopyright ©.";
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
        String patron = "^[\\p{L}]+(\\s[\\p{L}]+)+$";

        if (!NombreApe.matches(patron)) {
            control = false;
            JOptionPane.showMessageDialog(null, "Debe ingresar al menos un nombre y un apellido");
        } else {
            String[] palabras = NombreApe.split(" ");
            if (palabras.length < 2) {
                control = false;
                JOptionPane.showMessageDialog(null, "Debe ingresar al menos un nombre y un apellido");
            }
        }

        return control;
    }

    public boolean ControlDireccion(String direccion) {
        boolean control = true;
        String patron = "^[\\p{L}]+(\\s[\\p{L}]+)+$";
        if (!(direccion.matches(patron))) {
            control = false;
            JOptionPane.showMessageDialog(null, "La direccion debe contener solo dos palabras");
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
