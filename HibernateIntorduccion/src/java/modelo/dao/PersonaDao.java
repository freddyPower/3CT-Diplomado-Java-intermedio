
package modelo.dao;

import java.util.List;
import modelo.model.Persona;

/**
 *
 * @author luis
 */
public interface PersonaDao {
    
    //Reglas de implementacion para la interface persona DAO
    public List<Persona> mostrarPersonas();
    public void insertar(Persona p);
    public void actualizar(Persona p);
    public void eliminar(Persona p);
    
}
