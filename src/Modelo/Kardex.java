
package Modelo;

/**
 *
 * @author Lenovo
 */
public class Kardex {
   private String fecha;
   private  String movimiento;
   private int entrada;
   private int salida;
   private int disponible;

    public Kardex() {
    }

    public Kardex( String fecha, String movimiento, int entrada, int salida, int disponible) {

        this.fecha = fecha;
        this.movimiento = movimiento;
        this.entrada = entrada;
        this.salida = salida;
        this.disponible = disponible;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMovimiento() {
        return this.movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public int getEntrada() {
        return this.entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSalida() {
        return this.salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }


}