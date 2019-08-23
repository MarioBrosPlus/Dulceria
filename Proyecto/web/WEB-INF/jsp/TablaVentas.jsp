<%-- 
    Document   : TablaVentas
    Created on : 18/08/2019, 01:55:31 AM
    Author     : crist
--%>

<%@page import="dulceria_53.Conexion"%>
<%@page import="java.sql.*"%>
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
        <h1>Ventas</h1>
    </p>
    <%
        Connection cn;

        try {
            
            Conexion c=new Conexion();
            cn=c.inicializa();
            if (cn != null) {
                Statement sta = cn.createStatement();
                ResultSet res = sta.executeQuery("Select * from Ventas");
                
    %>  
    <br> 
    <br> 
    <div  class="table-responsive row d-flex justify-content-center " >

        <table class="table table-bordered table-hover col-md-9 centered" >
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Producto</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Total</th>
                    <th scope="col">Codigo</th>
                </tr>
            </thead>
            <tbody >
                <%  while (res.next()) {%>
                <tr >

                    <td ><%= res.getString("Producto")%></input></td>
                    <td><%= res.getString("Cantidad")%></td>
                    <td><%= res.getString("Total")%></td>
                    <td><%= res.getString("Codigo")%></td>
                  

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
