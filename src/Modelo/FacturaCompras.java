package Modelo;

/**
 *
 * @author Lenovo
 */
public class FacturaCompras {
 private double total;

    public FacturaCompras(double total) {
        this.total = total;
    }

    public FacturaCompras() {
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
