<%@page import="modelo.dto.Usuario"%>
<%@page import="modelo.dao.AutorDao"%>
<%@page import="modelo.dto.Autor"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%-- Obtenemos el id o el codigo del producto que deseamos modificar o actualizar --%>
<%
    HttpSession sesion = null;
    Usuario usuarioSesion = new Usuario();
    Autor tmpAutor = new Autor();
%>



<!--ALGORITMO DE VALIDACION-->
<!--Scriplets-->
<% 
    sesion = request.getSession(true);
    
    //Existen tres casos para validar mi sesion
    if( sesion.isNew() ){
        response.sendRedirect("login.jsp");
    } else if( sesion == null ){
        response.sendRedirect("login.jsp");
    } else if( sesion.getAttribute("usuario") == null ){
        response.sendRedirect("login.jsp");
    }else{
        usuarioSesion = (Usuario)sesion.getAttribute("usuario");
        tmpAutor = (Autor)sesion.getAttribute("tmpAutor");
        System.out.println("JSP Index -> Usuario :  " + usuarioSesion.toString() );
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autores</title>
    </head>
    <body>
        <h1>Actualizar autor</h1>
        <div>          
            
        </div>
        <br >
        <%-- En el action del formulario le decimos que llama al Controlador --%>
        <form method="post" action="../Controlador">
            <div>
                <%-- Indica al controlador que vamos hacer una modificacion --%>
                <input type="hidden" name="accion" value="ModificarAutor" />
                <table border="1">
                    <tr>
                        <td>Codigo</td>
                        <%-- Escribimos el codigo del autor a modificar --%>
                        <td><input type="text" name="txtIdAutor" value="<%= tmpAutor.getIdAutor()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <%-- Escribimos el nombre del autor a modificar --%>
                        <td><input type="text" name="txtNombre" value="<%= tmpAutor.getNombre()%>" /></td>
                    </tr>
                    <tr>
                        <td>Apellido paterno</td>
                        <%-- Escribimos el ap del autor a modificar --%>
                        <td><input type="text" name="txtApellidoPaterno" value="<%= tmpAutor.getApellidoPaterno()%>" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Actualizar" name="btnActualizar" /></td>
                    </tr>
                </table>
            </div>
        </form>

    </body>
</html>
