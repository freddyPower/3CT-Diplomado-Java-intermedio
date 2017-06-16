
package modelo;

import modelo.dao.TituloDao;
import modelo.dao.UsuarioDao;
import modelo.dto.Titulo;

public class Prueba {
    public static void main(String args[]){
    
        System.out.println("VAMO A PROBAR LOS METODOS");
        
        //Proabando el metodo TituloDao.insertaTitulo()
        //Titulo t = new Titulo("55555555", "De que " , "2015", 2);
        boolean respuesta = UsuarioDao.autenticacion("fred104@mail.com" , "lol");
        
        System.out.println("Respuesta a autenticar: " + respuesta);
    
    }
}
