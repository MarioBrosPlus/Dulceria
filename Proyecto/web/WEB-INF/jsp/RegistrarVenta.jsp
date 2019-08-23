<%-- 
    Document   : RegistrarVenta
    Created on : 18/08/2019, 02:13:40 PM
    Author     : crist
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="dulceria_53.Conexion"%>
<%@page import="dulceria_53.Venta"%>
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
        <title>Ventas</title>
    </head>
    <body>
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

        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="" method="POST">
                        <div class="card-body ">
                            <div class="form-group">
                                <label>Venta</label>
                            </div>
                            <div class="form-group ">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="idP" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accP" value="Buscar" class="btn btn-outline-info">
                                </div>
                            </div>
                        </div>
                    </form>
                    <%
                        Connection cn;
                        String nobusc = request.getParameter("idP");
                        try {
                            Conexion c = new Conexion();
                            cn = c.inicializa();
                            if (cn != null) {
                                Statement sta = cn.createStatement();
                                ResultSet res = sta.executeQuery("Select * from Almacen where Id='" + nobusc + "';");
                                while (res.next()) {
                    %>


                    <form  action="Vender" method=POST>
                        <div class="card-body ">
                            <div class="form-group">                                    
                                <label>Datos del producto</label>
                                <div class="col-sm-6 ">
                                    <input type="hidden" name="id" readonly value="<%=res.getString("Id")%>" class="form-control">
                                    <input type="text" name="nombre" readonly value="<%=res.getString("Nombre")%>" placeholder="Nombre" class="form-control">
                                    <br>
                                </div>
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" readonly class="form-control" value="<%=res.getString("Precio")%>" placeholder="$/ 0.00 mx">
                                </div>

                                <div class="col-sm-6 ">
                                    <br>
                                    <input type="number" name="cantidad" value="1"  placeholder="Cantidad" class="form-control">
                                </div>
                                <div class="col-sm-6 ">
                                    <br>
                                    <input type="hidden" name="can" readonly value="<%=res.getString("Cantidad")%>" class="form-control">
                                    <input type="text" name="stock" readonly value="<%=res.getString("Cantidad")%>"  placeholder="Stock" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="accion" value="Agregar a carro" class="btn btn-outline-info">
                            </div>                            
                        </div>
                    </form>

                    <%
                                }
                            }
                        } catch (Exception e) {
                            out.print(e);
                        }
                    %>
                </div> 


            </div>
                <div class="col-sm-7">
                    <div class="card">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><%=request.getAttribute("codigo")%></td>
                                    <td><%=request.getAttribute("producto")%></td>
                                    <td><%=request.getAttribute("precio")%></td>
                                    <td><%=request.getAttribute("cantidad")%></td>
                                    <td><%=request.getAttribute("subtotal")%></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                                    
            <form action="RealizarVenta" method="post">
                    <div class="card-footer">
                        <div>
                            <input type="hidden" value="<%=request.getAttribute("cantidadactual")%>" name="cantidadneta">
                            <input type="hidden" value="<%=request.getAttribute("codigo")%>" name="id">
                            <input type="hidden" value="<%=request.getAttribute("producto")%>" name="producto">
                            <input type="hidden" value="<%=request.getAttribute("precio")%>" name="precio">
                            <input type="hidden" value="<%=request.getAttribute("cantidad")%>" name="cantidad">
                            <input type="hidden" value="<%=request.getAttribute("subtotal")%>" name="subtotal">
                            <input type="submit" name="vender" value="Vender" class="btn btn-success">
                        </div>
                    </div>
                            
            </form>
                </div>
        </div>    
    </body>
</html>
