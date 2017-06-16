
<%@page import="modelo.dto.Autor"%>
<%@page import="modelo.dao.AutorDao"%>
<%-- imports necesarios --%>
<%@page import="java.util.ArrayList"%>

<%--<%@page import="java.util.*"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!--USO DE RECURSOS-->
<!--Directivas-->

<%@page import="modelo.dto.Usuario" %>

<!--DECLARACION DE VARIABLES-->
<!--Declaracion-->
<%!
    HttpSession sesion = null;
    Usuario usuarioSesion = new Usuario();
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
        System.out.println("JSP Index -> Usuario :  " + usuarioSesion.toString() );
    }
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Aplicacion CRUD</title>
        <link href="../recursos/css/bootstrap.css"  rel="stylesheet">
    </head>
    <body>
        <h1>Un pequeno sistema de Mantenimiento</h1>
        <div>
            <%-- Menu de opciones --%>
            <a href="../index.jsp">Inicio</a> |
            <a href="mantenimiento-autores.jsp">Mantenimiento Autores</a> |
            <a href="../titulos/mantenimiento.titulos.jsp">Mantenimiento Titulos</a> |
            
        </div>
        <br/>
        <%--Tabla--%>
        <div>
            <table border="1" class="table table-striped">
                <tr style="background-color: cyan">
                    <td colspan="4">Autores <a style="float:right" href="insertar-autor.jsp"> Nuevo </a></td> 
                </tr>
                <tr style="background-color: cyan">
                    <td>Id Autor</td>
                    <td>Nombre</td>
                    <td>Apellido</td>
                    <td>Acciones</td>
                </tr>
                <%-- Listamos los autores por medio de un scriplet --%>
                <%
                    ArrayList<Autor> lista = AutorDao.obtenerAutores();
                    for( Autor a : lista ){         
                %>
                <tr>
                    <td> <%= a.getIdAutor()%> </td>
                    <td> <%= a.getNombre() %> </td>
                    <td> <%= a.getApellidoPaterno()%> </td>
                    <%-- Enlaces a las paginas de actualizar  --%>                    
                    <td>
                        <a href="actualizar-autor.jsp?<% sesion.setAttribute("tmpAutor", a); %>"> Modificar </a> |
                        <a href="eliminar-autor.jsp?id=<%= a.getIdAutor()%>"> Eliminar </a>
                    </td>
                </tr>
                <% } %>
            </table>
        </div>
    </body>
</html>
