
package Modelo;

/**
 *
 * @author Lenovo
 */
public class Proveedor {
    private String Ruc;
    private String NombreApellido;
    private String Telefono;
    private String Direccion;
    private String Provincia;
    private String Ciudad;

    public Proveedor() {
    }

    public Proveedor(String Ruc, String NombreApellido, String Telefono, String Direccion, String Provincia, String Ciudad) {
        this.Ruc = Ruc;
        this.NombreApellido = NombreApellido;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Provincia = Provincia;
        this.Ciudad = Ciudad;
    }

    public String getRuc() {
        return this.Ruc;
    }

    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }

    public String getNombreApellido() {
        return this.NombreApellido;
    }

    public void setNombreApellido(String NombreApellido) {
        this.NombreApellido = NombreApellido;
    }

    public String getTelefono() {
        return this.Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
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
    public String toString (){
        return this.NombreApellido;
    }
    
}
