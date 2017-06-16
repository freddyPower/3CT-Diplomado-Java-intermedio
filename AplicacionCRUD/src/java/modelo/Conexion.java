
package modelo;

//Imports necesarios
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author luis
 */
public class Conexion {
    
    //Atributos de la clase Conexion
    
    //URL de mi BD
    private static  String url = "jdbc:mysql://localhost:3306/libros";
    //Usuario
    private static String usuario = "root";
    //password
    private static String password = "1915";
    
    //Metodos de la clase Conexion
    
    //Establecer una conexion con la BD Libros
    public  static synchronized Connection getConexion(){
    
        Connection cn = null;
        try{
            //Cargar el driver 
            Class.forName("com.mysql.jdbc.Driver");
            //Obtenemos la conexion
            cn = DriverManager.getConnection( url , usuario , password );
        }catch( Exception e ){
            
            System.out.println( "EXCEPTION: " + e.getMessage() );
        
        }finally{
            
            return cn;
            
        }
        
    }//Fin del metodo getCOnexion
    
    
    //Metodo para cerrar un callable statement
    public static synchronized void  cerrarCall( CallableStatement cl ){
    
        try{
            cl.close();
        }catch( Exception e ){
            System.out.println("EXCEPCION AL CERRAR EL CL: " + e.getMessage());
        }
        
    }//FIn del metodo cerrarCall
    
    //Metodo para cerrar un Rs
    public static synchronized void cerrarConexion( ResultSet rs ){
    
        try{
            rs.close();
        }catch(Exception e){
            System.out.println("EXCEPCION AL CERRAR EL RS: " + e.getMessage());
        }
        
    }//Fin del metodo cerrar RS
    
    //Metodo para cerrar una conexion
    public static synchronized void cerrarConexion( Connection cn ){
    
        try{
            cn.close();
        }catch(Exception e){
            System.out.println("EXCEPCION AL CERRAR LA CN: " + e.getMessage());
        }
        
    }//Fin del metodo cerrarCOnexion
    
    //Metodo para reversar 
    public static synchronized void deshacerCambios( Connection cn ){
    
        try{
            cn.rollback();
        }catch( Exception e ){
        
            System.out.println("EXCEPTION AL EMPLEAR RB: " + e.getMessage());
        }
    }//FIn del metodo deshacerCambios  
    
    
}
