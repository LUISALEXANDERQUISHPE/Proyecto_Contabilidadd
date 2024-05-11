package Vista;

import Clases.MySql;
import Controlador.ControlProductos;
import Modelo.AlmacenProductos;
import Modelo.AlmacenProveedor;
import Modelo.Proveedor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class frmProductos extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ControlProductos ctProduc = new ControlProductos();
    AlmacenProductos almaProductos = new AlmacenProductos();
    AlmacenProveedor almaProve = new AlmacenProveedor();

    public frmProductos() {
        initComponents();
        this.setLocationRelativeTo(null);

        // Cargar datos en los componentes
        ctProduc.cargarCbProvedor(this.cbCodigoProveedor, almaProve, almaProductos);

        // Configurar modelo de tabla
        String[] titulo = new String[]{"Código Proveedor", "Código del producto", "Nombre del producto"};
        dtm.setColumnIdentifiers(titulo);
        tbDatos.setModel(dtm);

        // Llenar tabla y mostrar ventana si la base de datos no está vacía
        boolean baseDatosVacia = ctProduc.llenartbProductos(almaProductos, dtm);
        if (!baseDatosVacia) {
            ctProduc.mostrarTablaProductos(almaProductos, dtm);
            ctProduc.cargarCbProvedorModificar(this.cbCodigoProveedorModificar, almaProve, almaProductos);
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
        btAgregar = new javax.swing.JButton();
        btGenerarQr = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        jlQR = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreProductoEliminar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        txtProductoElejido = new javax.swing.JTextField();
        bt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbCodigoProveedor = new javax.swing.JComboBox<>();
        cbCodigoProveedorModificar = new javax.swing.JComboBox<>();
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
        jLabel1.setText("Productos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 440, 30));

        tbProductos.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

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

        jPanel1.add(tbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 490, 170));

        btAgregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btAgregar.setText("Agregar");
        btAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAgregarMouseClicked(evt);
            }
        });
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 140, 30));

        btGenerarQr.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGenerarQr.setForeground(new java.awt.Color(0, 0, 0));
        btGenerarQr.setText("Código QR.");
        btGenerarQr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btGenerarQr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btGenerarQrMouseClicked(evt);
            }
        });
        btGenerarQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarQrActionPerformed(evt);
            }
        });
        jPanel1.add(btGenerarQr, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 130, 30));

        btEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btEliminar.setText("Eliminar");
        btEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEliminarMouseClicked(evt);
            }
        });
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 140, 30));

        btModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btModificar.setForeground(new java.awt.Color(0, 0, 0));
        btModificar.setText("Modificar");
        btModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModificarMouseClicked(evt);
            }
        });
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 140, 30));

        jlQR.setBackground(new java.awt.Color(255, 255, 255));
        jlQR.setForeground(new java.awt.Color(255, 255, 255));
        jlQR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlQR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jlQR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 190, 150));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre Producto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 190, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Agregar un producto a la lista.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 20));

        txtNombreProductoEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombreProductoEliminar.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreProductoEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoEliminarKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreProductoEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 170, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Elija al proveedor");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 170, 20));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Elija al proveedor");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 160, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Código del producto");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 170, -1));

        txtCodigoProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCodigoProducto.setForeground(new java.awt.Color(0, 0, 0));
        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 160, 30));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nombre producto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 190, 20));

        txtNombreProducto.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 140, 30));

        txtProductoElejido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtProductoElejido.setForeground(new java.awt.Color(0, 0, 0));
        txtProductoElejido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoElejidoKeyTyped(evt);
            }
        });
        jPanel1.add(txtProductoElejido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 170, 30));

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
        jPanel1.add(bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 130, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 700, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 38, 670, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 690, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Productos.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 70, 70));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Código del producto");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 170, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Eliminar un producto de la lista. ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 180, 20));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Modificar un producto de la lista .");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 180, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Productos en lista.");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 20));

        cbCodigoProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbCodigoProveedor.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbCodigoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 140, 30));

        cbCodigoProveedorModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbCodigoProveedorModificar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbCodigoProveedorModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 150, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Century751 SeBd BT", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(195, 39, 39));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Toyota");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 491));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGenerarQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerarQrActionPerformed

    }//GEN-LAST:event_btGenerarQrActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        int aux = ctProduc.EditarProducto(tbDatos, dtm, this.cbCodigoProveedorModificar.getItemAt(this.cbCodigoProveedorModificar.getSelectedIndex()).getRuc(), txtProductoElejido.getText(), txtNombreProductoEliminar.getText(), almaProductos);
        if (aux == 1) {
            txtNombreProductoEliminar.setText("");
            txtProductoElejido.setText("");
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAgregarMouseClicked

        int aux = ctProduc.AgregarTabl(tbDatos, this.cbCodigoProveedor.getItemAt(this.cbCodigoProveedor.getSelectedIndex()).getRuc(), txtCodigoProducto.getText(), txtNombreProducto.getText(), dtm);
        if (aux == 0) {
            txtCodigoProducto.setText("");
            txtNombreProducto.setText("");
        }
    }//GEN-LAST:event_btAgregarMouseClicked

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAgregarActionPerformed

    private void btGenerarQrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btGenerarQrMouseClicked
        int fila = tbDatos.getSelectedRow();
        ctProduc.GenerarQr(fila, tbDatos, jlQR);
    }//GEN-LAST:event_btGenerarQrMouseClicked

    private void btModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModificarMouseClicked

    }//GEN-LAST:event_btModificarMouseClicked

    private void btEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEliminarMouseClicked


    }//GEN-LAST:event_btEliminarMouseClicked

    private void tbDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosMouseClicked
        int fila = tbDatos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            String ProveedorElejido = (String) tbDatos.getValueAt(fila, 1);
            txtProductoElejido.setEditable(false);
            txtProductoElejido.setText(ProveedorElejido);
        }
    }//GEN-LAST:event_tbDatosMouseClicked

    private void btMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btMouseClicked

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        int filaSeleccionada = tbDatos.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Elija el dato a eliminar en la tabla");
        } else {
            String codigoP=dtm.getValueAt(filaSeleccionada, 1).toString();
            ctProduc.EliminarProducto(codigoP, dtm);
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        this.dispose();
        frmInicio in = new frmInicio();

        in.setVisible(true);
    }//GEN-LAST:event_btActionPerformed

    private void txtCodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyTyped
        JTextField txtCodigoProducto = (JTextField) evt.getSource();
        String txtCodio = txtCodigoProducto.getText();
        if (txtCodio.length() >= 10) {
            // Consumir el evento para evitar que se agregue el carácter adicional
            evt.consume();
        }

    }//GEN-LAST:event_txtCodigoProductoKeyTyped

    private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped

        JTextField txtNombreProducto = (JTextField) evt.getSource();

        // Obtener el texto actual en el campo de texto
        String txtCodio = txtNombreProducto.getText();
        // Verificar si se ha alcanzado el límite máximo de caracteres
        if (txtCodio.length() >= 15) {
            // Consumir el evento para evitar que se agregue el carácter adicional
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreProductoKeyTyped

    private void txtProductoElejidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoElejidoKeyTyped
        JTextField txtProductoElejido = (JTextField) evt.getSource();
        String txtCodio = txtProductoElejido.getText();
        if (txtCodio.length() >= 10) {
            // Consumir el evento para evitar que se agregue el carácter adicional
            evt.consume();
        }
    }//GEN-LAST:event_txtProductoElejidoKeyTyped

    private void txtNombreProductoEliminarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoEliminarKeyTyped
        JTextField txtNombreProductoEliminar = (JTextField) evt.getSource();
        // Obtener el texto actual en el campo de texto
        String txtCodio = txtNombreProductoEliminar.getText();
        // Verificar si se ha alcanzado el límite máximo de caracteres
        if (txtCodio.length() >= 15) {
            // Consumir el evento para evitar que se agregue el carácter adicional
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreProductoEliminarKeyTyped

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
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGenerarQr;
    private javax.swing.JButton btModificar;
    public javax.swing.JComboBox<Proveedor> cbCodigoProveedor;
    public javax.swing.JComboBox<Proveedor> cbCodigoProveedorModificar;
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
    private javax.swing.JLabel jlQR;
    private javax.swing.JTable tbDatos;
    private javax.swing.JScrollPane tbProductos;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNombreProductoEliminar;
    private javax.swing.JTextField txtProductoElejido;
    // End of variables declaration//GEN-END:variables

}
