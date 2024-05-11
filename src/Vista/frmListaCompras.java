package Vista;

import Clases.MySql;
import Controlador.ControlListaCompras;
import Modelo.AlmacenKardexCompras;
import Modelo.AlmacenListaCompras;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmListaCompras extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ControlListaCompras ctListaCompr = new ControlListaCompras();
    AlmacenListaCompras almaListaCompr = new AlmacenListaCompras();
    AlmacenKardexCompras almakarxCom = new AlmacenKardexCompras();
    MySql conec = new MySql();

    public frmListaCompras() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
        this.setTitle("LISTADO DE FACTURAS  -  COMPRAS");
        // Configurar modelo de tabla
        String[] titulo = new String[]{"N°FACTURA", "FECHA", "PROVEEDOR", "CANT.COMPRADO"};
        dtm.setColumnIdentifiers(titulo);
        txtNumeroFactura.setEditable(false);
        tbDatos.setModel(dtm);
        ctListaCompr.InsertarFacturaCompras(almaListaCompr, dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbProductos = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        bt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNumeroFactura = new javax.swing.JTextField();
        btEliminarFactCompra = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century751 SeBd BT", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(195, 39, 39));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOYOTA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, 50));

        tbProductos.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        tbProductos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        tbDatos.setBackground(new java.awt.Color(255, 255, 255));
        tbDatos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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

        jPanel1.add(tbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 760, 250));

        bt.setBackground(new java.awt.Color(29, 91, 121));
        bt.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        bt.setForeground(new java.awt.Color(255, 255, 255));
        bt.setText("Menú");
        bt.setToolTipText("");
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
        jPanel1.add(bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 520, 110, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 10, 370));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Compras.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 110, 100));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("N° FACTURA");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 150, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Listado de facturas \"Compras\".");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 200, 20));

        txtNumeroFactura.setEditable(false);
        txtNumeroFactura.setBackground(new java.awt.Color(195, 39, 39));
        txtNumeroFactura.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtNumeroFactura.setForeground(new java.awt.Color(255, 255, 255));
        txtNumeroFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 70, 60));

        btEliminarFactCompra.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btEliminarFactCompra.setForeground(new java.awt.Color(0, 0, 0));
        btEliminarFactCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/backspace.png"))); // NOI18N
        btEliminarFactCompra.setText("  Eliminar");
        btEliminarFactCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btEliminarFactCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarFactCompraActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminarFactCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 140, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lista de facturas.     \"Compras.\"");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 520, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Eliminación de facturas.");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 140, 20));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 770, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 10, 340));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 770, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents
// Método para verificar el formato numérico con un solo punto decimal

    private void tbDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosMouseClicked
        int fila = tbDatos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            String numeroFac = String.valueOf(tbDatos.getValueAt(fila, 0));
            txtNumeroFactura.setText(numeroFac);
        }
    }//GEN-LAST:event_tbDatosMouseClicked

    private void btMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btMouseClicked

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        this.dispose();
        frmInicio in = new frmInicio();
        in.setVisible(true);
    }//GEN-LAST:event_btActionPerformed

    private void btEliminarFactCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarFactCompraActionPerformed
        String numFacText = txtNumeroFactura.getText();

        if (numFacText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, primero debe seleccionar una factura de la Tabla. Para posterior ser \"Eliminada\".");
        } else {
            try {
                int numeroFactura = Integer.parseInt(numFacText);
                boolean aux;
                aux = ctListaCompr.borrarFactura(numeroFactura, almakarxCom);
                if (aux == true) {
                    JOptionPane.showMessageDialog(null, "Se ha borrado la factura de compra con éxito. Gracias");
                    dtm.setRowCount(0);
                    almaListaCompr.getLista().clear();
                    ctListaCompr.InsertarFacturaCompras(almaListaCompr, dtm);
                    txtNumeroFactura.setText("");
                    txtNumeroFactura.setEditable(false);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El número de factura no es válido");
            }
        }
    }//GEN-LAST:event_btEliminarFactCompraActionPerformed

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
            java.util.logging.Logger.getLogger(frmListaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmListaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmListaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmListaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmListaCompras().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton btEliminarFactCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable tbDatos;
    private javax.swing.JScrollPane tbProductos;
    private javax.swing.JTextField txtNumeroFactura;
    // End of variables declaration//GEN-END:variables

    // Suponiendo que tienes un JComboBox llamado comboBox y un JTextField llamado txtCliente
}
