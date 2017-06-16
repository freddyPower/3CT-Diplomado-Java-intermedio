

package modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.dto.Usuario;

public class UsuarioDao 
{
    
    //Metodo para autenticar un usuario
    public static synchronized ArrayList<Usuario> mostrarUsuarios(){    
        //Variables necesarias
        ArrayList<Usuario> lista = new ArrayList<>();        
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        
        try{
            String call = "{CALL mostrarUsuarios()}";
            cn = Conexion.getConexion();
            cl = cn.prepareCall(call); 
            
            rs = cl.executeQuery();            
            //Consultamos si el rs  tiene datos al llenar  el array list
            while( rs.next() ){
                Usuario u = new Usuario();                
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre( rs.getString("nombre") );
                u.setApMaterno(rs.getString("apMaterno"));
                u.setApPaterno(rs.getString("apPaterno"));
                u.setCorreo(rs.getString("correo"));
                u.setPassword(rs.getString("password"));
                
                lista.add(u);                    
            }
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);          
        
        }catch( SQLException sqle ){            
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
            System.out.println("EXCEPCION SLE: " + sqle.getMessage());
        
        }catch(Exception e){
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
            System.out.println("EXCEPCION GENERICA: " + e.getMessage());
        }        
        return lista;        
    }
    
    //Metodo para autenticar usuario
    public static  boolean autenticacion( String usuario,  String password ){
        boolean respuesta = false;
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        
        try{            
            String call = "{CALL mostrarUsuarios()}";            
            cn = Conexion.getConexion();
            cl = cn.prepareCall(call);
            
            rs = cl.executeQuery();
            
            while( rs.next() ){
                
                if( usuario.equals(rs.getString("correo")) && password.equals(rs.getString("password")) ){
                    Conexion.cerrarCall(cl);
                    Conexion.cerrarConexion(rs);
                    Conexion.cerrarConexion(cn);
                    return respuesta = true;
                }            
            }           
            
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(rs);
            Conexion.cerrarConexion(cn);
            return respuesta;
                        
        }catch(SQLException sqle){
            
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
            System.out.println("EXCEPCION SLE: " + sqle.getMessage());
        
        }catch(Exception e){        
            
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
            System.out.println("EXCEPCION GENERICA: " + e.getMessage());
        }
        
        return respuesta;        
    }

    public static Usuario obtenerUsuario(String usuario, String password) {
        //Variables necesarias
        Usuario u = new Usuario();        
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        
        try{
            String call = "{CALL obtenerUsuario(? , ?)}";
            cn = Conexion.getConexion();
            
            cl = cn.prepareCall(call);     
           
            cl.setString(1, usuario);
            cl.setString(2, password);
            
            rs = cl.executeQuery();            
            //Consultamos si el rs  tiene datos al llenar  el array list
            while( rs.next() ){                             
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre( rs.getString("nombre") );
                u.setApMaterno(rs.getString("apMaterno"));
                u.setApPaterno(rs.getString("apPaterno"));
                u.setCorreo(rs.getString("correo"));
                u.setPassword(rs.getString("password"));
            }
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);          
        
        }catch( SQLException sqle ){            
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
            System.out.println("EXCEPCION SLE: " + sqle.getMessage());
        
        }catch(Exception e){
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
            System.out.println("EXCEPCION GENERICA: " + e.getMessage());
        }        
        return u;  
    }
    
}
