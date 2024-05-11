package Clases;

import Modelo.AlmacenCiudad;
import Modelo.AlmacenClientes;
import Modelo.AlmacenFactComprasProductos;
import Modelo.AlmacenFactura;
import Modelo.AlmacenFacturaCompras;
import Modelo.AlmacenKardex;
import Modelo.AlmacenKardexCompras;
import Modelo.AlmacenKardexVentas;
import Modelo.AlmacenListaCompras;
import Modelo.AlmacenListaVentas;
import Modelo.AlmacenPermisos;
import Modelo.AlmacenProductoFac;
import Modelo.AlmacenProductos;
import Modelo.AlmacenProveedor;
import Modelo.AlmacenProvincias;
import Modelo.Ciudad;
import Modelo.Clientes;
import Modelo.Factura;
import Modelo.FacturaCompras;
import Modelo.Kardex;
import Modelo.KardexCompras;
import Modelo.KardexVentas;
import Modelo.ListaCompras;
import Modelo.ListaVentas;
import Modelo.Permisos;
import Modelo.ProductoFac;
import Modelo.Productos;
import Modelo.ProductosFactCompras;
import Modelo.Proveedor;
import Modelo.Provincia;
import Modelo.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MySql extends Login {

    private static final String url = "jdbc:mysql://localhost:3306/proyecto?autoReconnect=true&useSSL=false";//jbdc java data base conexion
    private static final String driver = "com.mysql.cj.jdbc.Driver";//para hacer  conexciones de redes
    public static Connection con;
    public static ResultSet rs;//me permite capturar todo lo que me devuelva 0 lineas hasta 100lineas
    public static PreparedStatement ps;

    @Override
    public void conectar() {//libreria conecxion
        con = null;//se pone null por que reseteamos .sino hacemos eso la tarjeta de red se hace lenta
        super.setUser("root");
        super.setClave("root");
        try {
            Class.forName(driver);//me devuelve sql
            con = (Connection) DriverManager.getConnection(url, super.getUser(), super.getClave());//hacemos conexion
            if (con != null) {
                System.out.println("Se conecto");
            } else {
                JOptionPane.showMessageDialog(null, "No existe conexión con la base de datos");

            }
        } catch (ClassNotFoundException e) {//catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
        }
    }

    public void cerraConexion() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Conexión cerrada exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public boolean insertarNuevoUsuario(String usuario, String contraseña, boolean productos, boolean clientes, boolean proveedor, boolean factura, boolean compra, boolean kardex, boolean provincia, boolean ciudad, boolean lisven, boolean liscom, boolean permiso) {
        boolean aux = true;
        try {
            Statement st = con.createStatement();
            String query = "INSERT INTO login (usuario, contraseña, intentos, productos, clientes, proveedor, factura, compra, kardex, provincia, ciudad, lisVen, listcom, permiso) "
                    + "VALUES ('" + usuario + "', '" + contraseña + "', 0, " + productos + ", " + clientes + ", " + proveedor + ", " + factura + ", " + compra + ", " + kardex + ", " + provincia + ", " + ciudad + ", " + lisven + ", " + liscom + ", " + permiso + ")";

            st.executeUpdate(query);
            aux = true;
        } catch (SQLException ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Ya existe este usuario, por favor ingrese otro nombre.");
                aux = false;
            }
        }

        return aux;
    }

    public void seleccionarUsuarios(AlmacenPermisos almaPermisos) {
        try {
            ps = con.prepareStatement("select * from login");
            rs = ps.executeQuery();
            int intento = 0;
            while (rs.next()) {
                String User = rs.getString("usuario");
                String Clave = rs.getString("contraseña");
                if (rs.getString("intentos") == null) {
                    intento = 0;
                } else {
                    intento = Integer.parseInt(rs.getString("intentos"));
                }
                Permisos perm = new Permisos(User, Clave, intento);
                almaPermisos.AgregarPermisosArray(perm);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void update(Permisos p) throws SQLException {
        conectar();
        String query = "UPDATE login SET intentos = ? WHERE usuario = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, p.getIntento());
        ps.setString(2, p.getUsuario());
        ps.executeUpdate();
        ps.close();
    }

    public Permisos traerPermisos(String usuario) {
        try {
            Permisos perm = null;
            String query = "SELECT productos, clientes, proveedor, factura, compra, kardex, provincia, ciudad, lisVen, listcom, permiso FROM login WHERE usuario = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                boolean productos = rs.getBoolean("productos");
                boolean clientes = rs.getBoolean("clientes");
                boolean proveedor = rs.getBoolean("proveedor");
                boolean factura = rs.getBoolean("factura");
                boolean compra = rs.getBoolean("compra");
                boolean kardex = rs.getBoolean("kardex");
                boolean provincia = rs.getBoolean("provincia");
                boolean ciudad = rs.getBoolean("ciudad");
                boolean listven = rs.getBoolean("lisVen");
                boolean liscom = rs.getBoolean("listcom");
                boolean permi = rs.getBoolean("permiso");
                perm = new Permisos(productos, clientes, proveedor, factura, compra, kardex, provincia, ciudad, listven, liscom, permi);

                System.out.println("El permiso traído de productos es: " + productos);
            }

            rs.close();
            ps.close();

            return perm;
        } catch (SQLException e) {
            System.out.println("El error ocurrió al traer los permisos con el usuario enviado: " + e);
            return null;
        }
    }

    //--------------------------------------Productos
    public void seleccionarProductos(AlmacenProductos almaProductos) {
        almaProductos.getLista().clear();
        try {
            ps = con.prepareStatement("select * from productos");
            rs = ps.executeQuery();
            while (rs.next()) {
                String codProvedor = rs.getString("codigoProveedor");
                String codProducto = rs.getString("codigoProducto");
                String nombreProduct = rs.getString("nombreProducto");
                Productos productos = new Productos(codProducto, nombreProduct, codProvedor);
                almaProductos.AgregarProductosArray(productos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public int insertarProductos(String tabla, String codigoProve, String codigoProducto, String nombreProducto) {
        int aux = 0;
        try {
            String consulta = "INSERT INTO " + tabla + " (codigoProveedor,codigoProducto, nombreProducto) VALUES (?,?, ?)";
            PreparedStatement pst = con.prepareStatement(consulta);
            pst.setString(1, codigoProve);
            pst.setString(2, codigoProducto);
            pst.setString(3, nombreProducto);
            pst.executeUpdate();
            pst.close();
            aux = 0;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) { // Código de error para violación de restricción de clave duplicada
                JOptionPane.showMessageDialog(null, "El código del producto debe ser único");
                aux = 1;
            }
        }
        return aux;
    }

    public int eliminarProducto(String codigoProducto) {
        int aux = 0;
        try {
            String consulta = "DELETE FROM productos WHERE codigoProducto = ?";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, codigoProducto);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                aux = 1;
            }
        } catch (SQLException ex) {
            //   System.out.println(ex.toString());
            if (ex.getErrorCode() == 1451) {
                JOptionPane.showMessageDialog(null, "No se pueelide eliminar el producto ya que se encuentra en stock en el kardex.");
                aux = 0;
            }
        }
        return aux;
    }

    public int ModificarProductos(String CodigoProveedor, String nombreProducto, String codigoProducto) {
        int in = 0;
        try {
            String consulta = "UPDATE productos SET codigoProveedor= ?, nombreProducto =? WHERE codigoProducto = ?";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, CodigoProveedor);
            ps.setString(2, nombreProducto);
            ps.setString(3, codigoProducto);
            ps.executeUpdate();

            in = 1;
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
            in = 0;
        }
        return in;
    }

    public void seleccionarProvincias(AlmacenProvincias almaProvincia) {
        try {
            ps = con.prepareStatement("select * from provincias");
            rs = ps.executeQuery();
            while (rs.next()) {
                String Codigo = rs.getString("codigoProvincia");
                String provin = rs.getString("nombreProvincia");
                Provincia provincia = new Provincia(Codigo, provin);
                almaProvincia.AgregarProvinciaArray(provincia);
            }
        } catch (SQLException ex) {
            System.out.println("No existen datos en la base Ingrese los para poder enviar al array" + ex);
        }
    }

    public void insertarProvincias(String codigoProvincia, String nombreProvincia) {
        try {
            Statement st = con.createStatement();
            //insert into provincias set codigoProvincia='t05',nombreProvincia='Imbabura';
            st.executeUpdate("insert into provincias set codigoProvincia='" + codigoProvincia + "',nombreProvincia='" + nombreProvincia + "'");
            System.out.println("Se ingresaron los datos");

        } catch (SQLException ex) {
            Logger.getLogger(MySql.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int ElimarProvincia(String codigoProvincia) {
        int aux = 0;
        try {
            Statement st = con.createStatement();
            //delete from provincias where codigoProvincia='t03';
            st.executeUpdate("delete from provincias where codigoProvincia = '" + codigoProvincia + "'");
            aux = 0;

        } catch (SQLException ex) {
            if (ex.toString().equals("java.sql.SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint fails (`proyecto`.`ciudad`, CONSTRAINT `ciudad_ibfk_1` FOREIGN KEY (`codigoprovincia`) REFERENCES `provincias` (`codigoProvincia`))")) {
                JOptionPane.showMessageDialog(null, "Primero debe eliminar la ciudad enlasada a la provincia.\n\nPosteriormente se podra eliminar esta ciudad");
                aux = 1;
            }
            //atrapar el error 

        }
        return aux;
    }

    public void ModificarProvincias(String NombreProvincia, String CodigoProvincia) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update provincias set nombreProvincia='" + NombreProvincia + "' where codigoProvincia ='" + CodigoProvincia + "'");

        } catch (SQLException ex) {
            Logger.getLogger(MySql.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    //---------------------------------------------------Ciudad--------------
    public void seleccionarCiudades(AlmacenCiudad almaCiudad) {
        try {
            // Ahora ejecutas la segunda consulta para obtener los datos de las ciudades
            ps = con.prepareStatement("select * from ciudad");
            rs = ps.executeQuery();
            while (rs.next()) {
                String codigoProvincia = rs.getString("codigoprovincia");
                String nombreCiudad = rs.getString("nombreCiudad");
                String codigoCiudad = rs.getString("codigoCiudad");
                Ciudad ciudad = new Ciudad(codigoProvincia, nombreCiudad, codigoCiudad);
                almaCiudad.AgregarCiudadArray(ciudad);
            }

        } catch (SQLException ex) {
            System.out.println("No existen datos en la base. Ingrese los datos para poder enviar al array: " + ex);
        }
    }

    public boolean insertarCiudades(String codigoProvincia, String nombreCiudad, String codigoCiudad) throws SQLException {
        boolean aux;
        try {
            Statement st = con.createStatement();
            // INSERT INTO ciudad (codigoprovincia, nombreCiudad, codigoCiudad) VALUES ('t03', 'Latacunga', 'S23');

            st.executeUpdate("INSERT INTO ciudad (codigoprovincia, nombreCiudad, codigoCiudad) VALUES ('" + codigoProvincia + "','" + nombreCiudad + "','" + codigoCiudad + "')");
            aux = true;
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "No se puede agregar una Ciudad con el mismo código. Por favor, cámbielo.");
            aux = false;
        }
        return aux;
    }

    public void ModificarCiudad(String NombreCiudad, String CodigoProvincia, String codigoCiudad) {
        try {
            Statement st = con.createStatement();
            //UPDATE ciudad SET nombreCiudad = 'Salcedo' WHERE codigoprovincia = 't03' and codigoCiudad='S01';
            st.executeUpdate("UPDATE ciudad SET nombreCiudad= '" + NombreCiudad + "' WHERE codigoprovincia = '" + CodigoProvincia + "' and codigoCiudad='" + codigoCiudad + "'");

        } catch (SQLException ex) {
            Logger.getLogger(MySql.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ElimarCiudad(String Codigociudad) {

        try {
            Statement st = con.createStatement();
            //DELETE FROM ciudad WHERE codigoCiudad = 'S3';;
            st.executeUpdate("delete from ciudad where codigoCiudad = '" + Codigociudad + "'");

        } catch (SQLException ex) {
            System.out.println(ex);
            //atrapar el error 

        }
    }

    public void TraerCiudades(String codigo, AlmacenCiudad almaCiudad) {
        try {
            // Ahora ejecutas la segunda consulta para obtener los datos de las ciudades
            ps = con.prepareStatement("Select * from ciudad where codigoProvincia='" + codigo + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                almaCiudad.AgregarCiudadArray(new Ciudad(rs.getString("codigoprovincia"), rs.getString("codigoCiudad"), rs.getString("nombreCiudad")));
            }
        } catch (SQLException ex) {
            System.out.println("traerciudades es el error " + ex);
        }
    }
//_-----------------------------------------Clientes

    public void seleccionarClientes(AlmacenClientes almaClie) {
        try {
            // Ahora ejecutas la segunda consulta para obtener los datos de las ciudades
            ps = con.prepareStatement("select * from cliente");
            rs = ps.executeQuery();
            while (rs.next()) {
                String NumeroCedula = rs.getString("codigo_cliente");
                String nombresApellidos = rs.getString("nombresApellidos");
                String direccion = rs.getString("direccion");
                String provincia = rs.getString("provincia");
                String ciudad = rs.getString("ciudad");
                Clientes cliente = new Clientes(NumeroCedula, nombresApellidos, direccion, provincia, ciudad);
                almaClie.AgregarClientesArray(cliente);

            }
        } catch (SQLException ex) {
            System.out.println("No existen datos en la base. Ingrese los datos para poder enviar al array: " + ex);
        }
    }

    public int ElimarCliente(String NumeroCed) {
        int aux = 0;
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM cliente WHERE codigo_cliente = ?");
            pst.setString(1, NumeroCed);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                aux = 1;
            } else {
                aux = 0;
            }
        } catch (SQLException ex) {
            // System.out.println("Eliminar cliente MySQL: " + ex.toString());
            if (ex.toString().equals("java.sql.SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint fails (`proyecto`.`factura`, CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`codigo_cliente`) REFERENCES `cliente` (`codigo_cliente`))")) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar al cliente de la tabla ya que tiene una factura enlasa");
                aux = 0;
            }
        }
        return aux;
    }

    public boolean InsertarCliente(String Cedula, String NombreApe, String Direccion, String Provincia, String Ciudad) {
        boolean confirmar = true;
        try {

            //INSERT INTO cliente (numeroCedula, nombresApellidos, direccion,provincia,ciudad) VALUES ('1850215771', 'Luis Quishpe', 'Av.ksjdid','Tungurahua','Pillaro');
            String consulta = "insert into cliente (codigo_cliente, nombresApellidos, direccion,provincia,ciudad) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, Cedula);
            ps.setString(2, NombreApe);
            ps.setString(3, Direccion);
            ps.setString(4, Provincia);
            ps.setString(5, Ciudad);
            ps.executeUpdate();
            confirmar = true;

        } catch (SQLException ex) {
            // System.out.println("" + ex.toString());
            if (ex.toString().equals("java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '1850215771' for key 'cliente.PRIMARY'")) {
                JOptionPane.showMessageDialog(null, "Ya existe este cliente en la tabla o el numero de cedula es el mismo ");

            }
            confirmar = false;
        }
        return confirmar;
    }

    public void ModificarCliente(String Cedula, String NombreApe, String Direccion, String Provincia, String Ciudad) {
        try {
            String consulta = "UPDATE cliente SET nombresApellidos=?,direccion=?,provincia=?,ciudad=? WHERE codigo_cliente = ?";
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, NombreApe);
            ps.setString(2, Direccion);
            ps.setString(3, Provincia);
            ps.setString(4, Ciudad);
            ps.setString(5, Cedula);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    //--------------------------Proveedores
    public void seleccionarProveedores(AlmacenProveedor almaProve) {
        try {
            // Ahora ejecutas la segunda consulta para obtener los datos de las ciudades
            ps = con.prepareStatement("select * from proveedor");
            rs = ps.executeQuery();
            while (rs.next()) {
                String RUC = rs.getString("RUC");
                String nombresApellidos = rs.getString("nombresApellidos");
                String Telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String provincia = rs.getString("provincia");
                String ciudad = rs.getString("ciudad");
                Proveedor prove = new Proveedor(RUC, nombresApellidos, Telefono, direccion, provincia, ciudad);
                almaProve.AgregarProveedorArray(prove);

            }
        } catch (SQLException ex) {
            System.out.println("No existen datos en la base. Ingrese los datos para poder enviar al array: " + ex);
        }
    }

    public boolean InsertarProveedor(String RUC, String NombreApe, String telefono, String Direccion, String Provincia, String Ciudad) {
        boolean confirmar = true;
        try {
            Statement st = con.createStatement();
            //INSERT INTO proveedor (RUC, nombresApellidos,telefono,direccion,provincia,ciudad) VALUES ('1850215771003', 'Luis Quishpe','0967685140' ,'Av.ksjdid','Tungurahua','Pillaro');;
            st.executeUpdate("insert into proveedor (RUC, nombresApellidos,telefono,direccion,provincia,ciudad) VALUES ('" + RUC + "','" + NombreApe + "','" + telefono + "','" + Direccion + "','" + Provincia + "','" + Ciudad + "')");

            confirmar = true;

        } catch (SQLException ex) {
            switch (ex.getErrorCode()) {
                case 1064:
                    JOptionPane.showMessageDialog(null, "Error de sintaxis en la consulta SQL");
                    break;
                case 1062:
                    JOptionPane.showMessageDialog(null, "El número de cédula del usuario ya se encuentra en la base de datos");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage());
                    break;
            }
            confirmar = false;
        }
        return confirmar;
    }

    public int EliminarProveedor(String RUC) {
        int aux = 0;
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM proveedor WHERE RUC = ?");
            pst.setString(1, RUC);
            int filasAfectadas = pst.executeUpdate();

            if (filasAfectadas > 0) {
                aux = 1;
            } else {
                aux = 0;
            }
        } catch (SQLException ex) {
            //  System.out.println("Eliminar proveedor MySQL: " + ex.toString());
            if (ex.toString().equals("java.sql.SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint fails (`proyecto`.`facturacompra`, CONSTRAINT `facturacompra_ibfk_1` FOREIGN KEY (`codigo_Proveedor`) REFERENCES `proveedor` (`RUC`))")) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar al proveedor ya que existe una factura de compra enlazada");
                aux = 0;
            }
        }
        return aux;
    }

    public void ModificarProveedores(String RUC, String NombreApe, String telefono, String Direccion, String Provincia, String Ciudad) {
        try {
            String consulta = "UPDATE proveedor SET nombresApellidos=?,telefono=?,direccion=?,provincia=?,ciudad=? WHERE RUC =?";
            PreparedStatement ps = con.prepareCall(consulta);
            ps.setString(1, NombreApe);
            ps.setString(2, telefono);
            ps.setString(3, Direccion);
            ps.setString(4, Provincia);
            ps.setString(5, Ciudad);
            ps.setString(6, RUC);
            ps.executeUpdate();
        } catch (SQLException ex) {
            switch (ex.getErrorCode()) {
                case 1064:
                    JOptionPane.showMessageDialog(null, "Error de sintaxis en la consulta SQL");
                    break;
                case 1062:
                    JOptionPane.showMessageDialog(null, "El número de cédula del usuario ya se encuentra en la base de datos");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage());
                    break;
            }
        }
    }

    //----------------------------Factura---------
    public int InsertarFactura(String cedula, String nombre, String fecha) {
        int numeroFactura = 0;
        try {
            // Crear una PreparedStatement en lugar de un Statement
            String sqlInsert = "INSERT INTO factura (codigo_cliente, nombre_cliente, fecha, total,Eestado) VALUES (?, ?, ?, '0',?)";
            PreparedStatement stmtInsert = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            stmtInsert.setString(1, cedula);
            stmtInsert.setString(2, nombre);
            stmtInsert.setString(3, fecha);
            stmtInsert.setBoolean(4, true);

            // Ejecutar la sentencia SQL de inserción
            stmtInsert.executeUpdate();

            // Obtener el número de factura generado
            ResultSet generatedKeys = stmtInsert.getGeneratedKeys();
            if (generatedKeys.next()) {
                numeroFactura = generatedKeys.getInt(1);
            }

            // Cerrar el PreparedStatement
            stmtInsert.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar la factura de ventas : " + ex.getMessage());
            // Imprimir la traza de la excepción
        }

        return numeroFactura;
    }

    public void InsertarProductosFactura(int numeroFac, String codProducto, String nomProduct, int cantidad, double precio) {
        try {
            String query = "INSERT INTO productofac (numero_factura, codigo_producto, nombre_producto, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, numeroFac);
            pst.setString(2, codProducto);
            pst.setString(3, nomProduct);
            pst.setInt(4, cantidad);
            pst.setDouble(5, precio);
            pst.setDouble(6, cantidad * precio);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar los productos en la factura de ventas: " + ex.getMessage());
            // Imprimir la traza de la excepción
        }
    }

    public void AgregarkardexFacturaVentas(String codigoProducto, String fecha, int numeroFactura, int cantidad, int total) {
        try {
            String query = "INSERT INTO kardex (codigoProducto, fecha, movimiento, entrada, salida, disponible) VALUES (?, ?, ?, 0, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, codigoProducto);
            pst.setString(2, fecha);
            pst.setString(3, "Venta-- Factura 00" + numeroFactura);
            pst.setInt(4, cantidad);
            pst.setInt(5, total);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar la factura de ventas  al agregar a la kardex: " + ex.getMessage());
            // Imprimir la traza de la excepción
        }
    }

    public void ConsultarFacTotal(AlmacenFactura almaFac, int numeroFactura) {
        try {
            ps = con.prepareStatement("SELECT f.numero_factura, f.codigo_cliente, f.nombre_cliente, f.fecha,ROUND((SELECT SUM(p.subtotal) FROM productofac p WHERE p.numero_factura = f.numero_factura), 2) AS total FROM factura f WHERE f.numero_factura = " + numeroFactura + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                double total = rs.getDouble("total");
                Factura fac = new Factura(total);
                almaFac.AgregarFacturaArray(fac);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen datos en la base. Ingrese los datos para poder enviar al array: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ConsultarProductosFac(AlmacenProductoFac almaProducFac, int numeroFactura) {
        try {
            // Ahora ejecutas la segunda consulta para obtener los datos de las ciudades
            ps = con.prepareStatement("SELECT p.codigo_producto, p.nombre_producto, p.cantidad, p.precio, p.subtotal FROM factura f JOIN productofac p ON f.numero_factura = p.numero_factura WHERE f.numero_factura =" + numeroFactura + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                String codigoProducto = rs.getString("codigo_producto");
                String nombrePorducto = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                double subtotal = rs.getDouble("subtotal");
                ProductoFac productofac = new ProductoFac(numeroFactura, codigoProducto, nombrePorducto, cantidad, precio, subtotal);
                almaProducFac.AgregarProductosFacArray(productofac);

            }
        } catch (SQLException ex) {
            System.out.println("No existen datos en la base. Ingrese los datos para poder enviar al array: " + ex);
        }
    }

    public void eliminarFactura(int numeroFactura) {
        try {
            String sqlDeleteProductos = "DELETE FROM productofac WHERE numero_factura = ?";
            PreparedStatement stmtDeleteProductos = con.prepareStatement(sqlDeleteProductos);
            stmtDeleteProductos.setInt(1, numeroFactura);
            stmtDeleteProductos.executeUpdate();

            String sqlDeleteFactura = "DELETE FROM factura WHERE numero_factura = ?";
            PreparedStatement stmtDeleteFactura = con.prepareStatement(sqlDeleteFactura);
            stmtDeleteFactura.setInt(1, numeroFactura);
            stmtDeleteFactura.executeUpdate();
            System.out.println("Factura eliminada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar la factura: " + e.getMessage());
        }
    }
    //-------------------------------------------Factura compra

    public int insertarFacturaCompra(String nombreProveedor, String codigoCompra, String codigoProveedor, String fecha) {
        int numeroFactura = 0;
        try {
            // Preparar la sentencia SQL con parámetros
            String query = "INSERT INTO facturacompra (codigo_compra, nombre_Proveedor, codigo_Proveedor, fecha, total,estado) VALUES (?, ?, ?, ?, 0,?)";

            // Establecer los valores de los parámetros en la sentencia SQL
            try ( // Crear un PreparedStatement para evitar la inyección SQL
                     PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                // Establecer los valores de los parámetros en la sentencia SQL
                statement.setString(1, codigoCompra);
                statement.setString(2, nombreProveedor);
                statement.setString(3, codigoProveedor);
                statement.setString(4, fecha);
                statement.setBoolean(5, true);

                // Ejecutar la sentencia SQL de inserción
                statement.executeUpdate();

                try ( // Obtener el número de factura generado
                         ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        numeroFactura = generatedKeys.getInt(1);
                    }
                    // Cerrar los recursos
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar la factura de compra. El codigo de compra es invalido");
            numeroFactura = -1;
        }

        return numeroFactura;
    }

    public void SubConsultaProductos(AlmacenProductos almaProduc, String cedulaProveedor) {
        try {
            // Ahora ejecutas la segunda consulta para obtener los datos de los productos de solo ese proveedor
            //select nombreProducto,codigoProducto from productos where codigoProveedor='1850215771001';
            ps = con.prepareStatement("select nombreProducto,codigoProducto from productos where codigoProveedor='" + cedulaProveedor + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                String codigoProducto = rs.getString("codigoProducto");
                String nombreProducto = rs.getString("nombreProducto");
                Productos consulProduc = new Productos(codigoProducto, nombreProducto);
                almaProduc.AgregarProductosArray(consulProduc);
            }
        } catch (SQLException ex) {
            System.out.println("No existen datos en la base. Ingrese los datos para poder enviar al array: " + ex);
        }
    }

    public void AgregarProductosPedidosAfactura(int numeroFactura, String codigoProducto, String nombreProducto, int cantidad, double precio) {
        try {
            String query = "INSERT INTO productocomprado (numero_factura, codigo_producto, nombre_producto, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, numeroFactura);
            pst.setString(2, codigoProducto);
            pst.setString(3, nombreProducto);
            pst.setInt(4, cantidad);
            pst.setDouble(5, precio);
            pst.setDouble(6, cantidad * precio);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar la factura: " + ex.getMessage());
            // Imprimir la traza de la excepción
        }
    }

    //----------------------------------Kardex envio de información
    public void AgregarkardexFacturaCompras(String codigoProducto, String fecha, int numeroFactura, int cantidad, int total) {
        try {
            String query = "INSERT INTO kardex (codigoProducto, fecha, movimiento, entrada, salida, disponible) VALUES (?, ?, ?, ?, 0, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, codigoProducto);
            pst.setString(2, fecha);
            pst.setString(3, "Compra-- Factura 00" + numeroFactura);
            pst.setInt(4, cantidad);
            pst.setInt(5, total);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar la facturade compras en la kardex: " + ex.getMessage());
            // Imprimir la traza de la excepción
        }
    }

    public int ConsultaDisponibleProducto(String codigoProducto) {
        int disponible = 0;
        //FROM ( SELECT disponible FROM kardex WHERE codigoProducto = 't77' ORDER BY fecha desc limit 1) AS subconsulta;
        try {
            Statement st = con.createStatement();
            String query = "SELECT IFNULL(MAX(disponible), 0) AS Disponible FROM ( SELECT disponible FROM kardex WHERE codigoProducto = '" + codigoProducto + "' ORDER BY fecha desc limit 1) AS subconsulta";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                disponible = rs.getInt("Disponible");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al consultar la disponibilidad del producto: " + e);
        }
        return disponible;
    }

    public void subConsultaProductosFacturaCompra(String numeroFactura, AlmacenFactComprasProductos almaFactProducComp) {
        try {
            // Ejecuta la consulta utilizando un PreparedStatement para evitar la inyección SQL
            ps = con.prepareStatement("SELECT * FROM productocomprado WHERE numero_factura = ?");
            ps.setString(1, numeroFactura);
            rs = ps.executeQuery();

            while (rs.next()) {
                int numFactura = rs.getInt("numero_factura");
                String codigoProducto = rs.getString("codigo_producto");
                String nombreProducto = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                double subtotal = rs.getDouble("subtotal");

                ProductosFactCompras consulProducFac = new ProductosFactCompras(numFactura, codigoProducto, nombreProducto, cantidad, precio, subtotal);
                almaFactProducComp.AgregarFacturCompraProducaArray(consulProducFac);
            }
        } catch (SQLException ex) {
            System.out.println("No existen datos en la base. Ingrese los datos para poder enviar al array: " + ex);
        }
    }

    public void ConsultarFacTotalCompra(AlmacenFacturaCompras almaFacCompras, int numeroFactura) {
        try {
            //SELECT f.numero_factura, f.codigo_compra, f.nombre_Proveedor, f.codigo_Proveedor,f.fecha,
            //ROUND((SELECT SUM(p.subtotal) FROM productocomprado p WHERE p.numero_factura = f.numero_factura), 2) AS total
            //FROM facturacompra f
            //WHERE f.numero_factura = 32;
            ps = con.prepareStatement("SELECT f.numero_factura, f.codigo_compra, f.nombre_Proveedor, f.codigo_Proveedor,f.fecha,ROUND((SELECT SUM(p.subtotal) FROM productocomprado p WHERE p.numero_factura = f.numero_factura), 2) AS total FROM facturacompra f WHERE f.numero_factura =  " + numeroFactura + "");
            rs = ps.executeQuery();
            while (rs.next()) {
                double total = rs.getDouble("total");
                FacturaCompras facTotal = new FacturaCompras(total);
                almaFacCompras.AgregarFacturaCompraTotalArray(facTotal);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen datos en la base. Ingrese los datos para poder enviar al array: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//-----------------------------------------------Lista COMPRAS

    public void ConsultarListaCompra(AlmacenListaCompras almaListaCompr) {
        try {
            ps = con.prepareStatement("SELECT f.numero_factura, f.fecha, f.nombre_Proveedor,SUM(p.cantidad) AS cantidad_productos, f.estado  FROM facturacompra f INNER JOIN productocomprado p ON p.numero_factura = f.numero_factura where f.estado <>0 GROUP BY f.numero_factura, f.fecha, f.nombre_Proveedor");
            rs = ps.executeQuery();
            while (rs.next()) {
                int numeroFac = rs.getInt("numero_factura");
                String fecha = rs.getString("fecha");
                String Proveedor = rs.getString("nombre_Proveedor");
                int total = rs.getInt("cantidad_productos");
                ListaCompras listaC = new ListaCompras(numeroFac, fecha, Proveedor, total);
                almaListaCompr.AgregarFacturaListadoArray(listaC);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen datos en la base. Ingrese los datos para poder enviar al array: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EliminarfacListaCompras(int numerofac) {
        //UPDATE facturacompra SET estado = 0 WHERE numero_factura = 1;
        try {
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE facturacompra SET estado = 0 where numero_factura =" + numerofac + "");

        } catch (SQLException ex) {
            System.out.println("Error al borrar la factura: " + ex.getMessage());
        }
    }
    // -------------------------------Consultar lista ventas

    public void ConsultarListaVentas(AlmacenListaVentas almaListaVent) {
        try {
            ps = con.prepareCall("SELECT f.numero_factura, f.fecha, f.nombre_cliente,SUM(p.cantidad) AS cantidad_productos, f.Eestado  FROM factura f INNER JOIN productofac p ON p.numero_factura = f.numero_factura where f.Eestado <>0 GROUP BY f.numero_factura, f.fecha, f.nombre_cliente");
            rs = ps.executeQuery();
            while (rs.next()) {
                int numeroFac = rs.getInt("numero_factura");
                String fecha = rs.getString("fecha");
                String cliente = rs.getString("nombre_cliente");
                int total = rs.getInt("cantidad_productos");
                ListaVentas listav = new ListaVentas(numeroFac, fecha, cliente, total);
                almaListaVent.AgregarFacturaListadoVentasArray(listav);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen datos en la base de facturas de ventas : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // sacar los productos de venta con el numero de la factura y el total que tiene cada uno para devolver a kardex 
    public void SacarProductosVentas(int numeroFactura, AlmacenKardexVentas almakarxVen) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT codigo_producto, SUM(cantidad) AS total FROM productofac WHERE numero_factura = ? GROUP BY codigo_producto");
            statement.setInt(1, numeroFactura);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String codigoProducto = resultSet.getString("codigo_producto");
                int cantidad = resultSet.getInt("total");
                KardexVentas kardex = new KardexVentas(codigoProducto, cantidad);
                almakarxVen.AgregarKardex(kardex);
            }
        } catch (SQLException e) {
            // Manejo de excepciones: registra o muestra el mensaje de error

        }
    }

    public void AgregarkardexFacturaVentasDevolucion(String codigoProducto, String fecha, int numeroFactura, int cantidad, int total) {
        try {
            Statement st = con.createStatement();
            //INSERT INTO kardex (codigoProducto, fecha, movimiento, entrada, salida, disponible)
            st.executeUpdate("INSERT INTO kardex (codigoProducto, fecha, movimiento, entrada, salida, disponible) VALUES ('" + codigoProducto + "','" + fecha + "', 'Devolucion de Venta-- Factura 00" + numeroFactura + "', " + cantidad + ", 0, " + total + ")");

        } catch (SQLException ex) {
            System.out.println("Error al agregar devolucion en Ventas:" + ex.getMessage());
            // Imprimir la traza de la excepción
        }
    }

    //sacamos los totales con los codigos de cada producto en base a la factura a eliminar para luego restar esto en compras
    public void SacarProductosCompras(int numeroFactura, AlmacenKardexCompras almakarxCom) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT codigo_producto, SUM(cantidad) AS total FROM productocomprado WHERE numero_factura = ? GROUP BY codigo_producto");
            statement.setInt(1, numeroFactura);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String codigoProducto = resultSet.getString("codigo_producto");
                int cantidad = resultSet.getInt("total");
                KardexCompras kardexc = new KardexCompras(codigoProducto, cantidad);
                almakarxCom.AgregarKardexCompras(kardexc);
            }
        } catch (SQLException e) {
            System.out.println("Error al traer el dato de Productos compras el total con la factura " + e);

        }
    }

    public void AgregarkardexFacturaComprasDevolucion(String codigoProducto, String fecha, int numeroFactura, int cantidad, int total) {
        try {
            Statement st = con.createStatement();
            //INSERT INTO kardex (codigoProducto, fecha, movimiento, entrada, salida, disponible)
            st.executeUpdate("INSERT INTO kardex (codigoProducto, fecha, movimiento, entrada, salida, disponible) VALUES ('" + codigoProducto + "','" + fecha + "', 'Devolucion de Compra-- Factura 00" + numeroFactura + "', 0," + cantidad + " ," + total + ")");
        } catch (SQLException ex) {
            System.out.println("Error al agregar devolucion en Compras: " + ex.getMessage());
            // Imprimir la traza de la excepción
        }
    }

    public void EliminarfacListaVentas(int numerofac) {
        //UPDATE factura SET Eestado = 0 WHERE numero_factura = 1;
        try {
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE factura SET Eestado = 0 where numero_factura =" + numerofac + "");

        } catch (SQLException ex) {
            System.out.println("Error al borrar la factura Ventas: " + ex.getMessage());
        }
    }

    /// -------------------------------cargar la kardex 
    public void ConsultaKardex(String codigoProduc, AlmacenKardex almaKar) {
        try {
            ps = con.prepareStatement("SELECT * FROM kardex WHERE codigoProducto ='" + codigoProduc + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                String fecha = rs.getString("fecha");
                String movimiento = rs.getString("movimiento");
                int Entrada = rs.getInt("entrada");
                int salida = rs.getInt("salida");
                int disponible = rs.getInt("disponible");
                Kardex karx = new Kardex(fecha, movimiento, Entrada, salida, disponible);
                almaKar.AgregarKardex(karx);
            }
        } catch (Exception e) {
        }

    }

}
