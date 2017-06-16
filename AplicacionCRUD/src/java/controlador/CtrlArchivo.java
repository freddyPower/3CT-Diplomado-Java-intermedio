

package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemFactory;

@WebServlet(name = "CtrlArchivo", urlPatterns = {"/CtrlArchivo"})
public class CtrlArchivo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //Paso 1 Instanciar factory  y upload para el manejo del archivo
        FileItemFactory factory = new DiskFIleItemFactory();
        ServletFIleUpload upload = new ServletFileUpload(factory);
        
        //Los items obtenidos  provienen de los campos del formulario
        List items = upload.parseRequest( request );
        
        //Iteracion para cada uno de los elementos obtenidos
        //Se asigna un espacio en el servidor para c/u de los elementos
        for( Object item : items ){
        
            FileItem uploaded = ( FileItem ) item;
            
            //Validacion
            //Comprobar si proviene de un campo de formulario. Si no lo es
            // se guarda el fichero en la ruta que nos interese
            if( !uploaded.isFormField() ){
                
                //No es un campo de formulario, guardamos el fichero
                File fichero = new File("Users/luis/" , uploaded.getName());
            
            }else{
                //Es un input de formulario, podemos obtener atributos clave valor
                String key = uploaded.getFieldName();
                String valor = uploaded.getString();
            
            }
                
            
        }
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
