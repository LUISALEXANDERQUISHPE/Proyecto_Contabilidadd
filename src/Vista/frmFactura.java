package Vista;

import Clases.MySql;
import Controlador.ControlFactura;
import Modelo.AlmacenClientes;
import Modelo.AlmacenFactura;
import Modelo.AlmacenProductoFac;
import Modelo.AlmacenProductos;
import Modelo.Clientes;
import Modelo.Productos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class frmFactura extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ControlFactura ctFact = new ControlFactura();
    AlmacenProductos almaProduc = new AlmacenProductos();
    AlmacenClientes almaclie = new AlmacenClientes();
    AlmacenFactura almaFact = new AlmacenFactura();
    AlmacenProductoFac almaProducFac = new AlmacenProductoFac();
    MySql conec = new MySql();

    public frmFactura() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
        this.setTitle("FACTURA");
        // Cargar datos en los componentes
        ctFact.cargarCliente(this.cbCodigoCliente, almaclie);
        ctFact.cargarProducto(this.cbProductos, almaProduc);

        // Agrego un ActionListener al ComboBox
        cbProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el código de producto seleccionado del ComboBox
                txtPrecioVenta.setText("");
                txtCantidadVender.setText("");
                txtCantidadStock.setText("");
                String codigoProducto = cbProductos.getItemAt(cbProductos.getSelectedIndex()).getCodigoProducto();

                // Consultar la disponibilidad del producto y actualizar el JTextField
                int disponible = conec.ConsultaDisponibleProducto(codigoProducto);
                txtCantidadStock.setText(String.valueOf(disponible));
            }
        });

        //cargamos la hora
        // Configurar modelo de tabla
        String[] titulo = new String[]{"N°FACTURA", "CÓDIGO PRODUCTO", "PRODUCTO", "CANTIDAD", "PRECIO.UNI", "SUBTOTAL"};
        dtm.setColumnIdentifiers(titulo);
        tbDatos.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbProductos = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        btAñadirProductoTabla = new javax.swing.JButton();
        jlQR = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JTextField();
        bt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCantidadVender = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btListoCliente = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtCantidadStock = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtFecha = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbCodigoCliente = new javax.swing.JComboBox<>();
        cbProductos = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtNumeroFactura = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btGenerarVenta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Factura - ventas");
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

        jPanel1.add(tbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 690, 110));

        btAñadirProductoTabla.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAñadirProductoTabla.setForeground(new java.awt.Color(0, 0, 0));
        btAñadirProductoTabla.setText("Añadir ");
        btAñadirProductoTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btAñadirProductoTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAñadirProductoTablaMouseClicked(evt);
            }
        });
        btAñadirProductoTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirProductoTablaActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadirProductoTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 140, 30));

        jlQR.setBackground(new java.awt.Color(255, 255, 255));
        jlQR.setForeground(new java.awt.Color(255, 255, 255));
        jlQR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlQR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jlQR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 170, 130));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Total a pagar:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 130, 20));

        txtTotalVenta.setEditable(false);
        txtTotalVenta.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        txtTotalVenta.setForeground(new java.awt.Color(153, 0, 0));
        txtTotalVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtTotalVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 130, 40));

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
        jPanel1.add(bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 520, 150, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 10, 280));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 480, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Factura.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 110, 100));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Por favor, seleccione los productos.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 200, 20));

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cliente: ");
        jLabel13.setFocusable(false);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 160, -1));

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Fecha:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, -1));

        txtPrecioVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPrecioVenta.setForeground(new java.awt.Color(0, 0, 0));
        txtPrecioVenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioVentaFocusLost(evt);
            }
        });
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 140, 30));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("N° FACTURA");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 140, 60));

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Productos.");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, -1));

        txtCantidadVender.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCantidadVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadVenderActionPerformed(evt);
            }
        });
        txtCantidadVender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVenderKeyTyped(evt);
            }
        });
        jPanel1.add(txtCantidadVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 120, 30));

        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Stock:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 50, -1));

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Precio de venta.");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 140, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 690, 30));

        btListoCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btListoCliente.setForeground(new java.awt.Color(0, 0, 0));
        btListoCliente.setText("Crear");
        btListoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btListoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btListoClienteMouseClicked(evt);
            }
        });
        btListoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListoClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btListoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 140, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Lista de productos comprados.");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 190, 20));

        txtCantidadStock.setEditable(false);
        txtCantidadStock.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        txtCantidadStock.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(txtCantidadStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 40, 30));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 10, 350));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(204, 204, 255));
        txtFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 210, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Porfavor,elija al cliente.");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 20));

        cbCodigoCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbCodigoCliente.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 210, 30));

        cbProductos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbProductos.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 180, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Añadir el producto a la lista.");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 190, 20));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Una vez seleccionado el cliente,");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 230, 20));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText(" presiona \"Crear\" para crear la factura. ");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 220, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 770, 10));

        txtNumeroFactura.setEditable(false);
        txtNumeroFactura.setBackground(new java.awt.Color(255, 226, 72));
        txtNumeroFactura.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtNumeroFactura.setForeground(new java.awt.Color(0, 0, 0));
        txtNumeroFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 70, 60));

        jLabel25.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Cantidad.");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 90, -1));

        btGenerarVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGenerarVenta.setForeground(new java.awt.Color(0, 0, 0));
        btGenerarVenta.setText("Generar venta");
        btGenerarVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btGenerarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 140, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century751 SeBd BT", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(195, 39, 39));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TOYOTA");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAñadirProductoTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirProductoTablaActionPerformed
        String precioVentaText = txtPrecioVenta.getText();
        String cantidadVentaText = txtCantidadVender.getText();
        String numFac = txtNumeroFactura.getText();
        btListoCliente.setEnabled(false);
        if (numFac.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe primero crear el cliente para continuar con la Factura");
        } else {
            int numeroFactura = 0;
            try {
                numeroFactura = Integer.parseInt(numFac);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El número de factura no es válido");
                return;
            }

            if (cantidadVentaText.isEmpty() || precioVentaText.isEmpty()
                    || cbProductos.getItemAt(cbProductos.getSelectedIndex()).getNombreProducto().isEmpty()
                    || Double.parseDouble(precioVentaText) <= 0) {
                JOptionPane.showMessageDialog(null, "Faltan datos o los valores ingresados no son válidos en el campo Productos");
            } else if (Integer.parseInt(txtCantidadVender.getText()) <= 0 || Integer.parseInt(txtCantidadVender.getText()) > Integer.parseInt(txtCantidadStock.getText())) {
                JOptionPane.showMessageDialog(null, "Stock no permitido de venta. Existe un límite de venta ");
            } else {
                double precioVenta = 0.0;
                int cantidadVenta = 0;

                try {
                    precioVenta = Double.parseDouble(precioVentaText);
                    cantidadVenta = Integer.parseInt(cantidadVentaText);

                    ctFact.AgregarProductoFactur(
                            cbProductos.getItemAt(cbProductos.getSelectedIndex()).getCodigoProducto(),
                            cbProductos.getItemAt(cbProductos.getSelectedIndex()).getNombreProducto(),
                            cantidadVenta, precioVenta, numeroFactura, almaProducFac, dtm, txtFecha.getText());
                    txtPrecioVenta.setText("");
                    txtCantidadVender.setText("");
                    txtCantidadStock.setText("");
                    this.bt.setEnabled(false);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El formato de precio o cantidad no es válido");
                }
            }
        }
    }//GEN-LAST:event_btAñadirProductoTablaActionPerformed

    private void btAñadirProductoTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAñadirProductoTablaMouseClicked

    }//GEN-LAST:event_btAñadirProductoTablaMouseClicked

    private void tbDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosMouseClicked

    }//GEN-LAST:event_tbDatosMouseClicked

    private void btMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btMouseClicked

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        this.dispose();
        frmInicio in = new frmInicio();
        in.setVisible(true);
    }//GEN-LAST:event_btActionPerformed

    private void btListoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btListoClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btListoClienteMouseClicked

    private void btListoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListoClienteActionPerformed
        txtTotalVenta.setText("");
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = fechaHoraActual.format(formatter);
        txtFecha.setText(fecha);
        txtFecha.setEditable(false);
        ctFact.AgregarPersonaFactur(this.cbCodigoCliente.getItemAt(this.cbCodigoCliente.getSelectedIndex()).getCedula(), this.cbCodigoCliente.getItemAt(this.cbCodigoCliente.getSelectedIndex()).getNombreApellido(), txtFecha.getText(), txtNumeroFactura);
        this.bt.setEnabled(false);
        txtPrecioVenta.setText("");
        txtCantidadVender.setText("");
        txtCantidadStock.setText("");
        btListoCliente.setEnabled(false);
        cbCodigoCliente.setEnabled(false);
    }//GEN-LAST:event_btListoClienteActionPerformed

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        char c = evt.getKeyChar();
        String text = txtPrecioVenta.getText();

// Verificar si ya hay un punto en el campo de texto
        if (c == '.' && text.contains(".")) {
            evt.consume();
            return;
        }

// Permitir ingresar solo dígitos y un punto
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }

// Validar si el punto está al inicio o al final del texto
        if (c == '.' && (text.isEmpty() || text.endsWith("."))) {
            showMessage("Se requiere un número válido");
            evt.consume();
        }

// Limitar la cantidad de dígitos antes del punto a 7
        int dotIndex = text.indexOf(".");
        if (dotIndex == -1 && text.length() >= 4) {
            evt.consume();
        } else if (dotIndex != -1 && dotIndex >= 4) {
            evt.consume();
        }

// Limitar la cantidad de dígitos después del punto a 2
        if (dotIndex != -1 && text.length() - dotIndex > 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtCantidadVenderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVenderKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || this.txtCantidadVender.getText().trim().length() >= 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadVenderKeyTyped

    private void btGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerarVentaActionPerformed
        String numFacText = txtNumeroFactura.getText();

        if (numFacText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, primero debe crear la factura con los productos correspondientes antes de generar la venta total y, por ende, la factura.");
        } else {
            try {
                int numeroFactura = Integer.parseInt(numFacText);
                ctFact.SacarTotalFac(almaFact, numeroFactura, txtTotalVenta);
                ctFact.GenerarQr(this.cbCodigoCliente.getItemAt(this.cbCodigoCliente.getSelectedIndex()).getNombreApellido(), txtFecha.getText(), txtTotalVenta.getText(), jlQR);
                JOptionPane.showMessageDialog(null, "Se ha creado la factura de venta con éxito. Gracias");
                txtNumeroFactura.setText("");
                dtm.setRowCount(0);
                txtFecha.setText("");
                this.bt.setEnabled(true);
                btListoCliente.setEnabled(true);
                cbCodigoCliente.setEnabled(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El número de factura no es válido");
            }
        }
    }//GEN-LAST:event_btGenerarVentaActionPerformed

    private void txtCantidadVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadVenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadVenderActionPerformed

    private void txtPrecioVentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVentaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaFocusLost

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
            java.util.logging.Logger.getLogger(frmFactura.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFactura.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFactura.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFactura.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFactura().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton btAñadirProductoTabla;
    private javax.swing.JButton btGenerarVenta;
    private javax.swing.JButton btListoCliente;
    public javax.swing.JComboBox<Clientes> cbCodigoCliente;
    public javax.swing.JComboBox<Productos> cbProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel jlQR;
    private javax.swing.JTable tbDatos;
    private javax.swing.JScrollPane tbProductos;
    private javax.swing.JTextField txtCantidadStock;
    private javax.swing.JTextField txtCantidadVender;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNumeroFactura;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables
private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Suponiendo que tienes un JComboBox llamado comboBox y un JTextField llamado txtCliente
}
