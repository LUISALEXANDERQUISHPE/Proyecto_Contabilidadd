package Modelo;

/**
 *
 * @author Lenovo
 */
public class Ciudad {

    private String codigoProvincia;
    private String codigoCiudad;
    private String nombreCiudad;

    public Ciudad() {
    }

    public Ciudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    
    public Ciudad(String codigoProvincia, String codigoCiudad, String nombreCiudad) {
        this.codigoProvincia = codigoProvincia;
        this.codigoCiudad = codigoCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    public String toString(){
        return this.nombreCiudad;
    }
}