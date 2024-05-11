/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AlmacenProductoFac {
      private ArrayList<ProductoFac> lista = new ArrayList<ProductoFac>();

    public ArrayList<ProductoFac> getLista() {
        return this.lista;
    }

    public void AgregarProductosFacArray(ProductoFac lista) {
        this.getLista().add(lista);
    }
}
