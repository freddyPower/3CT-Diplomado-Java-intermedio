
<!--USO DE RECURSOS-->
<!--Directivas-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
         <link href="recursos/css/bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <h1>Un pequeno sistema de Mantenimiento</h1>
        
        <br/>
        
        <!--Contenedor de exit-->
        <div class="container">
            <a href="">
                <form action="CtrlCerrarSesion" method="POST">
                    
                    <input class="btn btn-danger" type="submit" value="Cerrar Sesión">
                    
                </form>
            </a>
        </div>
        
        <div>
            <%-- Menu de opciones --%>
            <a href="index.jsp">Inicio</a> |
            <a href="autores/mantenimiento-autores.jsp">Mantenimiento Autores</a> |
            <a href="titulos/mantenimiento.titulos.jsp">Mantenimiento Titulos</a> |
            
        </div>
        <br/>
        <%--Tabla--%>
        <div>
          
        </div>
    </body>
</html>
