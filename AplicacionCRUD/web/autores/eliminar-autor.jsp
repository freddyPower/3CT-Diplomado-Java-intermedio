<%@page import="modelo.dao.AutorDao"%>
<%@page import="modelo.dto.Autor"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%-- Obtenemos el id o el codigo del producto que deseamos modificar o actualizar --%>
<%
    Autor a=AutorDao.obtenerAutor(Integer.parseInt(request.getParameter("id")));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autores</title>
    </head>
    <body>
        <h1>Eliminar autor</h1>
        <div>
            
            
        </div>
        <br >
        <%-- En el action del formulario le decimos que llama al Controlador --%>
        <form method="post" action="../Controlador">
            <div>
                ¿Seguro que desea eliminar el autor?
                <%-- Indica al controlador que vamos hacer una modificacion --%>
                <input type="hidden" name="accion" value="EliminarAutor" />
                <table border="1">
                    <tr>
                        <td>Codigo</td>
                        <%-- Escribimos el codigo del autor a modificar --%>
                        <td><input type="text" name="txtIdAutor" value="<%= a.getIdAutor()%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <%-- Escribimos el nombre del autor a modificar --%>
                        <td><input type="text" name="txtNombre" value="<%= a.getNombre()%>" readonly/></td>
                    </tr>
                    <tr>
                        <td>Apellido paterno</td>
                        <%-- Escribimos el ap del autor a modificar --%>
                        <td><input type="text" name="txtApellidoPaterno" value="<%= a.getApellidoPaterno()%>" readonly/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Eliminar" name="btnEliminar" /></td>
                    </tr>
                </table>
            </div>
        </form>

    </body>
</html>
