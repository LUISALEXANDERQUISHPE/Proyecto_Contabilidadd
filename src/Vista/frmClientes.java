package Vista;

import Clases.MySql;
import Controlador.ControlClientes;
import Modelo.AlmacenCiudad;
import Modelo.AlmacenClientes;
import Modelo.AlmacenProvincias;
import Modelo.Ciudad;
import Modelo.Provincia;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public final class frmClientes extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ControlClientes ctClie = new ControlClientes();
    AlmacenClientes almaClie = new AlmacenClientes();
    AlmacenProvincias almaProvincia = new AlmacenProvincias();
    AlmacenCiudad almaCiudad = new AlmacenCiudad();
    MySql conec = new MySql();

    public frmClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        // Cargar datos en los componentes
        ctClie.cargarCbProvincias(cbProvinciaAgregar, almaProvincia, almaClie);
        ctClie.cargarCbProvinciasModificar(cbProvinciaModificar, almaProvincia, almaClie); // Llamada única
        // Configurar modelo de tabla
        String[] titulo = new String[]{"Número de cédula", "Nombre y Apellido", "Dirección", "Provincia", "Ciudad"};
        dtm.setColumnIdentifiers(titulo);
        tbDatos.setModel(dtm);

        // Llenar tabla y mostrar ventana si la base de datos no está vacía
        boolean baseDatosVacia = ctClie.llenartbClientes(almaClie, dtm);
        if (!baseDatosVacia) {
            ctClie.mostrarTablaClientes(almaClie, dtm);
            this.setVisible(true);
        }
    }

    public void LlenarCiudades(String codigo, AlmacenCiudad almaCiudad) {
        conec.conectar();
        almaCiudad.getLista().clear();
        conec.TraerCiudades(codigo, almaCiudad);
        ArrayList<Ciudad> lista = almaCiudad.getLista();
        this.cbCiudadAgregar.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            this.cbCiudadAgregar.addItem(lista.get(i));
        }
        almaCiudad.getLista().clear();
    }

    public void LlenarCiudadesModificar(String codigo, AlmacenCiudad almaCiudad) {
        conec.conectar();
        almaCiudad.getLista().clear();
        conec.TraerCiudades(codigo, almaCiudad);
        ArrayList<Ciudad> lista1 = almaCiudad.getLista();
        this.cbCiudadModificar.removeAllItems();
        for (int i = 0; i < lista1.size(); i++) {
            this.cbCiudadModificar.addItem(lista1.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbProductos = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        btAgregarClientes = new javax.swing.JButton();
        btGenerarQr = new javax.swing.JButton();
        btEliminarCliente = new javax.swing.JButton();
        btModificarCliente = new javax.swing.JButton();
        jlQR = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreApellidoModificar = new javax.swing.JTextField();
        bt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCedulaModificar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtDireccionModificar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbProvinciaAgregar = new javax.swing.JComboBox<>();
        cbCiudadAgregar = new javax.swing.JComboBox<>();
        btBuscar = new javax.swing.JButton();
        cbProvinciaModificar = new javax.swing.JComboBox<>();
        cbCiudadModificar = new javax.swing.JComboBox<>();
        bnBuscarModificAR = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();

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
        jLabel1.setText("Clientes");
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

        jPanel1.add(tbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 680, 130));

        btAgregarClientes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAgregarClientes.setForeground(new java.awt.Color(0, 0, 0));
        btAgregarClientes.setText("Agregar");
        btAgregarClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btAgregarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAgregarClientesMouseClicked(evt);
            }
        });
        btAgregarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btAgregarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 130, 30));

        btGenerarQr.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGenerarQr.setForeground(new java.awt.Color(0, 0, 0));
        btGenerarQr.setText(" Código QR.");
        btGenerarQr.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        jPanel1.add(btGenerarQr, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, -1, 30));

        btEliminarCliente.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btEliminarCliente.setForeground(new java.awt.Color(0, 0, 0));
        btEliminarCliente.setText("Eliminar");
        btEliminarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btEliminarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEliminarClienteMouseClicked(evt);
            }
        });
        btEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 130, 30));

        btModificarCliente.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btModificarCliente.setForeground(new java.awt.Color(0, 0, 0));
        btModificarCliente.setText("Modificar");
        btModificarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btModificarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModificarClienteMouseClicked(evt);
            }
        });
        btModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btModificarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 130, 30));

        jlQR.setBackground(new java.awt.Color(255, 255, 255));
        jlQR.setForeground(new java.awt.Color(255, 255, 255));
        jlQR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlQR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jlQR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 160, 150));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Agregar un cliente a la lista.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 20));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Número de cédula:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 150, 20));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ciudad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 80, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nombre y apellido:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, -1));

        txtNombreApellido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombreApellido.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreApellidoKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 180, 30));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Dirección:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 90, 20));

        txtNombreApellidoModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombreApellidoModificar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtNombreApellidoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 170, 30));

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
        jPanel1.add(bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 520, 130, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 210, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 860, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 700, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 860, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Clientes.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 100, 80));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Eliminar un cliente de la lista. ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 180, 20));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Modificar un cliente de la lista .");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 180, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Lista de clientes.");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 20));

        txtCedula.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(0, 0, 0));
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 180, 30));

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Número de cédula:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Provincia:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 100, -1));

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Nombre y apellido:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, -1));

        txtCedulaModificar.setEditable(false);
        txtCedulaModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCedulaModificar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtCedulaModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 170, 30));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Dirección:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 110, 20));

        txtDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 180, 30));

        txtDireccionModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtDireccionModificar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtDireccionModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 170, 30));

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Provincia:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 100, -1));

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Ciudad:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 80, -1));

        cbProvinciaAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbProvinciaAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbProvinciaAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 150, 30));

        cbCiudadAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbCiudadAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbCiudadAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 160, 30));

        btBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 120, 30));

        cbProvinciaModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbProvinciaModificar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbProvinciaModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 170, 30));

        cbCiudadModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbCiudadModificar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbCiudadModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 170, 30));

        bnBuscarModificAR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bnBuscarModificAR.setForeground(new java.awt.Color(0, 0, 0));
        bnBuscarModificAR.setText("Buscar");
        bnBuscarModificAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnBuscarModificARActionPerformed(evt);
            }
        });
        jPanel1.add(bnBuscarModificAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 120, 30));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 820, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGenerarQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerarQrActionPerformed

    }//GEN-LAST:event_btGenerarQrActionPerformed

    private void btModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarClienteActionPerformed
        if (txtNombreApellidoModificar.getText().isEmpty() || txtDireccionModificar.getText().isEmpty() || cbProvinciaModificar.getSelectedItem() == null || cbCiudadModificar.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar para poder editar al cliente");
        } else {
            int aux = ctClie.EditarClientes(tbDatos, dtm, txtCedulaModificar.getText(), txtNombreApellidoModificar.getText(), txtDireccionModificar.getText(), cbProvinciaModificar.getSelectedItem().toString(), cbCiudadModificar.getSelectedItem().toString(), almaClie);
            if (aux == 1) {
                this.cbCiudadModificar.removeAllItems();
                txtNombreApellidoModificar.setText("");
                txtDireccionModificar.setText("");
                txtCedulaModificar.setText("");
            }
        }

    }//GEN-LAST:event_btModificarClienteActionPerformed

    private void btAgregarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAgregarClientesMouseClicked

    }//GEN-LAST:event_btAgregarClientesMouseClicked

    private void btAgregarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarClientesActionPerformed
        if (txtCedula.getText().isEmpty() || txtNombreApellido.getText().isEmpty() || txtDireccion.getText().isEmpty() || cbProvinciaAgregar.getSelectedItem() == null || cbCiudadAgregar.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
        } else {
            int aux = ctClie.AgregarTablClientes(tbDatos, dtm, txtCedula.getText(), txtNombreApellido.getText(), txtDireccion.getText(), cbProvinciaAgregar.getSelectedItem().toString(), cbCiudadAgregar.getSelectedItem().toString(), almaClie);
            if (aux == 1) {
                this.cbCiudadAgregar.removeAllItems();
                txtNombreApellido.setText("");
                txtDireccion.setText("");
                txtCedula.setText("");
            }
        }
    }//GEN-LAST:event_btAgregarClientesActionPerformed

    private void btGenerarQrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btGenerarQrMouseClicked
        int fila = tbDatos.getSelectedRow();
        ctClie.GenerarQr(fila, tbDatos, jlQR);
    }//GEN-LAST:event_btGenerarQrMouseClicked

    private void btModificarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModificarClienteMouseClicked

    }//GEN-LAST:event_btModificarClienteMouseClicked

    private void btEliminarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEliminarClienteMouseClicked

    }//GEN-LAST:event_btEliminarClienteMouseClicked

    private void tbDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosMouseClicked
        int fila = tbDatos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            String Cedula = (String) tbDatos.getValueAt(fila, 0);
            String NombreApe = (String) tbDatos.getValueAt(fila, 1);
            String Direccion = (String) tbDatos.getValueAt(fila, 2);
            txtCedulaModificar.setEditable(false);
            txtCedulaModificar.setText(Cedula);
            txtNombreApellidoModificar.setText(NombreApe);
            txtDireccionModificar.setText(Direccion);

        }
    }//GEN-LAST:event_tbDatosMouseClicked

    private void btMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btMouseClicked

    private void btEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarClienteActionPerformed
        int filaSeleccionada = tbDatos.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Elija el dato a eliminar en la tabla");
        } else {
            String codigo = dtm.getValueAt(filaSeleccionada, 0).toString();
            ctClie.EliminarClientes(codigo, dtm);
        }
    }//GEN-LAST:event_btEliminarClienteActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        this.dispose();
        frmInicio in = new frmInicio();
        in.setVisible(true);
    }//GEN-LAST:event_btActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        try {
            this.LlenarCiudades(this.cbProvinciaAgregar.getItemAt(this.cbProvinciaAgregar.getSelectedIndex()).getCodigoProvincia(), almaCiudad);

        } catch (Exception e) {

        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void bnBuscarModificARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnBuscarModificARActionPerformed
        try {
            this.LlenarCiudadesModificar(this.cbProvinciaModificar.getItemAt(this.cbProvinciaModificar.getSelectedIndex()).getCodigoProvincia(), almaCiudad);

        } catch (Exception e) {

        }
    }//GEN-LAST:event_bnBuscarModificARActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || this.txtCedula.getText().trim().length() == 10) {
            evt.consume();
        }

    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtNombreApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreApellidoKeyTyped

        JTextField txtNombreApellido = (JTextField) evt.getSource();

        // Obtener el texto actual en el campo de texto
        String txtCodio = txtNombreApellido.getText();
        // Verificar si se ha alcanzado el límite máximo de caracteres
        if (txtCodio.length() >= 20) {
            // Consumir el evento para evitar que se agregue el carácter adicional
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreApellidoKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        JTextField txtDireccion = (JTextField) evt.getSource();

        // Obtener el texto actual en el campo de texto
        String txtCodio = txtDireccion.getText();
        // Verificar si se ha alcanzado el límite máximo de caracteres
        if (txtCodio.length() >= 25) {
            // Consumir el evento para evitar que se agregue el carácter adicional
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

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
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnBuscarModificAR;
    private javax.swing.JButton bt;
    private javax.swing.JButton btAgregarClientes;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminarCliente;
    private javax.swing.JButton btGenerarQr;
    private javax.swing.JButton btModificarCliente;
    public javax.swing.JComboBox<Ciudad> cbCiudadAgregar;
    public javax.swing.JComboBox<Ciudad> cbCiudadModificar;
    public javax.swing.JComboBox<Provincia> cbProvinciaAgregar;
    public javax.swing.JComboBox<Provincia> cbProvinciaModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel jlQR;
    private javax.swing.JTable tbDatos;
    private javax.swing.JScrollPane tbProductos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaModificar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionModificar;
    private javax.swing.JTextField txtNombreApellido;
    private javax.swing.JTextField txtNombreApellidoModificar;
    // End of variables declaration//GEN-END:variables

}
