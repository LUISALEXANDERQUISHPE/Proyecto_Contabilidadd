package Controlador;

import Clases.MySql;
import Modelo.AlmacenClientes;
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

public class ControlClientes {

    MySql conec = new MySql();
//_----------------------Llenamos el combobox que tendremos para la opcion agregar productos

    public void cargarCbProvincias(JComboBox c, AlmacenProvincias almaProvincia, AlmacenClientes almaClie) {
        try {
            conec.conectar();
            conec.seleccionarClientes(almaClie);
            conec.seleccionarProvincias(almaProvincia);
            ArrayList<Provincia> lista = almaProvincia.getLista();
            for (int i = 0; i < lista.size(); i++) {
                c.addItem(lista.get(i));
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public void cargarCbProvinciasModificar(JComboBox c, AlmacenProvincias almaProvincia, AlmacenClientes almaClie) {
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
    public int AgregarTablClientes(JTable tbDatos, DefaultTableModel dtm, String Cedula, String NombreApe, String Direccion, String Provincia, String Ciudad, AlmacenClientes almaClie) {
        boolean aux, confirmar;
        int aux1 = 0;
        // Verificar si faltan datos por ingresar
        if (Cedula.equals("") || NombreApe.equals("") || Direccion.equals("") || Provincia.equals("") || Ciudad.equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
            aux1 = 0;
        } else {
            // Validar el formato de la cédula,Nombre y apellido , Direccion
            aux = ControlCedula(Cedula) && ControlNombreyApellido(NombreApe) && ControlDireccion(Direccion);
            if (aux == true) {
                try {
                    conec.conectar();
                    confirmar = conec.InsertarCliente(Cedula, NombreApe, Direccion, Provincia, Ciudad);
                    // Agregar los datos a la tabla
                    if (confirmar == true) {
                        try {
                            // Insertar los datos en la base de datos
                            dtm.addRow(new Object[]{Cedula, NombreApe, Direccion, Provincia, Ciudad});
                            aux1 = 1;
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            aux1 = 0;
        }
        return aux1;
    }

//---------------------Opcion llenar los datos en la tabla accediendo siempre primero desde el array de obejtos
    public void mostrarTablaClientes(AlmacenClientes almaClie, DefaultTableModel dtm) {
        boolean baseDatosVacia = llenartbClientes(almaClie, dtm);

        if (!baseDatosVacia) {
            // Agregar filas a la tabla si la base de datos no está vacía
            for (int i = 0; i < almaClie.getLista().size(); i++) {
                dtm.addRow(new Object[]{almaClie.getLista().get(i).getCedula(), almaClie.getLista().get(i).getNombreApellido(), almaClie.getLista().get(i).getDireccion(), almaClie.getLista().get(i).getProvincia(), almaClie.getLista().get(i).getCiudad()});
            }
        }
    }

    public boolean llenartbClientes(AlmacenClientes almaClie, DefaultTableModel dtm) {
        boolean baseDatosVacia = almaClie.getLista().isEmpty();

        if (baseDatosVacia) {
            //JOptionPane.showMessageDialog(null, "La base de datos está vacía. Debes tener al menos un dato en la base para poder utilizar todas las opciones de esta ventana.\nSin datos, no podrás ingresar ni modificar información.\n\nGracias por tu comprensión.");
        }

        return baseDatosVacia;
    }

    public void  EliminarClientes(String codigoCliente,DefaultTableModel dtm) {
        int aux1;
        try {
           conec.conectar();
           int aux=conec.ElimarCliente(codigoCliente);
            if (aux==1) {
                dtm.removeRow(0);
            }
        } catch (HeadlessException e) {
            System.out.println(e);
        }
    }

//---------------------Opcion editar clientes
    public int EditarClientes(JTable tbDatos, DefaultTableModel dtm, String Cedula, String NombreApe, String Direccion, String Provincia, String Ciudad, AlmacenClientes almaClie) {
        boolean aux;
        int aux1 = 0;
        try {
            //---------------comprobamos primero si hemos elejido algo de la tabla
            if (Cedula.equals("") || NombreApe.equals("") || Direccion.equals("") || Provincia.equals("") || Ciudad.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
                aux1 = 0;
            } else {
                aux = ControlCedula(Cedula) && ControlNombreyApellido(NombreApe) && ControlDireccion(Direccion);
                if (aux == true) {
                    conec.conectar();
                    conec.ModificarCliente(Cedula, NombreApe, Direccion, Provincia, Ciudad);
                    JOptionPane.showMessageDialog(null, "Se  han modificado los datos");
                    almaClie.getLista().clear();
                    LimpiarTabla(tbDatos, dtm);
                    almaClie.getLista().clear();
                    conec.conectar();
                    conec.seleccionarClientes(almaClie);
                    mostrarTablaClientes(almaClie, dtm);
                    aux1 = 1;
                }

            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return aux1;
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
            JOptionPane.showMessageDialog(null, "Elija el cliente antes de generar el código QR");
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
        String datosCompletos = "                         \"T O Y O T A\" \n            - CEDULA DEL CLIENTE: " + Clie.getCedula().toUpperCase() + " \n "
                + "           - NOMBRE Y APELLIDO: " + Clie.getNombreApellido().toUpperCase() + " \n            - DIRECCION: " + Clie.getDireccion().toUpperCase() + "\n            - PROVINCIA: " + Clie.getProvincia().toUpperCase() + " \n            - CIUDAD: " + Clie.getCiudad().toUpperCase() + "\nLuisoft. -SoftCopyright ©.";
        //mandamos el array los datos completos
        ByteArrayOutputStream out = QRCode.from(datosCompletos).withSize(tamaño, tamaño).to(ImageType.PNG).stream();
        //generamos la imagen
        ImageIcon imageIcon = new ImageIcon(out.toByteArray());
        //enviamos la imagen al Jlabel
        jlQR.setIcon(imageIcon);
    }

    public boolean ControlCedula(String cedula) {
        boolean aux = true;
        String patron = "\\d{10}";
        if (!(cedula.matches(patron))) {
            JOptionPane.showMessageDialog(null, "Ingrese una cédula válida (Solamente contiene 10 numeros)");
            aux = false;
        } else {
            int primerosdos;
            //Comprobamos si la cedula ingresada contiene 10 dijitos 
            String primerosdosdijitos = cedula.substring(0, 2);
            if (cedula.length() == 10) {
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
                    //System.out.println("La suma total es: " + sumaTotal);
                    //COMPROBACION DEL ULTIMO DIJITO CON LA RESPUESTA DE LA SUMA TOTAL
                    int ultimoDijito;
                    ultimoDijito = sumaTotal % 10;
                    //System.out.println("El dijito ultimo es: " + ultimoDijito);
                    //Al numero 10 se le resta el resultado obtenido
                    int numerofinal = 10 - ultimoDijito;
                    //System.out.println("numero final es: " + numerofinal);
                    String ultimoDijitodelaCedula = cedula.substring(9);
                    //System.out.println("El ultimo dijito es: "+ultimoDijitodelaCedula);
                    if (numerofinal == Integer.parseInt(ultimoDijitodelaCedula)) {
                        aux = true;

                    } else {
                        aux = false;
                        JOptionPane.showMessageDialog(null, "Cédula incorrecta ");
                    }
                } else {
                    aux = false;
                    JOptionPane.showMessageDialog(null, "Cédula incorrecta ");
                }
            } else {
                aux = false;
                JOptionPane.showMessageDialog(null, "Cédula incorrecta ");
            }
        }
        return aux;

    }

    public boolean ControlNombreyApellido(String NombreApe) {
        boolean control = true;
        String patron = "^[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ]+\\s[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ]+$";

        if (!(NombreApe.matches(patron))) {
            control = false;
            JOptionPane.showMessageDialog(null, "Únicamente debe ser en letras  en su Nombre y apellido (solamente 2)");
        } else {
            String[] palabras = NombreApe.split(" ");
            if (palabras.length != 2) {
                control = false;
                JOptionPane.showMessageDialog(null, "Únicamente es un nombre y un apellido");
            }
        }
        //comprobamos si tiene dos palabras
        return control;
    }

    public boolean ControlDireccion(String Direccion) {
        boolean control = true;
        String patron = "^(\\S+\\s?){2}\\S+$";

        if (!Direccion.matches(patron)) {
            control = false;
            JOptionPane.showMessageDialog(null, "La dirección debe contener 3 Palabras");
        } else {
            String[] palabras = Direccion.split(" ");
            if (palabras.length != 3) {
                control = false;
                JOptionPane.showMessageDialog(null, "La dirección debe contener 3 Palabras");
            }
        }
        return control;
    }

}
