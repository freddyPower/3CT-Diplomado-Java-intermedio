<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*" %>
<%--<%@page import="java.util.*" %>--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Autor</title>
    </head>
    <body>
        <h1>Insertar autor</h1>
        <div>
            <a href="index.jsp">Inicio</a> |
            <a href="mantenimiento-autores.jsp">Mantenimiento Autores</a> |
            <a href="mantenimiento.titulos.jsp">Mantenimiento Titulos</a> |
            
        </div>
        <br >
        <%-- En el action del formulario le decimos que llama al Controlador --%>
        <form method="post" action="../Controlador">
            <div>
                <input type="hidden" name="accion" value="RegistrarAutor" />
                <table border="1">
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellido</td>
                        <td><input type="text" name="txtApellidoPaterno" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Registrar" name="btnRegistrar" /></td>
                    </tr>
                </table>
            </div>
        </form>

    </body>
</html>