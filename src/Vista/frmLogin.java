package Vista;

import Controlador.ControlUsuarios;
import Modelo.AlmacenPermisos;
import Modelo.Variable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
public class frmLogin extends javax.swing.JFrame {

    AlmacenPermisos almaPermisos = new AlmacenPermisos();
    ControlUsuarios cntUsuarios = new ControlUsuarios();

    public frmLogin() {
        initComponents();
        cntUsuarios.CargarCombo(cbUsuario, almaPermisos);
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbUsuario = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtContraseñaUser = new javax.swing.JPasswordField();
        btIniciarsesión = new javax.swing.JButton();
        txtMensaje = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(31, 97, 141));
        jPanel3.setFocusable(false);
        jPanel3.setMinimumSize(new java.awt.Dimension(314, 423));
        jPanel3.setPreferredSize(new java.awt.Dimension(314, 423));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TOYOTA");

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel5.setText("Usuario"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel4.setText("Contraseña"); // NOI18N

        cbUsuario.setBackground(new java.awt.Color(31, 97, 141));
        cbUsuario.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        cbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        cbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUsuarioActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));

        txtContraseñaUser.setBackground(new java.awt.Color(31, 97, 141));
        txtContraseñaUser.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        txtContraseñaUser.setForeground(new java.awt.Color(255, 255, 255));
        txtContraseñaUser.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtContraseñaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaUserActionPerformed(evt);
            }
        });

        btIniciarsesión.setBackground(new java.awt.Color(0, 0, 0));
        btIniciarsesión.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btIniciarsesión.setForeground(new java.awt.Color(255, 255, 255));
        btIniciarsesión.setText("Iniciar sesión");
        btIniciarsesión.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btIniciarsesiónMouseClicked(evt);
            }
        });
        btIniciarsesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarsesiónActionPerformed(evt);
            }
        });

        txtMensaje.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        txtMensaje.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(btIniciarsesión))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContraseñaUser, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContraseñaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btIniciarsesión)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 280, 420));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 420));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 40, 26));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited

    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btIniciarsesiónMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btIniciarsesiónMouseClicked

    }//GEN-LAST:event_btIniciarsesiónMouseClicked

    private void btIniciarsesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarsesiónActionPerformed
        try {
            if (txtContraseñaUser.getText().isEmpty() || this.cbUsuario.getSelectedItem() == null) {
                txtMensaje.setText("Ingrese la contraseña o el usuario");
            } else {
                boolean aux = cntUsuarios.LoginClave(this.cbUsuario.getSelectedItem().toString(), this.txtContraseñaUser.getText(), almaPermisos, txtContraseñaUser, txtMensaje);
                if ((aux == true)) {
                    JOptionPane.showMessageDialog(null, "Usuario correcto");
                    this.dispose();
                    frmInicio inicio = new frmInicio();
                    Variable.setP(this.cbUsuario.getSelectedItem().toString());
                    inicio.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            System.out.println("linea botton" + ex);
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btIniciarsesiónActionPerformed

    private void cbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUsuarioActionPerformed

    }//GEN-LAST:event_cbUsuarioActionPerformed

    private void txtContraseñaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaUserActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIniciarsesión;
    private static javax.swing.JComboBox<String> cbUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtContraseñaUser;
    private javax.swing.JLabel txtMensaje;
    // End of variables declaration//GEN-END:variables
 public static boolean verificarConexionInternet() {
        try {
            // Define una URL a la cual realizar la solicitud
            URL url = new URL("https://www.google.com");
            
            // Abre una conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Establece el método de solicitud
            connection.setRequestMethod("GET");
            
            // Establece un tiempo de espera para la conexión (opcional)
            connection.setConnectTimeout(3000); // 3 segundos
            
            // Realiza la solicitud y verifica el código de respuesta
            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            // Error al realizar la solicitud o al verificar la respuesta
            return false;
        }
    }
}
