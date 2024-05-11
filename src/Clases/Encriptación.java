
package Clases;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 *
 * @author Lenovo
 */
public class Encriptación {
    public String Encriptar(String s) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
    public String Desencriptar(String s) throws UnsupportedEncodingException{
         byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }
     
}
