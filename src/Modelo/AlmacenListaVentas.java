
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenListaVentas {
        private ArrayList<ListaVentas> lista = new ArrayList<ListaVentas>();

    public ArrayList<ListaVentas> getLista() {
        return this.lista;
    }

    public void AgregarFacturaListadoVentasArray(ListaVentas lista) {
        this.getLista().add(lista);
    }
    
}
