
package modelo.dao;

import modelo.model.Persona;

/**
 *
 * @author luis
 */
public class Pruebas {
    
    public static void main(String [] args){
    
        Persona luis = new Persona("Luis", "Sanchez", "Angeles", "SAAL910905HDFNNS09", "freddy_z91@hotmail.com", 24, "qwerty");
        PersonaDaoImpl util = new PersonaDaoImpl();
       // util.insertar(luis);
        
        util.mostrarPersonas();
    
    }
    
}
