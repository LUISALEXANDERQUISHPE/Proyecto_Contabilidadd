
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenKardex {
private ArrayList<Kardex> lista = new ArrayList<Kardex>();

    public ArrayList<Kardex> getLista() {
        return this.lista;
    }

    public void AgregarKardex(Kardex lista) {
        this.getLista().add(lista);
    }

}
