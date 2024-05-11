package Vista;

import Clases.MySql;
import Controlador.ControlCiudad;
import Modelo.AlmacenCiudad;
import Modelo.AlmacenProvincias;
import Modelo.Provincia;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class frmCiudad extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ControlCiudad ctCiudad = new ControlCiudad();
    AlmacenCiudad almaCiudad = new AlmacenCiudad();
    AlmacenProvincias almaProvin = new AlmacenProvincias();
    MySql conec = new MySql();

    public frmCiudad() {
        initComponents();
        this.setLocationRelativeTo(null);

        // Cargar datos en los componentes
        ctCiudad.cargarCbProvincias(this.cbCodigoProvincia, almaProvin, almaCiudad);

        // Configurar modelo de tabla
        String[] titulo = new String[]{"Código Provincia", "Código de la ciudad", "Nombre de la ciudad"};
        dtm.setColumnIdentifiers(titulo);
        tbDatosCiudades.setModel(dtm);

        // Llenar tabla y mostrar ventana si la base de datos no está vacía
        boolean baseDatosVacia = ctCiudad.llenartbCiudades(almaCiudad, dtm);
        if (!baseDatosVacia) {
            ctCiudad.mostrarTablaCiudades(almaCiudad, dtm);
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
        tbDatosCiudades = new javax.swing.JTable();
        btAgregarCiudad = new javax.swing.JButton();
        btEliminarCiudad = new javax.swing.JButton();
        btModificarCiudad = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreCiudadModificar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoCiudad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreCiudad = new javax.swing.JTextField();
        txtCodigoCiudadModificar = new javax.swing.JTextField();
        bt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCodigoProvinciaModificar = new javax.swing.JTextField();
        cbCodigoProvincia = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();

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
        jLabel1.setText("Ciudad");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 440, 30));

        tbProductos.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        tbDatosCiudades.setBackground(new java.awt.Color(255, 255, 255));
        tbDatosCiudades.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tbDatosCiudades.setForeground(new java.awt.Color(0, 0, 0));
        tbDatosCiudades.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDatosCiudades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDatosCiudadesMouseClicked(evt);
            }
        });
        tbProductos.setViewportView(tbDatosCiudades);

        jPanel1.add(tbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 730, 170));

        btAgregarCiudad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAgregarCiudad.setForeground(new java.awt.Color(0, 0, 0));
        btAgregarCiudad.setText("Agregar");
        btAgregarCiudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btAgregarCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAgregarCiudadMouseClicked(evt);
            }
        });
        btAgregarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(btAgregarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 120, 30));

        btEliminarCiudad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEliminarCiudad.setForeground(new java.awt.Color(0, 0, 0));
        btEliminarCiudad.setText("Eliminar");
        btEliminarCiudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btEliminarCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEliminarCiudadMouseClicked(evt);
            }
        });
        btEliminarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 120, 30));

        btModificarCiudad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btModificarCiudad.setForeground(new java.awt.Color(0, 0, 0));
        btModificarCiudad.setText("Modificar");
        btModificarCiudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btModificarCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModificarCiudadMouseClicked(evt);
            }
        });
        btModificarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(btModificarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 120, 30));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre de la ciudad");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 180, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Agregar un ciudad a la lista de la provincia.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 260, 20));

        txtNombreCiudadModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombreCiudadModificar.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreCiudadModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCiudadModificarKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreCiudadModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 160, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Código de la Provincia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 230, 20));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Elija la provincia");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Código de la ciudad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 170, -1));

        txtCodigoCiudad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCodigoCiudad.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigoCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoCiudadKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodigoCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 150, 30));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nombre de la ciudad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 190, 20));

        txtNombreCiudad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombreCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCiudadKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 150, 30));

        txtCodigoCiudadModificar.setEditable(false);
        txtCodigoCiudadModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCodigoCiudadModificar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtCodigoCiudadModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 150, 30));

        bt.setBackground(new java.awt.Color(29, 91, 121));
        bt.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
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
        jPanel1.add(bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 120, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 220, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 670, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 740, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 750, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\Ciudad.png")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 100, 80));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Código de la ciudad");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 170, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Eliminar una ciudad de la lista. ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 180, 20));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Modificar una ciudad de la lista .");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 180, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ciudades en la lista");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, 20));

        txtCodigoProvinciaModificar.setEditable(false);
        txtCodigoProvinciaModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCodigoProvinciaModificar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtCodigoProvinciaModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 140, 30));

        cbCodigoProvincia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(cbCodigoProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Century751 SeBd BT", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(195, 39, 39));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("TOYOTA");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btModificarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarCiudadActionPerformed
        ctCiudad.EditarCiudad(tbDatosCiudades, dtm, txtCodigoProvinciaModificar.getText(), txtCodigoCiudadModificar.getText(), txtNombreCiudadModificar.getText(), almaCiudad);
        txtCodigoProvinciaModificar.setText("");
        txtCodigoCiudadModificar.setText("");
        txtNombreCiudadModificar.setText("");
    }//GEN-LAST:event_btModificarCiudadActionPerformed

    private void btAgregarCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAgregarCiudadMouseClicked
        ctCiudad.AgregarTablCiudades(tbDatosCiudades, this.cbCodigoProvincia.getItemAt(this.cbCodigoProvincia.getSelectedIndex()).getCodigoProvincia(), txtCodigoCiudad.getText(), txtNombreCiudad.getText(), dtm);
        txtCodigoCiudad.setText("");
        txtNombreCiudad.setText("");
    }//GEN-LAST:event_btAgregarCiudadMouseClicked

    private void btAgregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAgregarCiudadActionPerformed

    private void btModificarCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModificarCiudadMouseClicked

    }//GEN-LAST:event_btModificarCiudadMouseClicked

    private void btEliminarCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEliminarCiudadMouseClicked
        int filaSeleccionada = tbDatosCiudades.getSelectedRow();
        ctCiudad.EliminarCiudad(filaSeleccionada, dtm);

    }//GEN-LAST:event_btEliminarCiudadMouseClicked

    private void tbDatosCiudadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosCiudadesMouseClicked
        int fila = tbDatosCiudades.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            String Cprovin = (String) tbDatosCiudades.getValueAt(fila, 0);
            String NombreProvi = (String) tbDatosCiudades.getValueAt(fila, 1);
            String CodigoProvi = (String) tbDatosCiudades.getValueAt(fila, 2);
            txtCodigoProvinciaModificar.setText(Cprovin);
            txtCodigoProvinciaModificar.setEditable(false);
            txtCodigoCiudadModificar.setText(NombreProvi);
            txtCodigoCiudadModificar.setEditable(false);
            txtNombreCiudadModificar.setText(CodigoProvi);
        }
    }//GEN-LAST:event_tbDatosCiudadesMouseClicked

    private void btMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btMouseClicked

    private void btEliminarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEliminarCiudadActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        this.dispose();
        frmInicio in = new frmInicio();
        in.setVisible(true);
    }//GEN-LAST:event_btActionPerformed

    private void txtCodigoCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCiudadKeyTyped
        char c = evt.getKeyChar();
        String text = this.txtCodigoCiudad.getText().trim();

        if (!Character.isLetterOrDigit(c) || text.length() >= 15) {
            evt.consume(); // Evita ingresar caracteres no permitidos o exceder la longitud máxima
        }

    }//GEN-LAST:event_txtCodigoCiudadKeyTyped

    private void txtNombreCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCiudadKeyTyped
    char c = evt.getKeyChar();
        String text = this.txtNombreCiudad.getText().trim();

        if (!Character.isLetter(c) || text.length() >= 20) {
            evt.consume(); // Evita ingresar caracteres no permitidos o exceder la longitud máxima
        }
    }//GEN-LAST:event_txtNombreCiudadKeyTyped

    private void txtNombreCiudadModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCiudadModificarKeyTyped
       char c = evt.getKeyChar();
        String text = this.txtNombreCiudad.getText().trim();

        if (!Character.isLetter(c) || text.length() >= 20) {
            evt.consume(); // Evita ingresar caracteres no permitidos o exceder la longitud máxima
        }
    }//GEN-LAST:event_txtNombreCiudadModificarKeyTyped

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
            java.util.logging.Logger.getLogger(frmCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCiudad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton btAgregarCiudad;
    private javax.swing.JButton btEliminarCiudad;
    private javax.swing.JButton btModificarCiudad;
    public javax.swing.JComboBox<Provincia> cbCodigoProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tbDatosCiudades;
    private javax.swing.JScrollPane tbProductos;
    private javax.swing.JTextField txtCodigoCiudad;
    private javax.swing.JTextField txtCodigoCiudadModificar;
    private javax.swing.JTextField txtCodigoProvinciaModificar;
    private javax.swing.JTextField txtNombreCiudad;
    private javax.swing.JTextField txtNombreCiudadModificar;
    // End of variables declaration//GEN-END:variables

}
