/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dulceria_53.Almacen;
import dulceria_53.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crist
 */
@WebServlet(name = "EditarPro", urlPatterns = {"/EditarPro"})
public class EditarPro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            String id = request.getParameter("id");
            Connection cn;
            Conexion c=new Conexion();
         cn=c.inicializa();
            out.println("<head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "\n"
                    + "        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n"
                    + "        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n"
                    + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n"
                    + "        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n"
                    + "        <jsp:include page=\"Menu.jsp\" />\n"
                    + "        <title>Modificar Producto</title>\n"
                    + "        <jsp:include page=Menu.jsp />"
                    + "  </head>");
            out.println("</head>");
            out.println("<body>");
            out.print("<style>\n" +
"            body { \n" +
"                background: mediumturquoise;\n" +
"            }\n" +
"        </style>");
            out.print("<nav class=\"navbar navbar-expand-lg \" style=\"background-color: aquamarine;\">\n" +
"            <a class=\"navbar-brand\" href=\"RedireccionFalcon\" style=\"color:black\">Falcon</a>\n" +
"            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"                <span class=\"navbar-toggler-icon\"></span>\n" +
"            </button>\n" +
"\n" +
"            <div class=\"collapse navbar-collapse nav-item active\" id=\"navbarSupportedContent\">\n" +
"                <ul class=\"navbar-nav mr-auto\">\n" +
"                    <li class=\"nav-item dropdown\">\n" +
"\n" +
"\n" +
"                        <a class=\"nav-link dropdown-toggle nav-item active\" style=\"color:black\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
"                            Almacen\n" +
"                        </a>\n" +
"                        <div class=\"dropdown-menu\" style=\"color:black\" aria-labelledby=\"Almacen\">\n" +
"                            <a class=\"dropdown-item\" href=\"AccesoAlmacen\">Ingresarproducto</a>\n" +
"                            <a class=\"dropdown-item\" href=\"AccionesAlmacen\">Acciones</a>\n" +
"                        </div>\n" +
"                    </li> \n" +
"\n" +
"\n" +
"                    <li class=\"nav-item dropdown\">\n" +
"                        <a class=\"nav-link dropdown-toggle nav-item active\" style=\"color:black\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
"                            Ventas\n" +
"                        </a>\n" +
"                        <div class=\"dropdown-menu\" style=\"color:black\" aria-labelledby=\"Ventas\">\n" +
"                            <a class=\"dropdown-item\" href=\"Vent\">Ventas</a>\n" +
"                            <a class=\"dropdown-item\" href=\"RegVentas\">Realizar Venta</a>\n" +
"                        </div>\n" +
"                    </li> \n" +
"\n" +
"\n" +
"                    <li class=\"nav-item dropdown\">\n" +
"                        <a class=\"nav-link dropdown-toggle\" href=\"#\" style=\"color:black\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
"                            Usuarios\n" +
"                        </a>\n" +
"                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n" +
"                            <a class=\"dropdown-item\"  href=\"AccesoUsuarios\">Agregar usuario</a>\n" +
"                            <a class=\"dropdown-item\" href=\"AccionesRegistro\">Acciones</a>\n" +
"                        </div>\n" +
"                    </li>\n" +
"                </ul>\n" +
"                <form class=\"form-inline my-2 my-lg-0\">\n" +
"\n" +
"                </form>\n" +
"            </div>\n" +
"        </nav>");
            try {
              cn=c.inicializa();
                if (cn != null) {
                    Statement sta = cn.createStatement();

                    ResultSet res = sta.executeQuery("Select * from Almacen where Id='" + id + "'");
                    while (res.next()) {

                        out.println("<form class=\"form-signin\"   method=\"POST\" >\n"
                                + "<div class=\"form-group container col-md-3\">\n");
                        out.print("<h3>Modficar producto</h3>");
                        out.print("Id: <input class=\"form-control\" readonly placeholder=\"Nombre\"type=\"text\" name=\"id\"value=\"");
                        out.print(res.getString("Id"));
                        out.print("\"<br>");
                        out.print("<br>");
                        out.print("Nombre: <input class=\"form-control\" placeholder=\"Nombre\"type=\"text\" name=\"nombre\"value=\"");
                        out.print(res.getString("Nombre"));
                        out.print("\"<br>");
                        out.print("<br>");
                        out.print("Cantidad: <input class=\"form-control\" placeholder=\"Cantidad\"type=\"text\" name=\"cantidad\"value=\"");
                        out.print(res.getString("Cantidad"));
                        out.print("\"<br>");
                        out.print("<br>");
                        out.print("Precio: <input class=\"form-control\" placeholder=\"Precio\"type=\"text\" name=\"precio\"value=\"");
                        out.print(res.getString("Precio"));
                        out.print("\"<br>");
                        out.print("<br>");
                        out.print("<input type=\"submit\" class=\"btn btn-lg btn-primary btn-block\" value=\"Guardar\"   />");
                        out.print("</form>");
                    }
                }
            } catch (Exception e) {

            }
            out.println("</body>");
            out.println("</html>");
            PreparedStatement st;
            String nombre = request.getParameter("nombre");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int precio = Integer.parseInt(request.getParameter("precio"));
            
            RequestDispatcher rd;

            try {
                cn=c.inicializa();
                st = cn.prepareStatement("update Almacen set Nombre='"+nombre+"',Cantidad="+cantidad+",Precio="+precio+"where Id='"+id+"'");
                st.executeUpdate();
                rd = request.getRequestDispatcher("./WEB-INF/jsp/AccionAlmacen.jsp");
                rd.forward(request, response);
            } catch (Exception e) {

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
