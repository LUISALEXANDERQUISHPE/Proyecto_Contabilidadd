
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenPermisos {
        private ArrayList<Permisos> lista = new ArrayList<Permisos>();

    public ArrayList<Permisos> getLista() {
        return this.lista;
    }

    public void AgregarPermisosArray(Permisos lista) {
        this.getLista().add(lista);
    }
}
