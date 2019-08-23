<%-- 
    Document   : AccionAlmacen
    Created on : 9/08/2019, 08:28:28 AM
    Author     : crist
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="dulceria_53.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


        <title>Accion almacen</title>
    </head>
    <body class="text-center">
        <style>
            body { 
                background: mediumturquoise;
            }
        </style>
        <nav class="navbar navbar-expand-lg " style="background-color: aquamarine;">
            <a class="navbar-brand" href="RedireccionFalcon" style="color:black">Falcon</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse nav-item active" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">


                        <a class="nav-link dropdown-toggle nav-item active" style="color:black" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Almacen
                        </a>
                        <div class="dropdown-menu" style="color:black" aria-labelledby="Almacen">
                            <a class="dropdown-item" href="AccesoAlmacen">Ingresar producto</a>
                            <a class="dropdown-item" href="AccionesAlmacen">Acciones</a>
                        </div>
                    </li> 


                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle nav-item active" style="color:black" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Ventas
                        </a>
                        <div class="dropdown-menu" style="color:black" aria-labelledby="Ventas">
                            <a class="dropdown-item" href="Vent">Ventas</a>
                            <a class="dropdown-item" href="RegVentas">Realizar Venta</a>
                        </div>
                    </li> 


                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" style="color:black" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Usuarios
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item"  href="AccesoUsuarios">Agregar usuario</a>
                            <a class="dropdown-item" href="AccionesRegistro">Acciones</a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">

                </form>
            </div>
        </nav>
        <p>
            <br>
        <h1>Almacen</h1>
    </p>
    <%
        Connection cn;
        try {
            
            Conexion c=new Conexion();
            cn=c.inicializa();
            if (cn != null) {
                Statement sta = cn.createStatement();
                ResultSet res = sta.executeQuery("Select * from Almacen");
                
    %>  
    <form class="form-inline my-2 my-lg-0">
        <div class="container col-sm-6">
            <input class="form-control mr-sm-2" name="busqueda" type="search" placeholder="Search" aria-label="Search">
            <input type="submit" class="btn btn-outline-success my-2 my-sm-0" value="Buscar"></input>

        </div>
    </form><%
        String nobusc = request.getParameter("busqueda");
        if (nobusc != null) {

            try {
            cn=c.inicializa();
                if (cn != null) {
                    Statement st = cn.createStatement();
                    res = st.executeQuery("select * from Almacen where Nombre like '%" + nobusc + "%'");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    %>
    <br> 
    <br> 
    <div  class="table-responsive row d-flex justify-content-center " >

        <table class="table table-bordered table-hover col-md-9 centered" >
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Modificar</th>
                    <th scope="col">Eliminar</th>
                </tr>
            </thead>
            <tbody >
                <%  while (res.next()) {%>
                <tr >

                    <td ><%= res.getString("Id")%></input></td>
                    <td><%= res.getString("Nombre")%></td>
                    <td><%= res.getString("Cantidad")%></td>
                    <td><%= res.getString("Precio")%></td>
                    <td>

                        <a href="EditarPro?id=<%= res.getString("Id")%>" class="btn btn-info">Modificar</a>
                    </td>
                    <td>
                        <a href="CambiosProdu?id=<%= res.getString("Id")%>"><iput type="submit" class="btn btn-danger">Eliminar</iput></a>
                    </td>

                </tr>
                <% }
                        }
                    } catch (Exception e) {
                        out.print(e);
                    }%>
            </tbody>
        </table>

    </div >


</body>
</html>
