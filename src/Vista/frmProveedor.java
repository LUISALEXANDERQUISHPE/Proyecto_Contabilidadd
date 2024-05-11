package Vista;

import Clases.MySql;
import Controlador.ControlProveedor;
import Modelo.AlmacenCiudad;
import Modelo.AlmacenProveedor;
import Modelo.AlmacenProvincias;
import Modelo.Ciudad;
import Modelo.Provincia;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class frmProveedor extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ControlProveedor ctProve = new ControlProveedor();
    AlmacenProveedor almaProve = new AlmacenProveedor();
    AlmacenProvincias almaProvincia = new AlmacenProvincias();
    AlmacenCiudad almaCiudad = new AlmacenCiudad();
    MySql conec = new MySql();

    public frmProveedor() {
        initComponents();
        this.setLocationRelativeTo(null);

        // Cargar datos en los componentes
        ctProve.cargarCbProvincias(this.cbProvinciaAgregarProveedor, almaProvincia, almaProve);
        ctProve.cargarCbProvinciasModificar(this.cbProvinciaModificarProveedor, almaProvincia);
        // Configurar modelo de tabla
        String[] titulo = new String[]{"RUC", "Nombre y Apellido", "Teléfono", "Dirección", "Provincia", "Ciudad"};
        dtm.setColumnIdentifiers(titulo);
        tbDatos.setModel(dtm);

        // Llenar tabla y mostrar ventana si la base de datos no está vacía
        boolean baseDatosVacia = ctProve.llenartbProveedor(almaProve, dtm);
        if (!baseDatosVacia) {
            ctProve.mostrarTablaProveedor(almaProve, dtm);
            this.setVisible(true);
        }
    }

    public void LlenarCiudades(String codigo, AlmacenCiudad almaCiudad) {
        conec.conectar();
        almaCiudad.getLista().clear();
        conec.TraerCiudades(codigo, almaCiudad);
        ArrayList<Ciudad> lista = almaCiudad.getLista();
        this.cbCiudadAgregarProveedor.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            this.cbCiudadAgregarProveedor.addItem(lista.get(i));
        }
        almaCiudad.getLista().clear();
    }

    public void LlenarCiudadesModificar(String codigo, AlmacenCiudad almaCiudad) {
        conec.conectar();
        almaCiudad.getLista().clear();
        conec.TraerCiudades(codigo, almaCiudad);
        ArrayList<Ciudad> lista = almaCiudad.getLista();
        this.cbCiudadModificarProveedor.removeAllItems();
        for (int i = 0; i < lista.size(); i++) {
            this.cbCiudadModificarProveedor.addItem(lista.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbProductos = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        btAgregarProveedor = new javax.swing.JButton();
        btGenerarQr = new javax.swing.JButton();
        btModificarProveedor = new javax.swing.JButton();
        jlQR = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreApellidoProveedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreApellidoModificarProveedor = new javax.swing.JTextField();
        bt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRUCProveedor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtRUCModificarProveedor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDireccionProveedor = new javax.swing.JTextField();
        txtDireccionModificarProveedor = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTelefonoProveedor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTelefonoModificar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbProvinciaAgregarProveedor = new javax.swing.JComboBox<>();
        cbCiudadAgregarProveedor = new javax.swing.JComboBox<>();
        btBuscarAgregar = new javax.swing.JButton();
        btBuscarModificar = new javax.swing.JButton();
        cbProvinciaModificarProveedor = new javax.swing.JComboBox<>();
        cbCiudadModificarProveedor = new javax.swing.JComboBox<>();
        btEliminarPROVE = new javax.swing.JButton();
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
        jLabel1.setText("Proveedor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 440, 30));

        tbProductos.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        tbProductos.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N

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

        jPanel1.add(tbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 720, 130));

        btAgregarProveedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAgregarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        btAgregarProveedor.setText("Agregar");
        btAgregarProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btAgregarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAgregarProveedorMouseClicked(evt);
            }
        });
        btAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btAgregarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 140, 30));

        btGenerarQr.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGenerarQr.setForeground(new java.awt.Color(0, 0, 0));
        btGenerarQr.setText("Código QR.");
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
        jPanel1.add(btGenerarQr, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 120, 30));

        btModificarProveedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btModificarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        btModificarProveedor.setText("Modificar");
        btModificarProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btModificarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModificarProveedorMouseClicked(evt);
            }
        });
        btModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btModificarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 140, 30));

        jlQR.setBackground(new java.awt.Color(255, 255, 255));
        jlQR.setForeground(new java.awt.Color(255, 255, 255));
        jlQR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlQR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jlQR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 160, 140));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Agregar un proveedor a la lista.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("RUC:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 50, 20));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ciudad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 80, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nombre y apellido:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 150, -1));

        txtNombreApellidoProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombreApellidoProveedor.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreApellidoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreApellidoProveedorKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreApellidoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 210, 30));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Dirección:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 90, 20));

        txtNombreApellidoModificarProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombreApellidoModificarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreApellidoModificarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreApellidoModificarProveedorKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreApellidoModificarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 200, 30));

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
        jPanel1.add(bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 140, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 190, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 670, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 700, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 860, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Proveedor.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 110, 90));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Eliminar un proveedor de la lista. ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 200, 20));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Modificar un proveedor de la lista .");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 210, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Lista de proveedores.");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 130, 20));

        txtRUCProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtRUCProveedor.setForeground(new java.awt.Color(0, 0, 0));
        txtRUCProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRUCProveedorKeyTyped(evt);
            }
        });
        jPanel1.add(txtRUCProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 210, 30));

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("RUC:");
        jLabel13.setFocusable(false);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, -1));

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Provincia:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 100, 30));

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Nombre y apellido:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, -1));

        txtRUCModificarProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtRUCModificarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtRUCModificarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 200, 30));

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Dirección:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 110, 20));

        txtDireccionProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtDireccionProveedor.setForeground(new java.awt.Color(0, 0, 0));
        txtDireccionProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionProveedorKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccionProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 210, 30));

        txtDireccionModificarProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtDireccionModificarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        txtDireccionModificarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionModificarProveedorKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccionModificarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 200, 30));

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Teléfono:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 100, -1));

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Ciudad:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 80, -1));

        txtTelefonoProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtTelefonoProveedor.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefonoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoProveedorKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 180, 30));

        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Provincia:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 80, -1));

        txtTelefonoModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtTelefonoModificar.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefonoModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoModificarKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefonoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 190, 30));

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Teléfono:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 100, -1));

        cbProvinciaAgregarProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbProvinciaAgregarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbProvinciaAgregarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 180, 30));

        cbCiudadAgregarProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbCiudadAgregarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbCiudadAgregarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 140, 30));

        btBuscarAgregar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btBuscarAgregar.setText("Buscar");
        btBuscarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscarAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        btBuscarModificar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btBuscarModificar.setText("Buscar");
        btBuscarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscarModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 70, 30));

        cbProvinciaModificarProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbProvinciaModificarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbProvinciaModificarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 190, 30));

        cbCiudadModificarProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbCiudadModificarProveedor.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbCiudadModificarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 130, 30));

        btEliminarPROVE.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEliminarPROVE.setForeground(new java.awt.Color(0, 0, 0));
        btEliminarPROVE.setText("Eliminar");
        btEliminarPROVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarPROVEActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminarPROVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, 140, 30));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 10, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarProveedorActionPerformed
        if (txtRUCModificarProveedor.getText().isEmpty() || txtNombreApellidoModificarProveedor.getText().isEmpty() || txtTelefonoModificar.getText().isEmpty() || txtDireccionModificarProveedor.getText().isEmpty() || cbProvinciaModificarProveedor.getSelectedItem() == null || cbCiudadModificarProveedor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
        } else {
            int xua = ctProve.EditarProveedor(tbDatos, dtm, txtRUCModificarProveedor.getText(), txtNombreApellidoModificarProveedor.getText(), txtTelefonoModificar.getText(), txtDireccionModificarProveedor.getText(), cbProvinciaModificarProveedor.getSelectedItem().toString(), cbCiudadModificarProveedor.getSelectedItem().toString(), almaProve);
            if (xua == 1) {
                this.cbCiudadModificarProveedor.removeAllItems();
                txtRUCModificarProveedor.setText("");
                txtNombreApellidoModificarProveedor.setText("");
                txtTelefonoProveedor.setText("");
                txtDireccionModificarProveedor.setText("");
            }

        }
    }//GEN-LAST:event_btModificarProveedorActionPerformed

    private void btAgregarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAgregarProveedorMouseClicked
        if (txtRUCProveedor.getText().isEmpty() || txtNombreApellidoProveedor.getText().isEmpty() || txtTelefonoProveedor.getText().isEmpty() || txtDireccionProveedor.getText().isEmpty() || cbProvinciaAgregarProveedor.getSelectedItem() == null || cbCiudadAgregarProveedor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
        } else {
            int aux = ctProve.AgregarTablProveedor(tbDatos, dtm, txtRUCProveedor.getText(), txtNombreApellidoProveedor.getText(), txtTelefonoProveedor.getText(), txtDireccionProveedor.getText(), cbProvinciaAgregarProveedor.getSelectedItem().toString(), cbCiudadAgregarProveedor.getSelectedItem().toString(), almaProve);
            if (aux == 1) {
                txtRUCProveedor.setText("");
                this.cbCiudadAgregarProveedor.removeAllItems();
                txtNombreApellidoProveedor.setText("");
                txtTelefonoProveedor.setText("");
                txtDireccionProveedor.setText("");
            }
        }
    }//GEN-LAST:event_btAgregarProveedorMouseClicked

    private void btAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAgregarProveedorActionPerformed

    private void btModificarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModificarProveedorMouseClicked

    }//GEN-LAST:event_btModificarProveedorMouseClicked

    private void tbDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosMouseClicked
        int fila = tbDatos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            String RUC = (String) tbDatos.getValueAt(fila, 0);
            String NombreApe = (String) tbDatos.getValueAt(fila, 1);
            String Direccion = (String) tbDatos.getValueAt(fila, 3);
            String telefono = (String) tbDatos.getValueAt(fila, 2);
            txtRUCModificarProveedor.setEditable(false);
            txtRUCModificarProveedor.setText(RUC);
            txtNombreApellidoModificarProveedor.setText(NombreApe);
            txtDireccionModificarProveedor.setText(Direccion);
            txtTelefonoModificar.setText(telefono);

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

    private void btGenerarQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerarQrActionPerformed
        int fila = tbDatos.getSelectedRow();
        ctProve.GenerarQr(fila, tbDatos, jlQR);
    }//GEN-LAST:event_btGenerarQrActionPerformed

    private void btGenerarQrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btGenerarQrMouseClicked

    }//GEN-LAST:event_btGenerarQrMouseClicked

    private void btBuscarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarAgregarActionPerformed
        try {
            System.out.println("es el codigo" + this.cbProvinciaAgregarProveedor.getItemAt(this.cbProvinciaAgregarProveedor.getSelectedIndex()).getCodigoProvincia());
            this.LlenarCiudades(this.cbProvinciaAgregarProveedor.getItemAt(this.cbProvinciaAgregarProveedor.getSelectedIndex()).getCodigoProvincia(), almaCiudad);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btBuscarAgregarActionPerformed

    private void btBuscarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarModificarActionPerformed
        try {
            this.LlenarCiudadesModificar(this.cbProvinciaModificarProveedor.getItemAt(this.cbProvinciaModificarProveedor.getSelectedIndex()).getCodigoProvincia(), almaCiudad);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btBuscarModificarActionPerformed

    private void btEliminarPROVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarPROVEActionPerformed
        int filaSeleccionada = tbDatos.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Elija el dato a eliminar en la tabla");
        } else {
            String codigo = dtm.getValueAt(filaSeleccionada, 0).toString();
            ctProve.EliminarProveedor(dtm, codigo);
        }
    }//GEN-LAST:event_btEliminarPROVEActionPerformed

    private void txtRUCProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCProveedorKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || this.txtRUCProveedor.getText().trim().length() == 13) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRUCProveedorKeyTyped

    private void txtNombreApellidoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreApellidoProveedorKeyTyped
        char c = evt.getKeyChar();
        String text = this.txtNombreApellidoProveedor.getText().trim();

        if (!Character.isLetter(c) && (c != KeyEvent.VK_SPACE && text.contains(" "))) {
            evt.consume(); // Evita ingresar caracteres no permitidos o más de un espacio
        }
    }//GEN-LAST:event_txtNombreApellidoProveedorKeyTyped

    private void txtDireccionProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionProveedorKeyTyped
        char c = evt.getKeyChar();
        String text = this.txtDireccionProveedor.getText().trim();

        if (!Character.isLetter(c) && (c != KeyEvent.VK_SPACE && text.contains(" "))) {
            evt.consume(); // Evita ingresar caracteres no permitidos o más de un espacio
        }
    }//GEN-LAST:event_txtDireccionProveedorKeyTyped

    private void txtTelefonoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || this.txtTelefonoProveedor.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoProveedorKeyTyped

    private void txtNombreApellidoModificarProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreApellidoModificarProveedorKeyTyped
        char c = evt.getKeyChar();
        String text = this.txtNombreApellidoModificarProveedor.getText().trim();

        if (!Character.isLetter(c) && (c != KeyEvent.VK_SPACE && text.contains(" "))) {
            evt.consume(); // Evita ingresar caracteres no permitidos o más de un espacio
        }
    }//GEN-LAST:event_txtNombreApellidoModificarProveedorKeyTyped

    private void txtDireccionModificarProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionModificarProveedorKeyTyped
        char c = evt.getKeyChar();
        String text = this.txtDireccionModificarProveedor.getText().trim();

        if (!Character.isLetter(c) && (c != KeyEvent.VK_SPACE && text.contains(" "))) {
            evt.consume(); // Evita ingresar caracteres no permitidos o más de un espacio
        }
    }//GEN-LAST:event_txtDireccionModificarProveedorKeyTyped

    private void txtTelefonoModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoModificarKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || this.txtTelefonoModificar.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoModificarKeyTyped

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
            java.util.logging.Logger.getLogger(frmProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProveedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProveedor.class
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JButton btAgregarProveedor;
    private javax.swing.JButton btBuscarAgregar;
    private javax.swing.JButton btBuscarModificar;
    private javax.swing.JButton btEliminarPROVE;
    private javax.swing.JButton btGenerarQr;
    private javax.swing.JButton btModificarProveedor;
    public javax.swing.JComboBox<Ciudad> cbCiudadAgregarProveedor;
    public javax.swing.JComboBox<Ciudad> cbCiudadModificarProveedor;
    public javax.swing.JComboBox<Provincia> cbProvinciaAgregarProveedor;
    public javax.swing.JComboBox<Provincia> cbProvinciaModificarProveedor;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JTextField txtDireccionModificarProveedor;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtNombreApellidoModificarProveedor;
    private javax.swing.JTextField txtNombreApellidoProveedor;
    private javax.swing.JTextField txtRUCModificarProveedor;
    private javax.swing.JTextField txtRUCProveedor;
    private javax.swing.JTextField txtTelefonoModificar;
    private javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables

}
