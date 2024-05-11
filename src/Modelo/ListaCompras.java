
package Modelo;

/**
 *
 * @author Lenovo
 */
public class ListaCompras {
    private int numeroFac;
    private String fecha;
    private String proveedorNom;
    private int Total;

    public ListaCompras() {
    }

    public ListaCompras(int numeroFac, String fecha, String proveedorNom, int Total) {
        this.numeroFac = numeroFac;
        this.fecha = fecha;
        this.proveedorNom = proveedorNom;
        this.Total = Total;
    }

    public int getNumeroFac() {
        return this.numeroFac;
    }

    public void setNumeroFac(int numeroFac) {
        this.numeroFac = numeroFac;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProveedorNom() {
        return this.proveedorNom;
    }

    public void setProveedorNom(String proveedorNom) {
        this.proveedorNom = proveedorNom;
    }

    public int getTotal() {
        return this.Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
}