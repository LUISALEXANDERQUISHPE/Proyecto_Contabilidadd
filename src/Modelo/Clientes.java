package Modelo;

/**
 *
 * @author Lenovo
 */
public class Clientes {

    private String Cedula;
    private String NombreApellido;
    private String Direccion;
    private String Provincia;
    private String Ciudad;

    public Clientes() {
    }

    public Clientes(String Cedula, String NombreApellido, String Direccion, String Provincia, String Ciudad) {
        this.Cedula = Cedula;
        this.NombreApellido = NombreApellido;
        this.Direccion = Direccion;
        this.Provincia = Provincia;
        this.Ciudad = Ciudad;
    }
    
    public String getCedula() {
        return this.Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombreApellido() {
        return this.NombreApellido;
    }

    public void setNombreApellido(String NombreApellido) {
        this.NombreApellido = NombreApellido;
    }

    public String getDireccion() {
        return this.Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getProvincia() {
        return this.Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getCiudad() {
        return this.Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }
    @Override
    public String toString(){
        return this.NombreApellido;
    }
    
    
    
}
