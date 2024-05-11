
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenProveedor {
    private ArrayList<Proveedor> lista = new ArrayList<Proveedor>();

    public ArrayList<Proveedor> getLista() {
        return this.lista;
    }

    public void AgregarProveedorArray(Proveedor lista) {
        this.getLista().add(lista);
    }
    
}
