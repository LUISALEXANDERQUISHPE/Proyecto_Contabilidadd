package Vista;

import Clases.MySql;
import Controlador.ControlFacturaCompras;
import Modelo.AlmacenFactComprasProductos;
import Modelo.AlmacenFacturaCompras;
import Modelo.AlmacenProductos;
import Modelo.AlmacenProveedor;
import Modelo.Productos;
import Modelo.Proveedor;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class frmFacturaCompras extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ControlFacturaCompras ctFactCompr = new ControlFacturaCompras();
    AlmacenProductos almaProduc = new AlmacenProductos();
    AlmacenProveedor almaProve = new AlmacenProveedor();
    AlmacenFacturaCompras almaFacCompras = new AlmacenFacturaCompras();
    AlmacenFactComprasProductos almaFactProducComp = new AlmacenFactComprasProductos();
    MySql conec = new MySql();

    public frmFacturaCompras() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
        this.setTitle("FACTURA  -   COMPRAS");
        // Cargar datos en los componentes
        ctFactCompr.cargarProveedor(this.cbProveedor, almaProve);
        // Configurar modelo de tabla
        String[] titulo = new String[]{"N°FACTURA", "CÓDIGO PRODUCTO", "PRODUCTO", "CANTIDAD", "PRECIO.UNI", "SUBTOTAL"};
        dtm.setColumnIdentifiers(titulo);
        tbDatos.setModel(dtm);
        txtNumeroFactura.setEditable(false);
        txtFecha.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbProductos = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        btAñadirProductoTablaCompra = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTotalCompra = new javax.swing.JTextField();
        bt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCantidadComprar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btCrearProveedor = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtFecha = new javax.swing.JTextField();
        cbProveedor = new javax.swing.JComboBox<>();
        cbProductos = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtNumeroFactura = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btGenerarCompra = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodCompra = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 40));

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

        jPanel1.add(tbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 790, 130));

        btAñadirProductoTablaCompra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAñadirProductoTablaCompra.setForeground(new java.awt.Color(0, 0, 0));
        btAñadirProductoTablaCompra.setText("Añadir ");
        btAñadirProductoTablaCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btAñadirProductoTablaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAñadirProductoTablaCompraMouseClicked(evt);
            }
        });
        btAñadirProductoTablaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirProductoTablaCompraActionPerformed(evt);
            }
        });
        jPanel1.add(btAñadirProductoTablaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 150, 30));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Total a pagar:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 130, 20));

        txtTotalCompra.setEditable(false);
        txtTotalCompra.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        txtTotalCompra.setForeground(new java.awt.Color(153, 0, 0));
        txtTotalCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCompraActionPerformed(evt);
            }
        });
        jPanel1.add(txtTotalCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 130, 40));

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
        jPanel1.add(bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 520, 110, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 10, 330));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 790, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 810, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/factura (2).png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 110, 100));

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("FECHA.");
        jLabel13.setFocusable(false);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 130, -1));

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("COD. COMPRA");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 110, -1));

        txtPrecioCompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPrecioCompra.setForeground(new java.awt.Color(0, 0, 0));
        txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 80, 30));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("N° FACTURA");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 150, 20));

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("PRODUCTO.");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 100, -1));

        txtCantidadComprar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCantidadComprar.setForeground(new java.awt.Color(0, 0, 0));
        txtCantidadComprar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadComprarKeyTyped(evt);
            }
        });
        jPanel1.add(txtCantidadComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 80, 30));

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("PRECIO.");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 80, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 800, 10));

        btCrearProveedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCrearProveedor.setForeground(new java.awt.Color(0, 0, 0));
        btCrearProveedor.setText("Crear");
        btCrearProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btCrearProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCrearProveedorMouseClicked(evt);
            }
        });
        btCrearProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btCrearProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 140, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Lista  de compras.");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, 20));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 10, 390));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(204, 204, 255));
        txtFecha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 170, 30));

        cbProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbProveedor.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 190, 30));

        cbProductos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbProductos.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 190, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Añadir el producto a la lista.");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 190, 20));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Una vez seleccionado al proveedor,");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 230, 20));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText(" presiona \"Crear\" para crear la factura. ");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 770, 10));

        txtNumeroFactura.setEditable(false);
        txtNumeroFactura.setBackground(new java.awt.Color(255, 226, 72));
        txtNumeroFactura.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtNumeroFactura.setForeground(new java.awt.Color(0, 0, 0));
        txtNumeroFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 70, 60));

        jLabel24.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Productos");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 110, 20));

        jLabel25.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("CANTIDAD.");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 100, -1));

        btGenerarCompra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGenerarCompra.setForeground(new java.awt.Color(0, 0, 0));
        btGenerarCompra.setText("Generar venta");
        btGenerarCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btGenerarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarCompraActionPerformed(evt);
            }
        });
        jPanel1.add(btGenerarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 150, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Factura - compras");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 300, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/toyota.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 60, 60));

        txtCodCompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCodCompra.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtCodCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 190, 30));

        jLabel26.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("PROVEEDOR. ");
        jLabel26.setFocusable(false);
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/toyota.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 400, 60, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/toyota.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 60, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/toyota.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, 60, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/toyota.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 280, 60, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/toyota.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 340, 60, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAñadirProductoTablaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirProductoTablaCompraActionPerformed
        String PrecioCompra = txtPrecioCompra.getText();
        String CantidadComprar = txtCantidadComprar.getText();
        String numFac = txtNumeroFactura.getText();

        if ("-1".equals(numFac)) {
            JOptionPane.showMessageDialog(null, "No se creó la factura, vuelva a intentarlo");
            return;
        } else {
            if (numFac.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe primero elegir al proveedor para continuar con la Compra");
                return;
            }

            int numeroFactura = 0;
            try {
                numeroFactura = Integer.parseInt(numFac);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El número de factura no es válido");
                return;
            }

            if (PrecioCompra.isEmpty() || CantidadComprar.isEmpty()
                    || !ValidacionFormatoNumero(PrecioCompra) || !ValidacionFormatoNumero(CantidadComprar)
                    || Integer.parseInt(CantidadComprar) <= 0 || Double.parseDouble(PrecioCompra) <= 0) {
                JOptionPane.showMessageDialog(null, "Faltan datos o los valores ingresados no son válidos en el campo Productos");
                return;
            }

            double precioCompra = 0.0;
            int cantidadCompra = 0;

            try {
                precioCompra = Double.parseDouble(PrecioCompra);
                cantidadCompra = Integer.parseInt(CantidadComprar);

                ctFactCompr.AgregarProductoFacturCompras(numeroFactura,
                        this.cbProductos.getItemAt(this.cbProductos.getSelectedIndex()).getCodigoProducto(),
                        cbProductos.getItemAt(cbProductos.getSelectedIndex()).getNombreProducto(),
                        cantidadCompra, precioCompra, almaFacCompras, dtm, almaFactProducComp, txtFecha.getText());
                txtPrecioCompra.setText("");
                txtCantidadComprar.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El formato de precio o cantidad no es válido");
            }
        }

    }//GEN-LAST:event_btAñadirProductoTablaCompraActionPerformed
// Método para verificar el formato numérico con un solo punto decimal

    private boolean ValidacionFormatoNumero(String number) {
        // Comprobar si hay más de un punto decimal en la cadena
        int decimalCount = 0;
        for (char c : number.toCharArray()) {
            if (c == '.') {
                decimalCount++;
                if (decimalCount > 1) {
                    return false;
                }
            }
        }

        // Verificar si la cadena se puede convertir en un número
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void btAñadirProductoTablaCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAñadirProductoTablaCompraMouseClicked

    }//GEN-LAST:event_btAñadirProductoTablaCompraMouseClicked

    private void tbDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosMouseClicked
        int fila = tbDatos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            tbDatos.setSelectionBackground(Color.BLUE);
            tbDatos.setSelectionForeground(Color.WHITE);
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

    private void btCrearProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCrearProveedorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btCrearProveedorMouseClicked

    private void btCrearProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearProveedorActionPerformed

        if (txtCodCompra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar en el apartado de Proveedor");
        } else {
            txtTotalCompra.setText("");
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fecha = fechaHoraActual.format(formatter);
            txtFecha.setText(fecha);
            txtFecha.setEditable(false);
            this.cbProductos.removeAllItems();
            ctFactCompr.InsertarFacturaCompras(this.cbProveedor.getItemAt(this.cbProveedor.getSelectedIndex()).getNombreApellido(), txtCodCompra.getText(), this.cbProveedor.getItemAt(this.cbProveedor.getSelectedIndex()).getRuc(), fecha, txtNumeroFactura);
            ctFactCompr.cargarcbProductosRelacionados(almaProduc, this.cbProveedor.getItemAt(this.cbProveedor.getSelectedIndex()).getRuc(), this.cbProductos);
            txtCodCompra.setEditable(false);

            this.cbProveedor.setEnabled(false);
            this.cbProveedor.setEditable(false);
            btCrearProveedor.setEnabled(false);
            btAñadirProductoTablaCompra.setEnabled(true);
        }
    }//GEN-LAST:event_btCrearProveedorActionPerformed

    private void txtPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyTyped
        char c = evt.getKeyChar();
        String text = txtPrecioCompra.getText();

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

    }//GEN-LAST:event_txtPrecioCompraKeyTyped

    private void txtCantidadComprarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadComprarKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || this.txtCantidadComprar.getText().trim().length() >= 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadComprarKeyTyped

    private void btGenerarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerarCompraActionPerformed
        String numFacText = txtNumeroFactura.getText();

        if (numFacText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, primero debe crear la factura con los productos correspondientes antes de generar la venta total y, por ende, la factura.");
        } else {
            try {
                int numeroFactura = Integer.parseInt(numFacText);
                ctFactCompr.SacarTotalFac(almaFacCompras, numeroFactura, txtTotalCompra);
                JOptionPane.showMessageDialog(null, "Se ha creado la factura de compra con éxito. Gracias");
                txtNumeroFactura.setText("");
                txtNumeroFactura.setEditable(false);
                dtm.setRowCount(0);
                txtFecha.setText("");
                txtCodCompra.setText("");
                txtNumeroFactura.setEditable(false);
                txtCodCompra.setEditable(true);
                this.cbProveedor.setEnabled(true);
                this.cbProductos.removeAllItems();
                btCrearProveedor.setEnabled(true);
                btAñadirProductoTablaCompra.setEnabled(false);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El número de factura no es válido");
            }
        }
    }//GEN-LAST:event_btGenerarCompraActionPerformed

    private void txtTotalCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalCompraActionPerformed

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
            java.util.logging.Logger.getLogger(frmFacturaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFacturaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFacturaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFacturaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmFacturaCompras().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton btAñadirProductoTablaCompra;
    private javax.swing.JButton btCrearProveedor;
    private javax.swing.JButton btGenerarCompra;
    public javax.swing.JComboBox<Productos> cbProductos;
    public javax.swing.JComboBox<Proveedor> cbProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable tbDatos;
    private javax.swing.JScrollPane tbProductos;
    private javax.swing.JTextField txtCantidadComprar;
    private javax.swing.JTextField txtCodCompra;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNumeroFactura;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtTotalCompra;
    // End of variables declaration//GEN-END:variables
private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Suponiendo que tienes un JComboBox llamado comboBox y un JTextField llamado txtCliente
}
