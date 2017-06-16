package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.TituloDao;
import modelo.dto.Titulo;

@WebServlet(name = "CtrlTitulos", urlPatterns = {"/CtrlTitulos"})
public class CtrlTitulos extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            //Paso #1 
            String accion = request.getParameter("accionCtrlTitulos");
            
            //Seleccionar el metodo adecuado obtenido por accion
            if (accion.equals("RegistrarTitulo")) {
                this.registrarTitulo(request, response);

            } else if (accion.equals("ModificarTitulo")) {

                this.modificarTitulo(request, response);

            } else if (accion.equals("ELiminarTitulo")) {

                this.eliminarTitulo(request, response);
            }
        
    }//FIn del metodo processRequest
    
    private void registrarTitulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("RegistrarTitulo");
        //Paso # 1 obtener los valores del formulario para insertar un nuevo titulo
        Titulo t = new Titulo();
        String isbn = request.getParameter("txtIsbn");   
        String titulo = request.getParameter("txtTitulo");
        String copyright = request.getParameter("txtCopyright");
        int numeroEdicion  = Integer.parseInt(request.getParameter("txtNumeroEdicion"));
        
        t.setIsbn( isbn );
        t.setTitulo(titulo);
        t.setCopyright(copyright);
        t.setNumeroEdicion(numeroEdicion);
        
        //Paso #2 Almacenar la respuesta al ejecutar el metodo dao correspondiente
        boolean respuesta = TituloDao.insertaTitulo(t);
        
        //Paso#3 : Avisar a mi usuario por medio de redirecciones si mi transaccion fue correcta
        if( respuesta == true ){            
            response.sendRedirect("mensaje.jsp?men=Se registro correctamente");            
        }else{
            response.sendRedirect("mensaje.jsp?men=No se registro correctamente");
        }
        
    }
     
    private void modificarTitulo(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Modificar");
    }

    private void eliminarTitulo(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ELiminar");
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
