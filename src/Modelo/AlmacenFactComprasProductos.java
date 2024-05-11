
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenFactComprasProductos {
    private ArrayList<ProductosFactCompras> lista = new ArrayList<ProductosFactCompras>();

    public ArrayList<ProductosFactCompras> getLista() {
        return this.lista;
    }

    public void AgregarFacturCompraProducaArray(ProductosFactCompras lista) {
        this.getLista().add(lista);
    }
}
