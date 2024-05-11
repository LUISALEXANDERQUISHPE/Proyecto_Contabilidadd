
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenProductos {
    private ArrayList<Productos> lista = new ArrayList<Productos>();

    public ArrayList<Productos> getLista() {
        return lista;
    }

    public void AgregarProductosArray(Productos lista) {
        this.getLista().add(lista);
    }
    
}
