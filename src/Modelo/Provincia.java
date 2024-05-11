package Modelo;

/**
 *
 * @author Lenovo
 */
public class Provincia {

    private String codigoProvincia;
    private String nombreProvincia;

    public Provincia() {
    }

    public Provincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public Provincia(String codigoProvincia, String nombreProvincia) {
        this.codigoProvincia = codigoProvincia;
        this.nombreProvincia = nombreProvincia;
    }

    public String getCodigoProvincia() {
        return this.codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getNombreProvincia() {
        return this.nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }
    @Override
    public String toString(){
        return this.nombreProvincia;
    }

}
