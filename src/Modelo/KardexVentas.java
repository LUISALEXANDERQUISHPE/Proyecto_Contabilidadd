
package Modelo;

/**
 *
 * @author Lenovo
 */
public class KardexVentas {
    private String codigoP;
    private int cantidad;

    public KardexVentas() {
    }

    public KardexVentas(String codigoP, int cantidad) {
        this.codigoP = codigoP;
        this.cantidad = cantidad;
    }

    public String getCodigoP() {
        return this.codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
