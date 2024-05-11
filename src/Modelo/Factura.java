package Modelo;

/**
 *
 * @author Lenovo
 */
public class Factura {
 private double total;

    public Factura(double total) {
        this.total = total;
    }

    public Factura() {
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
