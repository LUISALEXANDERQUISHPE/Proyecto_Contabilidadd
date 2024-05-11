package Controlador;

import Clases.Encriptación;
import Clases.MySql;
import javax.swing.JLabel;

/**
 *
 * @author Lenovo
 */
public class ControlPermisos {

    MySql con = new MySql();

    public boolean RegistroAdmin(String usuario, String contraseña, JLabel txtMensaje) {
        boolean aux = false;
        if (usuario.equals("admin") && contraseña.equals("1234")) {
            aux = true;
            txtMensaje.setText("Usuario correcto");

        } else {
            txtMensaje.setText("Usuario Incorrecto. Vuelva intentarlo");
        }
        return aux;
    }

    public boolean IngresarNuevosUsers(String usuario, String contraseña, boolean productos, boolean clientes, boolean proveedor, boolean factura, boolean compra, boolean kardex, boolean provincia, boolean ciudad, boolean lisven, boolean liscom, boolean permiso) {
        boolean aux = false;
        Encriptación en = new Encriptación();
        try {
            con.conectar();
            String contraEncrip=en.Encriptar(contraseña);
            aux = con.insertarNuevoUsuario(usuario, contraEncrip, productos, clientes, proveedor, factura, compra, kardex, provincia, ciudad, lisven, liscom, permiso);

        } catch (Exception e) {
            System.out.println("error en ingresar nuevos user" + e);
        }
        return aux;
    }

}
