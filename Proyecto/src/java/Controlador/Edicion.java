/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dulceria_53.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Edicion", urlPatterns = {"/Edicion"})
public class Edicion extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            String id = request.getParameter("id").trim();
            
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
                    + "        <title>Modificar Registro</title>\n"
                    + "        <jsp:include page=Menu.jsp />"
                    + "  </head>");
            out.println("<body>");
            out.print("<style>\n"
                    + "            body { \n"
                    + "                background: mediumturquoise;\n"
                    + "            }\n"
                    + "        </style>");
            out.print("<nav class=\"navbar navbar-expand-lg \" style=\"background-color: aquamarine;\">\n"
                    + "            <a class=\"navbar-brand\" href=\"RedireccionFalcon\" style=\"color:black\">Falcon</a>\n"
                    + "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                    + "                <span class=\"navbar-toggler-icon\"></span>\n"
                    + "            </button>\n"
                    + "\n"
                    + "            <div class=\"collapse navbar-collapse nav-item active\" id=\"navbarSupportedContent\">\n"
                    + "                <ul class=\"navbar-nav mr-auto\">\n"
                    + "                    <li class=\"nav-item dropdown\">\n"
                    + "\n"
                    + "\n"
                    + "                        <a class=\"nav-link dropdown-toggle nav-item active\" style=\"color:black\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n"
                    + "                            Almacen\n"
                    + "                        </a>\n"
                    + "                        <div class=\"dropdown-menu\" style=\"color:black\" aria-labelledby=\"Almacen\">\n"
                    + "                            <a class=\"dropdown-item\" href=\"AccesoAlmacen\">Ingresarproducto</a>\n"
                    + "                            <a class=\"dropdown-item\" href=\"AccionesAlmacen\">Acciones</a>\n"
                    + "                        </div>\n"
                    + "                    </li> \n"
                    + "\n"
                    + "\n"
                    + "                    <li class=\"nav-item dropdown\">\n"
                    + "                        <a class=\"nav-link dropdown-toggle nav-item active\" style=\"color:black\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n"
                    + "                            Ventas\n"
                    + "                        </a>\n"
                    + "                        <div class=\"dropdown-menu\" style=\"color:black\" aria-labelledby=\"Ventas\">\n"
                    + "                            <a class=\"dropdown-item\" href=\"Vent\">Ventas</a>\n"
                    + "                            <a class=\"dropdown-item\" href=\"RegVentas\">Realizar Venta</a>\n"
                    + "                        </div>\n"
                    + "                    </li> \n"
                    + "\n"
                    + "\n"
                    + "                    <li class=\"nav-item dropdown\">\n"
                    + "                        <a class=\"nav-link dropdown-toggle\" href=\"#\" style=\"color:black\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n"
                    + "                            Usuarios\n"
                    + "                        </a>\n"
                    + "                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n"
                    + "                            <a class=\"dropdown-item\"  href=\"AccesoUsuarios\">Agregar usuario</a>\n"
                    + "                            <a class=\"dropdown-item\" href=\"AccionesRegistro\">Acciones</a>\n"
                    + "                        </div>\n"
                    + "                    </li>\n"
                    + "                </ul>\n"
                    + "                <form class=\"form-inline my-2 my-lg-0\">\n"
                    + "\n"
                    + "                </form>\n"
                    + "            </div>\n"
                    + "        </nav>");
            try {
                if (cn != null) {
                    Statement sta = cn.createStatement();
                    ResultSet res = sta.executeQuery("Select* from Registro where id='" + id + "';");

                    while (res.next()) {
                        out.println("<form class=\"form-signin\"   method=\"POST\" >\n"
                                + "<div class=\"form-group container col-md-3\">\n");
                        out.print("<h3>Modficar producto</h3>");
                        out.print("Id: <input class=\"form-control\" readonly placeholder=\"Nombre\"type=\"text\" name=\"id\"value=\"");
                        out.print(res.getString("id"));
                        out.print("\"<br>");
                        out.print("<br>");
                        out.print("Nombre: <input class=\"form-control\" placeholder=\"Nombre\"type=\"text\" name=\"nombre\"value=\"");
                        //out.print(nombre);
                        out.print(res.getString("nombre"));
                        out.print("\"<br>");
                        out.print("<br>");
                        out.print("Apellido: <input class=\"form-control\" placeholder=\"Usuario\"type=\"text\" name=\"apellido\"value=\"");
                        // out.print(apellido);
                        out.print(res.getString("apellido"));
                        out.print("\"<br>");
                        out.print("<br>");
                        out.print("Usuario: <input class=\"form-control\" placeholder=\"Apellido\"type=\"text\" name=\"usuario\"value=\"");
                        // out.print(usuario);
                        out.print(res.getString("usuario"));
                        out.print("\"<br>");
                        out.print("Clave: <input class=\"form-control\" placeholder=\"Clave\"type=\"text\" name=\"clave\"value=\"");
                        // out.print(clave);
                        out.print(res.getString("clave"));
                        out.print("\"<br>");
                        out.print("<br>");
                        out.print("Seleccionar:<SELECT NAME=\"puesto\" SIZE=1 > \n"
                                + "                    <OPTION VALUE=\"Administrador\">Administrador</OPTION>\n"
                                + "                    <OPTION VALUE=\"Empleado\">Empleado</OPTION>\n"
                                + "                    <OPTION VALUE=\"Gerente\">Gerente</OPTION>\n"
                                + "                </SELECT><br>");
                        //   out.print(puesto);
                        out.print("<br>");
                        out.print("<input type=\"submit\" class=\"btn btn-lg btn-primary btn-block\" value=\"Guradar\"   />");
                        out.print("</form>");
                    }
                }
            } catch (SQLException e) {
                out.print(e);
            }
            out.println("</body>");
            out.println("</html>");
            PreparedStatement st;
            //String nombre = request.getParameter("nombre");

            RequestDispatcher rd;
            String nombre = request.getParameter("nombre").trim();
            String usuario = request.getParameter("usuario").trim();
            String apellido = request.getParameter("apellido").trim();
            String clave = request.getParameter("clave").trim();
            String puesto = request.getParameter("puesto").trim();

                Class.forName("org.postgresql.Driver");
            try {
         cn=c.inicializa();
                st = cn.prepareStatement("update Registro set Nombre='" + nombre + "',Apellido='" + apellido + "',Usuario='" + usuario + "',Clave='" + clave + "',puesto='" + puesto + "'where Id='" + id + "'");
                st.executeUpdate();
                rd = request.getRequestDispatcher("./WEB-INF/jsp/AccionUsuarios.jsp");
                rd.forward(request, response);
            } catch (SQLException e) {
                out.print(e);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Edicion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Edicion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
