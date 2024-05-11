
package Modelo;

/**
 *
 * @author Lenovo
 */
public class Permisos  {
    private String Usuario;
    private String contraseña;
    private int intento;
    private boolean productos;
    private boolean clientes;
    private boolean proveedor;
    private boolean factura;
    private boolean compra;
    private boolean kardex;
    private boolean provincia;
    private boolean ciudad;
    private boolean ListaVen;
    private boolean ListaCon;
    private boolean gestionUsers;

    public Permisos() {
    }

    public Permisos(String Usuario, String contraseña, int intento) {
        this.Usuario = Usuario;
        this.contraseña = contraseña;
        this.intento = intento;
    }

    public Permisos( boolean productos, boolean clientes, boolean proveedor, boolean factura, boolean compra, boolean kardex, boolean provincia, boolean ciudad, boolean ListaVen, boolean ListaCon, boolean gestionUsers) {
        
        this.productos = productos;
        this.clientes = clientes;
        this.proveedor = proveedor;
        this.factura = factura;
        this.compra = compra;
        this.kardex = kardex;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.ListaVen = ListaVen;
        this.ListaCon = ListaCon;
        this.gestionUsers = gestionUsers;
    }

    public String getUsuario() {
        return this.Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIntento() {
        return this.intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

   

    public boolean getProductos() {
        return this.productos;
    }

    public void setProductos(boolean productos) {
        this.productos = productos;
    }

    public boolean getClientes() {
        return this.clientes;
    }

    public void setClientes(boolean clientes) {
        this.clientes = clientes;
    }

    public boolean getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(boolean proveedor) {
        this.proveedor = proveedor;
    }

    public boolean getFactura() {
        return this.factura;
    }

    public void setFactura(boolean factura) {
        this.factura = factura;
    }

    public boolean getCompra() {
        return this.compra;
    }

    public void setCompra(boolean compra) {
        this.compra = compra;
    }

    public boolean getKardex() {
        return this.kardex;
    }

    public void setKardex(boolean kardex) {
        this.kardex = kardex;
    }

    public boolean getProvincia() {
        return this.provincia;
    }

    public void setProvincia(boolean provincia) {
        this.provincia = provincia;
    }

    public boolean getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(boolean ciudad) {
        this.ciudad = ciudad;
    }

    public boolean getListaVen() {
        return this.ListaVen;
    }

    public void setListaVen(boolean ListaVen) {
        this.ListaVen = ListaVen;
    }

    public boolean getListaCon() {
        return this.ListaCon;
    }

    public void setListaCon(boolean ListaCon) {
        this.ListaCon = ListaCon;
    }

    public boolean getGestionUsers() {
        return this.gestionUsers;
    }

    public void setGestionUsers(boolean gestionUsers) {
        this.gestionUsers = gestionUsers;
    }
    
}
