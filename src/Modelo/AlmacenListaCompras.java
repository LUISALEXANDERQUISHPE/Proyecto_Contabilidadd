
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenListaCompras {
        private ArrayList<ListaCompras> lista = new ArrayList<ListaCompras>();

    public ArrayList<ListaCompras> getLista() {
        return this.lista;
    }

    public void AgregarFacturaListadoArray(ListaCompras lista) {
        this.getLista().add(lista);
    }
    
}
