package Modelo;

/**
 *
 * @author Lenovo
 */
public class Productos {

    private String CodigoProducto;
    private String NombreProducto;
    private String CodigoProveedor;

    public Productos(String CodigoProducto, String NombreProducto) {
        this.CodigoProducto = CodigoProducto;
        this.NombreProducto = NombreProducto;
    }

    
    public Productos() {
    }

    public Productos(String CodigoProducto, String NombreProducto, String CodigoProveedor) {
        this.CodigoProducto = CodigoProducto;
        this.NombreProducto = NombreProducto;
        this.CodigoProveedor = CodigoProveedor;

    }

    public String getCodigoProducto() {
        return this.CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getNombreProducto() {
        return this.NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getCodigoProveedor() {
        return this.CodigoProveedor;
    }

    public void setCodigoProveedor(String CodigoProveedor) {
        this.CodigoProveedor = CodigoProveedor;
    }
    @Override
    public String toString(){
        return this.NombreProducto;
    } 
}
