<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/">
        <%@ page import='dulceria_53.Autentificacion' %>
        <% System.setProperty("java.awt.headless", "false");%>
    </head>

    <body class="text-center">
        <br>
        <br>
    <style>
        body { 
            background:aquamarine;
        }
    </style>
    <form  class="form-signin" method="post" action="Inicio" >
        <h1 class="h3 mb-3 font-weight-normal">Dulceria Falcón</h1>
        <h3>Inicio de sesión</h3>
        <div class="container col-md-3">
            Usuario:<input type="text"  class="form-control" name="usuario" autocomplete=off></input>
            <br>
            <br>
            Contraseña:<input type="password"  class="form-control" name="contrasena"></input>

            <br>
            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Ingresar"   />
        </div>

    </form>
    <%
        try {
            String msg = session.getAttribute("msg").toString();
            out.print(msg);
            session.removeAttribute("msg");
        } catch (Exception e) {

        }
    %>
</body>
</html>
