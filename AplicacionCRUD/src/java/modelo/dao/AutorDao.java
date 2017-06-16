package modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.dto.Autor;

//El dao implementa los metodos necesarios para cumplkir con la logica de negocio
public class AutorDao {    
    //insertarAutor
    public static synchronized boolean insertarAutor( Autor varAutor ){
    
        boolean respuesta = false;
        Connection cn = null;
        CallableStatement cl = null;
        
        try{
        
            //Nombre del procedimiento almacenado que vamos a invocar
            String call = "{CALL insertarAutor(?,?)}";
            //Obtenemos la conexion
            cn = Conexion.getConexion();
            //COnfiguramos el autoCommit
            cn.setAutoCommit(false);
            
            //Prearamos la instruccion
            cl = cn.prepareCall(call);
            //Configuramos el SP
            cl.setString( 1, varAutor.getNombre() );
            cl.setString(2, varAutor.getApellidoPaterno());
            
            //Ejecutamos la instruccion
            respuesta = cl.executeUpdate() == 1 ? true : false;
            
            //Validamos respuesta
            if( respuesta == true ){
                cn.commit();
            }else{
                Conexion.deshacerCambios(cn);
            }
            
            //Cerramos recursos
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
            
        }catch( SQLException sqle ){
            
            System.out.println("ERROR DE SQL: " + sqle.getMessage());
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        
        }catch( Exception e ){
            System.out.println("ERROR GENERICO: " + e.getMessage());
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);            
        }       
        return respuesta;
    
    }//Fin del metodo insertarAutor    
    //Mostrar autores
    public static synchronized ArrayList<Autor> obtenerAutores(){
    
        //Variables necesarias 
        ArrayList<Autor> lista = new ArrayList<Autor>();
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        
        try{
        
             String call = "{CALL mostrarAutores()}";
             cn = Conexion.getConexion();
             cl = cn.prepareCall(call);
             
             //La siguiente instruccion prepara el rs para ejecutar el Query
             rs = cl.executeQuery();
             
             //Consultamos el rs
             while( rs.next() ){
                 
                 Autor a = new Autor();
                 
                 //LLenamos el autor
                 a.setIdAutor( rs.getInt("IDAutor")  );
                 a.setNombre( rs.getString("NombrePila")  );
                 a.setApellidoPaterno( rs.getString("ApellidoPaterno") );
                 
                 lista.add(a);
             
             }
             
             Conexion.cerrarCall(cl);
             Conexion.cerrarConexion(cn);
             
             
        
        }catch( SQLException sqle ){
            
            System.out.println("ERROR DE SQL: " + sqle.getMessage());            
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        
        }catch(Exception e){
            System.out.println("ERROR GENERICO: " + e.getMessage());            
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);           
        }
            
        
        return lista;
        
    }//FIn del metodo obtenerAutores
       
    public static synchronized Autor obtenerAutor(int idAutor){
    
        Autor a = new Autor();
        Connection cn = null;        
        CallableStatement cl = null;
        ResultSet rs = null;        
        try{
            String call = "CALL mostrarAutor(?)";
            cn = Conexion.getConexion();
            cl = cn.prepareCall(call);
            //Configurar parametros de entrada
            cl.setInt(1, idAutor);            
            //La instruccion almacena en un result set
            rs = cl.executeQuery();
            //CVonsultamos si el rs  tiene datos y  asi llenar  mi ArrayList<Producto>
            while(rs.next()){                
                //Obtenemos valores de la consulta y llenamos le objeto p
                a.setIdAutor(rs.getInt("IDAutor"));
                a.setNombre(rs.getString("NombrePila"));
                a.setApellidoPaterno(rs.getString("ApellidoPaterno"));                            
            }
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
            
        }catch(SQLException sqle){        
            sqle.getMessage();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        }catch(Exception e){
            e.getMessage();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        }
        
        return a;
        
    }//FIn del metodo obtenerAutores

    public static boolean modificarAutor(Autor varAutor) {
        boolean respuesta = false;
        Connection cn = null;
        CallableStatement cl = null;
        
        try{
        
            //Nombre del procedimiento almacenado que vamos a invocar
            String call = "{CALL alterarAutor(?,?,?)}";
            //Obtenemos la conexion
            cn = Conexion.getConexion();
            //COnfiguramos el autoCommit
            cn.setAutoCommit(false);
            
            //Prearamos la instruccion
            cl = cn.prepareCall(call);
            //Configuramos el SP
            cl.setInt( 1, varAutor.getIdAutor());
            cl.setString( 2, varAutor.getNombre() );
            cl.setString(3, varAutor.getApellidoPaterno());
            
            //Ejecutamos la instruccion
            respuesta = cl.executeUpdate() == 1 ? true : false;
            
            //Validamos respuesta
            if( respuesta == true ){
                cn.commit();
            }else{
                Conexion.deshacerCambios(cn);
            }
            
            //Cerramos recursos
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
            
        }catch( SQLException sqle ){
            
            System.out.println("ERROR DE SQL: " + sqle.getMessage());
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        
        }catch( Exception e ){
            System.out.println("ERROR GENERICO: " + e.getMessage());
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);            
        }       
        return respuesta;
    }
    
    public static synchronized boolean eliminarAutor(int idAutor){
    
            Connection cn = null;
        CallableStatement cl = null;
        boolean respuesta = false;        
        try{            
            //Nombre del procedimiento almacenado que invoca -> SP Espera dos parametros; colocamos dos ?
            String call = "{CALL eliminarAutor(?)}";
            //Obtenemos la conexion
            cn = Conexion.getConexion();
            //Decimos que vamos a crear una transaccion
            cn.setAutoCommit(false);
            //Preparamos la instruccion
            cl = cn.prepareCall(call);
            //Configurar los parametros del call
            cl.setInt(1, idAutor);            
            //Ejecutamos la instruccion del sp. Si nos devuele 1es true 
            respuesta = cl.executeUpdate() == 1 ? true : false;
            
            //valido la respuesta
            if(respuesta == true){
                cn.commit();
            }else{
                Conexion.deshacerCambios(cn);
            }            
            //Cierro CL y CN
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);            
            
        }catch(SQLException sqle){
            sqle.getMessage();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarConexion(cn);
            Conexion.cerrarCall(cl);        
        }catch(Exception e){
            e.getMessage();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);           
        } 
        return respuesta;
    
    }
      
}
