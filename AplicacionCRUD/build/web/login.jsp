<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SUPER LOGIN</title>
        <link href="recursos/css/bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <h1>Inicio de sesion!</h1>
        
        <form action="/AplicacionCRUD/CtrlValidacion" method="post" role="form">
            
            <fieldset>
                
                <div class="form-group">
                    <input class="form-control" placeholder="Usuario" 
                           name="usuario" type="email" autofocus>
                </div>
                <div class="form-group">
                    <input class="form-control" placeholder="Password" 
                           name="password" type="password" value="">
                </div>
                <div class="form-group">
                    <a href="/usuarios/registro.jsp" > Registro </a>
                </div>
                <div class="form-group" >
                    <input type="submit" class="btn btn-lg btn-danger" value="Iniciar sesión">
                </div>
            </fieldset>
            
            
        </form>
        
    </body>
</html>
