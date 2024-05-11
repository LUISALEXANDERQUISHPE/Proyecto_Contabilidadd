
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenKardexVentas {
    private ArrayList<KardexVentas> lista = new ArrayList<KardexVentas>();

    public ArrayList<KardexVentas> getLista() {
        return this.lista;
    }

    public void AgregarKardex(KardexVentas lista) {
        this.getLista().add(lista);
    }
}
