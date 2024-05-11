package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenCiudad {

    private ArrayList<Ciudad> lista = new ArrayList<Ciudad>();

    public ArrayList<Ciudad> getLista() {
        return this.lista;
    }

    public void AgregarCiudadArray(Ciudad lista) {
        this.getLista().add(lista);
        
    }
}
