package Vista;

import Modelo.Permisos;
import Modelo.Variable;
import javax.swing.JOptionPane;

public class frmInicio extends javax.swing.JFrame {
    //  Permisos p1 = Variable.p;

    public Permisos aux1;

    public frmInicio() {
        initComponents();
        this.setLocationRelativeTo(this);

    }

    public boolean asignarPermisosProductos(Permisos p) {
        boolean aux = Variable.getP().getProductos();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    public boolean asignarPermisosProveedor(Permisos p) {
        boolean aux = Variable.getP().getProveedor();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    public boolean asignarPermisosFactura(Permisos p) {
        boolean aux = Variable.getP().getFactura();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    public boolean asignarPermisosCompra(Permisos p) {
        boolean aux = Variable.getP().getCompra();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    public boolean asignarPermisosKardex(Permisos p) {
        boolean aux = Variable.getP().getKardex();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    public boolean asignarPermisosProvincia(Permisos p) {
        boolean aux = Variable.getP().getProvincia();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    public boolean asignarPermisosCiudad(Permisos p) {
        boolean aux = Variable.getP().getCiudad();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    public boolean asignarPermisosListVe(Permisos p) {
        boolean aux = Variable.getP().getListaVen();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    public boolean asignarPermisosControlU(Permisos p) {
        boolean aux = Variable.getP().getGestionUsers();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    public boolean asignarPermisosListC(Permisos p) {
        boolean aux = Variable.getP().getListaCon();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    public boolean asignarPermisosClientes(Permisos p) {
        boolean aux = Variable.getP().getClientes();
        return aux; // Si todos los elementos tienen getProductos() en true, retornamos true.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPProductos = new javax.swing.JPanel();
        PnClientes = new javax.swing.JPanel();
        JpProveedor = new javax.swing.JPanel();
        jPFactura = new javax.swing.JPanel();
        jPCompra = new javax.swing.JPanel();
        jPKardex = new javax.swing.JPanel();
        jPProvincia = new javax.swing.JPanel();
        jPCiudad = new javax.swing.JPanel();
        jPListaVentas = new javax.swing.JPanel();
        jPListaCompras = new javax.swing.JPanel();
        jPGestionUsuarios = new javax.swing.JPanel();
        jPSalir = new javax.swing.JPanel();
        Menu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Productos");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 160, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Proveedor");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 150, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Clientes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 140, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Factura");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 140, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Compras");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 140, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Kardex");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 195, 140, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Provincia");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 130, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ciudad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 120, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ventas ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 120, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Lista de ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 140, 50));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Listado de");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 190, 50));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Compras");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 120, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Gestion de Usuarios ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 210, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("y Permisos");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 130, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Salir");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 320, 110, -1));

        jPProductos.setOpaque(false);
        jPProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPProductosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPProductosLayout = new javax.swing.GroupLayout(jPProductos);
        jPProductos.setLayout(jPProductosLayout);
        jPProductosLayout.setHorizontalGroup(
            jPProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPProductosLayout.setVerticalGroup(
            jPProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        jPanel1.add(jPProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, 180));

        PnClientes.setOpaque(false);
        PnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PnClientesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PnClientesLayout = new javax.swing.GroupLayout(PnClientes);
        PnClientes.setLayout(PnClientesLayout);
        PnClientesLayout.setHorizontalGroup(
            PnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        PnClientesLayout.setVerticalGroup(
            PnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel1.add(PnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 140, 130));

        JpProveedor.setOpaque(false);
        JpProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JpProveedorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JpProveedorLayout = new javax.swing.GroupLayout(JpProveedor);
        JpProveedor.setLayout(JpProveedorLayout);
        JpProveedorLayout.setHorizontalGroup(
            JpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        JpProveedorLayout.setVerticalGroup(
            JpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(JpProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 130, 120));

        jPFactura.setOpaque(false);
        jPFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPFacturaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPFacturaLayout = new javax.swing.GroupLayout(jPFactura);
        jPFactura.setLayout(jPFacturaLayout);
        jPFacturaLayout.setHorizontalGroup(
            jPFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPFacturaLayout.setVerticalGroup(
            jPFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 130, 120));

        jPCompra.setOpaque(false);
        jPCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPCompraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPCompraLayout = new javax.swing.GroupLayout(jPCompra);
        jPCompra.setLayout(jPCompraLayout);
        jPCompraLayout.setHorizontalGroup(
            jPCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPCompraLayout.setVerticalGroup(
            jPCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 150, 120));

        jPKardex.setOpaque(false);
        jPKardex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPKardexMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPKardexLayout = new javax.swing.GroupLayout(jPKardex);
        jPKardex.setLayout(jPKardexLayout);
        jPKardexLayout.setHorizontalGroup(
            jPKardexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPKardexLayout.setVerticalGroup(
            jPKardexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jPanel1.add(jPKardex, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 130, 110));

        jPProvincia.setOpaque(false);
        jPProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPProvinciaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPProvinciaLayout = new javax.swing.GroupLayout(jPProvincia);
        jPProvincia.setLayout(jPProvinciaLayout);
        jPProvinciaLayout.setHorizontalGroup(
            jPProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPProvinciaLayout.setVerticalGroup(
            jPProvinciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel1.add(jPProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 130, 130));

        jPCiudad.setOpaque(false);
        jPCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPCiudadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPCiudadLayout = new javax.swing.GroupLayout(jPCiudad);
        jPCiudad.setLayout(jPCiudadLayout);
        jPCiudadLayout.setHorizontalGroup(
            jPCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPCiudadLayout.setVerticalGroup(
            jPCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel1.add(jPCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 120, 130));

        jPListaVentas.setOpaque(false);
        jPListaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPListaVentasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPListaVentasLayout = new javax.swing.GroupLayout(jPListaVentas);
        jPListaVentas.setLayout(jPListaVentasLayout);
        jPListaVentasLayout.setHorizontalGroup(
            jPListaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPListaVentasLayout.setVerticalGroup(
            jPListaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPListaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 110, 120));

        jPListaCompras.setOpaque(false);
        jPListaCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPListaComprasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPListaComprasLayout = new javax.swing.GroupLayout(jPListaCompras);
        jPListaCompras.setLayout(jPListaComprasLayout);
        jPListaComprasLayout.setHorizontalGroup(
            jPListaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPListaComprasLayout.setVerticalGroup(
            jPListaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPListaCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 120, 120));

        jPGestionUsuarios.setOpaque(false);
        jPGestionUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPGestionUsuariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPGestionUsuariosLayout = new javax.swing.GroupLayout(jPGestionUsuarios);
        jPGestionUsuarios.setLayout(jPGestionUsuariosLayout);
        jPGestionUsuariosLayout.setHorizontalGroup(
            jPGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPGestionUsuariosLayout.setVerticalGroup(
            jPGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPGestionUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 120, 120));

        jPSalir.setOpaque(false);
        jPSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPSalirLayout = new javax.swing.GroupLayout(jPSalir);
        jPSalir.setLayout(jPSalirLayout);
        jPSalirLayout.setHorizontalGroup(
            jPSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPSalirLayout.setVerticalGroup(
            jPSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel1.add(jPSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, 140, 130));

        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/fondoMneu.png"))); // NOI18N
        Menu.setText("jLabel1");
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMouseClicked(evt);
            }
        });
        jPanel1.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPProductosMouseClicked
        boolean prod = asignarPermisosProductos(aux1);
        System.out.println("el valor de la variable es " + prod);
        if (prod == true) {
            frmProductos ventanaProductos = new frmProductos();
            ventanaProductos.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");

        }

    }//GEN-LAST:event_jPProductosMouseClicked

    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked

    }//GEN-LAST:event_MenuMouseClicked

    private void JpProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JpProveedorMouseClicked
        boolean prove = asignarPermisosProveedor(aux1);
        if (prove == true) {
            frmProveedor frmProve = new frmProveedor();
            frmProve.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");
        }
    }//GEN-LAST:event_JpProveedorMouseClicked

    private void jPFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPFacturaMouseClicked
        boolean fac = asignarPermisosFactura(aux1);
        if (fac == true) {
            frmFactura frmFact = new frmFactura();
            frmFact.setVisible(true);
            frmFact.pack();
            frmFact.setTitle("Factura");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");
        }
    }//GEN-LAST:event_jPFacturaMouseClicked

    private void jPCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCompraMouseClicked
        boolean Compra = asignarPermisosCompra(aux1);
        if (Compra == true) {
            frmFacturaCompras frmFacCompr = new frmFacturaCompras();
            frmFacCompr.setVisible(true);
            frmFacCompr.pack();
            frmFacCompr.setTitle("Factura - Compra");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");
        }
    }//GEN-LAST:event_jPCompraMouseClicked

    private void jPKardexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPKardexMouseClicked
        boolean karx = asignarPermisosKardex(aux1);
        if (karx == true) {
            frmKardex frmKar = new frmKardex();
            frmKar.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");
        }
    }//GEN-LAST:event_jPKardexMouseClicked

    private void jPProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPProvinciaMouseClicked
        boolean prov = asignarPermisosProvincia(aux1);
        if (prov == true) {
            frmProvincia frmPRO = new frmProvincia();
            frmPRO.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");
        }
    }//GEN-LAST:event_jPProvinciaMouseClicked

    private void jPCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCiudadMouseClicked
        boolean ciudad = asignarPermisosCiudad(aux1);
        if (ciudad == true) {
            frmCiudad frmciu = new frmCiudad();
            frmciu.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");
        }
    }//GEN-LAST:event_jPCiudadMouseClicked

    private void jPListaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPListaVentasMouseClicked
        boolean listven = asignarPermisosListVe(aux1);
        if (listven == true) {
            frmListaVentas frmlistVen = new frmListaVentas();
            frmlistVen.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");
        }
    }//GEN-LAST:event_jPListaVentasMouseClicked

    private void jPSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPSalirMouseClicked
     frmLogin  frmlog = new frmLogin();
     frmlog.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jPSalirMouseClicked

    private void jPGestionUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPGestionUsuariosMouseClicked
        boolean cUser = asignarPermisosControlU(aux1);
        if (cUser == true) {
            frmControlIngresoGestio controlUsuarios = new frmControlIngresoGestio();
            controlUsuarios.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");
        }
    }//GEN-LAST:event_jPGestionUsuariosMouseClicked

    private void jPListaComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPListaComprasMouseClicked
        boolean lisc = asignarPermisosListC(aux1);
        if (lisc == true) {
            frmListaCompras frmCompr = new frmListaCompras();
            frmCompr.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");
        }
    }//GEN-LAST:event_jPListaComprasMouseClicked

    private void PnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PnClientesMouseClicked
        boolean clien = asignarPermisosClientes(aux1);
        if (clien == true) {
            frmClientes frmclien = new frmClientes();
            frmclien.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "\"No tiene acceso a esta opción\".\n\nGracias.");
        }
    }//GEN-LAST:event_PnClientesMouseClicked

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
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpProveedor;
    private javax.swing.JLabel Menu;
    private javax.swing.JPanel PnClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPCiudad;
    private javax.swing.JPanel jPCompra;
    private javax.swing.JPanel jPFactura;
    private javax.swing.JPanel jPGestionUsuarios;
    private javax.swing.JPanel jPKardex;
    private javax.swing.JPanel jPListaCompras;
    private javax.swing.JPanel jPListaVentas;
    private javax.swing.JPanel jPProductos;
    private javax.swing.JPanel jPProvincia;
    private javax.swing.JPanel jPSalir;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
