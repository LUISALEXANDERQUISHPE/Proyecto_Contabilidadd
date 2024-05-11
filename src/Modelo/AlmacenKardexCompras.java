
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenKardexCompras {
  private ArrayList<KardexCompras>   lista = new ArrayList<KardexCompras> ();


    public ArrayList<KardexCompras> getLista() {
        return this.lista;
    }

    public void AgregarKardexCompras(KardexCompras lista) {
        this.getLista().add(lista);
    }
  
}
