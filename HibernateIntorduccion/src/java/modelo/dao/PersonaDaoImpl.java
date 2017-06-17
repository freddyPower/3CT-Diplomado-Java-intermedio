
package modelo.dao;

import java.util.List;
import modelo.model.Persona;
import modelo.persistencia.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luis
 */
public class PersonaDaoImpl implements PersonaDao{

    @Override
    public List<Persona> mostrarPersonas() {
       Session session = null;
       List<Persona> lista = null;
       
       try{           
           session = HibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("from modelo.model.Persona");
           lista = ( List<Persona> ) query.list(); 
           
           
       
       }catch(HibernateException he){
           System.out.println("Error con hibernate: " + he.getMessage()); 
           
       }finally{
           
           if( session != null ){
               session.close();
           }
       }       
       return lista;       
    }

    @Override
    public void insertar(Persona p) {
        
        Session session = null;
        
        try{           
           session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(p);
           session.getTransaction().commit();                  
       
       }catch(HibernateException he){
           System.out.println("Error con hibernate: " + he.getMessage());
           session.getTransaction().rollback();
           
       }finally{
           
           if( session != null ){
               session.close();
           }
       }       
    }

    @Override
    public void actualizar(Persona p) {
        
    }

    @Override
    public void eliminar(Persona p) {
        
    }
    
}
