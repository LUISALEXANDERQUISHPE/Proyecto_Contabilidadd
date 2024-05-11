package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenProvincias {

    private ArrayList<Provincia> lista = new ArrayList<Provincia>();

    public ArrayList<Provincia> getLista() {
        return lista;
    }

    public void AgregarProvinciaArray(Provincia lista) {
        this.getLista().add(lista);
    }

}
