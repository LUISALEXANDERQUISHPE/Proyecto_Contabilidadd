package Vista;

import Clases.MySql;
import Controlador.ControlProvincia;
import Modelo.AlmacenProvincias;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class frmProvincia extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ControlProvincia ctProvinc = new ControlProvincia();
    AlmacenProvincias almaProvincia = new AlmacenProvincias();
    MySql conec = new MySql();

    public frmProvincia() {
        initComponents();
        this.setLocationRelativeTo(null);

        // Cargar datos en los componentes
        // Configurar modelo de tabla
        String[] titulo = new String[]{"Código de Provincia", "Nombre de las Provincias"};
        dtm.setColumnIdentifiers(titulo);
        tbDatos.setModel(dtm);
        conec.conectar();
        conec.seleccionarProvincias(almaProvincia);

        // Llenar tabla y mostrar ventana si la base de datos no está vacía
        boolean baseDatosVacia = ctProvinc.llenartbProvincia(almaProvincia, dtm);
        if (!baseDatosVacia) {
            ctProvinc.mostrarTablaProvincia(almaProvincia, dtm);
            this.setVisible(true);
        } else {
            this.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbProductos = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        btAgregarProvincia = new javax.swing.JButton();
        btEliminarProvincia = new javax.swing.JButton();
        btModificarProvincia = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreProvinciaModificar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoProvincia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreProvincia = new javax.swing.JTextField();
        bt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCprovinciaModificar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Provincias");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 440, 30));

        tbProductos.setForeground(new java.awt.Color(0, 0, 0));
        tbProductos.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        tbProductos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        tbDatos.setBackground(new java.awt.Color(255, 255, 255));
        tbDatos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tbDatos.setForeground(new java.awt.Color(0, 0, 0));
        tbDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDatosMouseClicked(evt);
            }
        });
        tbProductos.setViewportView(tbDatos);

        jPanel1.add(tbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 600, 160));

        btAgregarProvincia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAgregarProvincia.setForeground(new java.awt.Color(0, 0, 0));
        btAgregarProvincia.setText("Agregar");
        btAgregarProvincia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btAgregarProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAgregarProvinciaMouseClicked(evt);
            }
        });
        btAgregarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarProvinciaActionPerformed(evt);
            }
        });
        jPanel1.add(btAgregarProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 130, 30));

        btEliminarProvincia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEliminarProvincia.setForeground(new java.awt.Color(0, 0, 0));
        btEliminarProvincia.setText("Eliminar");
        btEliminarProvincia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btEliminarProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEliminarProvinciaMouseClicked(evt);
            }
        });
        btEliminarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarProvinciaActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminarProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 130, 30));

        btModificarProvincia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btModificarProvincia.setForeground(new java.awt.Color(0, 0, 0));
        btModificarProvincia.setText("Modificar");
        btModificarProvincia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btModificarProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModificarProvinciaMouseClicked(evt);
            }
        });
        btModificarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarProvinciaActionPerformed(evt);
            }
        });
        jPanel1.add(btModificarProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 130, 30));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre de la provincia");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 230, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Agregar una provincia a la lista.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 20));

        txtNombreProvinciaModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombreProvinciaModificar.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreProvinciaModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProvinciaModificarKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreProvinciaModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 220, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Código la provincia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 190, 20));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Código de la provincia");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, -1));

        txtCodigoProvincia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCodigoProvincia.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigoProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProvinciaKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodigoProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 30));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nombre de la provincia");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 190, 20));

        txtNombreProvincia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombreProvincia.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProvinciaKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 220, 30));

        bt.setBackground(new java.awt.Color(29, 91, 121));
        bt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bt.setForeground(new java.awt.Color(255, 255, 255));
        bt.setText("Menú");
        bt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMouseClicked(evt);
            }
        });
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        jPanel1.add(bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, 130, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 200, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 670, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 690, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 700, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Provincia.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, -20, 110, 130));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Eliminar una provincia de la lista. ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 190, 20));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Modificar una provincia de la lista .");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 190, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Provincias en lista.");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, 20));

        txtCprovinciaModificar.setEditable(false);
        txtCprovinciaModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCprovinciaModificar.setForeground(new java.awt.Color(0, 0, 0));
        txtCprovinciaModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCprovinciaModificarKeyTyped(evt);
            }
        });
        jPanel1.add(txtCprovinciaModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 170, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Century751 SeBd BT", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(195, 39, 39));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TOYOTA");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 491));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btModificarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarProvinciaActionPerformed
        ctProvinc.EditarProvincia(tbDatos, dtm, txtCprovinciaModificar.getText(), txtNombreProvinciaModificar.getText(), almaProvincia);
        txtCprovinciaModificar.setText("");
        txtNombreProvinciaModificar.setText("");
    }//GEN-LAST:event_btModificarProvinciaActionPerformed

    private void btAgregarProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAgregarProvinciaMouseClicked
        ctProvinc.AgregarTablProvincia(tbDatos, txtCodigoProvincia.getText(), txtNombreProvincia.getText(), dtm);
        txtCodigoProvincia.setText("");
        txtNombreProvincia.setText("");
    }//GEN-LAST:event_btAgregarProvinciaMouseClicked

    private void btAgregarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAgregarProvinciaActionPerformed

    private void btModificarProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModificarProvinciaMouseClicked

    }//GEN-LAST:event_btModificarProvinciaMouseClicked

    private void btEliminarProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEliminarProvinciaMouseClicked
        int filaSeleccionada = tbDatos.getSelectedRow();
        ctProvinc.EliminarProvincia(filaSeleccionada, dtm);
    }//GEN-LAST:event_btEliminarProvinciaMouseClicked

    private void tbDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosMouseClicked
        int fila = tbDatos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            String CprovinciaElejida = (String) tbDatos.getValueAt(fila, 0);
            String NombreProvi = (String) tbDatos.getValueAt(fila, 1);
            txtNombreProvinciaModificar.setText(NombreProvi);
            txtCprovinciaModificar.setText(CprovinciaElejida);
        }
    }//GEN-LAST:event_tbDatosMouseClicked

    private void btMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btMouseClicked

    private void btEliminarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEliminarProvinciaActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        this.dispose();
        frmInicio in = new frmInicio();
        in.setVisible(true);
    }//GEN-LAST:event_btActionPerformed

    private void txtCodigoProvinciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProvinciaKeyTyped
        char c = evt.getKeyChar();
        String text = this.txtCodigoProvincia.getText().trim();

        if (!Character.isLetterOrDigit(c) || text.length() >= 15) {
            evt.consume(); // Evita ingresar caracteres no permitidos o exceder la longitud máxima
        }
    }//GEN-LAST:event_txtCodigoProvinciaKeyTyped

    private void txtNombreProvinciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProvinciaKeyTyped
        char c = evt.getKeyChar();
        String text = this.txtNombreProvincia.getText().trim();

        if (!Character.isLetter(c) || text.length() >= 20) {
            evt.consume(); // Evita ingresar caracteres no permitidos o exceder la longitud máxima
        }
    }//GEN-LAST:event_txtNombreProvinciaKeyTyped

    private void txtCprovinciaModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCprovinciaModificarKeyTyped
        char c = evt.getKeyChar();
        String text = this.txtCprovinciaModificar.getText().trim();

        if (!Character.isLetterOrDigit(c) || text.length() >= 15) {
            evt.consume(); // Evita ingresar caracteres no permitidos o exceder la longitud máxima
        }
    }//GEN-LAST:event_txtCprovinciaModificarKeyTyped

    private void txtNombreProvinciaModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProvinciaModificarKeyTyped
        char c = evt.getKeyChar();
        String text = this.txtNombreProvinciaModificar.getText().trim();

        if (!Character.isLetter(c) || text.length() >= 20) {
            evt.consume(); // Evita ingresar caracteres no permitidos o exceder la longitud máxima
        }
    }//GEN-LAST:event_txtNombreProvinciaModificarKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmProvincia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProvincia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProvincia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProvincia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProvincia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton btAgregarProvincia;
    private javax.swing.JButton btEliminarProvincia;
    private javax.swing.JButton btModificarProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tbDatos;
    private javax.swing.JScrollPane tbProductos;
    private javax.swing.JTextField txtCodigoProvincia;
    private javax.swing.JTextField txtCprovinciaModificar;
    private javax.swing.JTextField txtNombreProvincia;
    private javax.swing.JTextField txtNombreProvinciaModificar;
    // End of variables declaration//GEN-END:variables

}
