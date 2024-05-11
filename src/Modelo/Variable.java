
package Modelo;

import Clases.MySql;

/**
 *
 * @author Lenovo
 */
public class Variable {
    
   static  MySql conec = new MySql();
    public static Permisos p= new Permisos();

    public static Permisos getP() {
        return p;
    }

    public static void setP(String usuario) {
        Variable.p = conec.traerPermisos(usuario);
    }
    
}
