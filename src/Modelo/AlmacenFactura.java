
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenFactura {
    private ArrayList<Factura> lista = new ArrayList<Factura>();

    public ArrayList<Factura> getLista() {
        return this.lista;
    }

    public void AgregarFacturaArray(Factura lista) {
        this.getLista().add(lista);
    }
    
}
