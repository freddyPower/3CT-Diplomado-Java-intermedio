
package modelo.dao;

//EL dao contiene la logica d enegocio de mi aplicacion
//Imports necesarios para ejecutar esta logica
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.dto.Titulo;

//Esta clase contiene 5 metodos que manipulan los SP's
public class TituloDao 
{
 
    //Metodo que inserta un nuevo titulo a BD
    public static synchronized boolean insertaTitulo( Titulo t ) {
    
        Connection cn = null;
        CallableStatement cl = null;
        boolean respuesta = false;
        
        try{
        
             //Creamos una cadena con la llamada al SP
             String call = "{call insertaTitulo(?, ?, ? , ?)}";
             //Otener la conexion a la BD por medio de mi clase COnexion
             cn = Conexion.getConexion();
             //Indicamos que no sea autoccomit
             cn.setAutoCommit(false);
             //prerapramos el cl
             cl = cn.prepareCall(call);
             
             //Parametrizar mi callable
             cl.setString(1, t.getIsbn());
             cl.setString(2, t.getTitulo());
             cl.setInt(3, t.getNumeroEdicion());
             cl.setString(4, t.getCopyright());
             
             //Ejecutamos  la instruccion 
             //Ejecuto la instruccion
             respuesta = cl.executeUpdate() == 1 ? true : false;
             
             
             //Validamos la respuesta
             if(respuesta == true){
                 cn.commit();
             }else{
                 Conexion.deshacerCambios(cn);
             }
             
             //Cierro recursos utilizados
             Conexion.cerrarCall(cl);
             Conexion.cerrarConexion(cn);            
        }catch( SQLException sqle ){
            System.out.println("ERROR SQL: " + sqle.getMessage() );
            Conexion.cerrarCall(cl);
            Conexion.deshacerCambios(cn);
            Conexion.cerrarConexion(cn);
        }catch( Exception e ){
            System.out.println("ERROR GENERICO: " + e.getMessage() );
            Conexion.cerrarCall(cl);
            Conexion.deshacerCambios(cn);
            Conexion.cerrarConexion(cn);        
        }
        
        return respuesta;
    }//Fin del metodo insertaTitulo
    
    
    
}
