
package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.AutorDao;
import modelo.dto.Autor;


@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class CtrlAutor extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //EL objetivo de mi controlador es hacer una seleccion  de peticiones HTTP y debe direccionar esta peticion al metodo adecuado
        
        String accion = request.getParameter("accion");
        
        //Redireccionamos el valor de accion al metodo correspondiente
        if( accion.equals("RegistrarAutor") ){        
            this.registrarAutor( request , response );            
            
        }else if( accion.equals("ModificarAutor") ){
        
            this.modificarAutor(request , response);
            
        }else if( accion.equals("EliminarAutor") ){
        
            this.eliminarAutor(request, response);
        }
        
    }//Aqui termina el processRequest
    
    //EL objetivo de estos metodos es de recuperar la informacion que mandan los forms que se encuentran en el front y darle el formato adecuado
    private void registrarAutor(  HttpServletRequest request , HttpServletResponse response  ) throws IOException{
    
        //Paso1: Recuperar la informacion de los forumalrios
        Autor a = new Autor();
        a.setNombre(  request.getParameter("txtNombre")  );
        a.setApellidoPaterno( request.getParameter("txtApellidoPaterno")  );
        
        //Paso 1.2: Asignar los valores a su formato adecuado
        
        //Paso 2: Insertar
        boolean respuesta = AutorDao.insertarAutor(a);
        
        if( respuesta ){
            response.sendRedirect("mensaje.jsp?men=Se registro correctamente");
        }else{
            response.sendRedirect("mensaje.jsp?men=No se inserto correctamente");
        }
               
    }//Fin del metodo registrarAutor
    
    //Metodo para actualizar un autor
    private void modificarAutor( HttpServletRequest request , HttpServletResponse response ) throws IOException{
        
        //Obtener los valores desde el fornt
        Autor a = new Autor();
        
        a.setIdAutor(  Integer.parseInt(  request.getParameter("txtIdAutor")  )  );
        a.setNombre(request.getParameter("txtNombre"));
        a.setApellidoPaterno(request.getParameter("txtApellidoPaterno"));
        
        
        boolean respuesta = AutorDao.modificarAutor(a);
        
        if( respuesta ){
        response.sendRedirect("mensaje.jsp?men=Se actualizo correctamente");
        
        }else{        
            response.sendRedirect("mensaje.jsp?men=Error al actualizar");
        }
    }
    
    //ELiminar un autor
    private void eliminarAutor( HttpServletRequest request , HttpServletResponse response ) throws IOException{
        //Obtener los valores desde el fornt
        Autor a = new Autor();
        
        a.setIdAutor(  Integer.parseInt(  request.getParameter("txtIdAutor")  )  );
               
        
        boolean respuesta = AutorDao.eliminarAutor(a.getIdAutor());
        
        if( respuesta ){
        response.sendRedirect("mensaje.jsp?men=Se actualizo correctamente");
        
        }else{        
            response.sendRedirect("mensaje.jsp?men=Error al actualizar");
        }
    }
    
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

