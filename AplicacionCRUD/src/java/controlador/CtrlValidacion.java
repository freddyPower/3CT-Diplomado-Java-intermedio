
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.UsuarioDao;
import modelo.dto.Usuario;

@WebServlet(name = "CtrlValidacion", urlPatterns = {"/CtrlValidacion"})
public class CtrlValidacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Paso 1 obtener los parametros que envia el html 
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        //Creamos un usuario de sesion
        Usuario usuarioSesion = null;
        
        System.out.println("CTRLValidacion: params -> usuario: "
                + usuario + " password: " + password  );
        
        boolean respuesta = UsuarioDao.autenticacion(usuario, password);
        
        System.out.println("CTRLValidacion: respuesta de la consulta DAO Autenticacion: " + respuesta);
        
        if( respuesta ){
            usuarioSesion = UsuarioDao.obtenerUsuario( usuario , password );
            
            //System.out.println("CTRLValidacion: usr obtenido: " + usuarioSesion);      
            
            //Creamos una nueva sesion
            HttpSession sesion = request.getSession(true);
            
            //Asignamos un atributo de nombre "usuario" y de valor usuarioSesion a la nueva sesion
            sesion.setAttribute("usuario", usuarioSesion);
            System.out.println("Usuario en sesion: " + sesion.getAttribute("usuario").toString()  );
            
            response.sendRedirect("index.jsp");
            
        }else{
            response.sendRedirect("login.jsp");
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
