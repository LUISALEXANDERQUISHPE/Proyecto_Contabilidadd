package Controlador;

import Clases.Encriptación;
import Clases.MySql;
import Modelo.AlmacenPermisos;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Lenovo
 */
public class ControlUsuarios {

    MySql conec = new MySql();

    public void CargarCombo(JComboBox c, AlmacenPermisos almaPermisos) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();

        c.setModel(combo);
        try {
            conec.conectar();
            almaPermisos.getLista().clear();
            conec.seleccionarUsuarios(almaPermisos);
            for (int i = 0; i < almaPermisos.getLista().size(); i++) {
                combo.addElement(almaPermisos.getLista().get(i).getUsuario());
            }
        } catch (Exception e) {
            System.out.println("Error al cargar el combo" + e);
        }
    }

    public boolean LoginClave(String user, String clave, AlmacenPermisos almaPermisos, JPasswordField txtContraseñaUser, JLabel txtMensaje) throws SQLException, UnsupportedEncodingException {
        boolean conf = false;
        int ps = 0;
        Encriptación en = new Encriptación();
        for (int i = 0; i < almaPermisos.getLista().size(); i++) {
            if (almaPermisos.getLista().get(i).getUsuario().equals(user)) {

                ps = i;
                break;
            }
        }
        if (almaPermisos.getLista().get(ps).getIntento() < 3) {
           String contra= en.Desencriptar(almaPermisos.getLista().get(ps).getContraseña());
            System.out.println(contra);
            if (contra.equals(clave)) {
                conf = true;
                almaPermisos.getLista().get(ps).setIntento(0);
                conec.update(almaPermisos.getLista().get(ps));
            } else {
                txtMensaje.setText("Contraseña incorrecto");
                almaPermisos.getLista().get(ps).setIntento(almaPermisos.getLista().get(ps).getIntento() + 1);
                conec.update(almaPermisos.getLista().get(ps));
                txtContraseñaUser.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario bloqueado. Demaciados intentos");
            txtContraseñaUser.setText("");
        }
        return conf;
    }

}
