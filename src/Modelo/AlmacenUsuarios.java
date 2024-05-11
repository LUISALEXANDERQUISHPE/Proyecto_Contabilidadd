package Modelo;


import java.util.ArrayList;

public class AlmacenUsuarios {

    private ArrayList<Users> lista = new ArrayList<Users>();

    public ArrayList<Users> getDa() {
        return this.lista;
    }

    public void AgregarUsuarios(Users da) {
        this.getDa().add(da);
    }

   
}
