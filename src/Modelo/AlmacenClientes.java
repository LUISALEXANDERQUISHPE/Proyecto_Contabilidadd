
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenClientes {
    private ArrayList<Clientes> lista = new ArrayList<Clientes>();

    public ArrayList<Clientes> getLista() {
        return lista;
    }

    public void AgregarClientesArray(Clientes lista) {
        this.getLista().add(lista);
    }
    
}
