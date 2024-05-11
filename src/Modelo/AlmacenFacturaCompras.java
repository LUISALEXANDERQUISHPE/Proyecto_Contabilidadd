
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenFacturaCompras {
    private ArrayList<FacturaCompras> lista = new ArrayList<FacturaCompras>();

    public ArrayList<FacturaCompras> getLista() {
        return this.lista;
    }

    public void AgregarFacturaCompraTotalArray(FacturaCompras lista) {
        this.getLista().add(lista);
    }
    
}
