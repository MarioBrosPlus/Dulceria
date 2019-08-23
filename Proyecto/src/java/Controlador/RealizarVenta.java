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
@WebServlet(name = "RealizarVenta", urlPatterns = {"/RealizarVenta"})
public class RealizarVenta extends HttpServlet {

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
            Connection cn;
            Conexion c = new Conexion();
            PreparedStatement st;
            cn = c.inicializa();
            String id = request.getParameter("id");
            int cantidadneta=Integer.parseInt(request.getParameter("cantidadneta"));
            String nombre = request.getParameter("producto");
            int prec=Integer.parseInt(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            String subtotal = request.getParameter("subtotal");
            out.print(nombre);
            try {
                //Se modifico con un procedimiento almacenado
                st = cn.prepareStatement("select venta3('" + id + "','" + nombre + "'," + prec + "," + cantidad + "," + cantidadneta + ");");
                st.executeQuery();
                System.out.println("cantidad neta "+cantidadneta);
                System.out.println("cantidad pedida "+cantidad);
                int totaluni =cantidadneta - cantidad;
                System.out.println(cantidadneta);
                System.out.println("total "+totaluni);
                cn.close();
                /*cn=c.inicializa();
                st = cn.prepareStatement("update Almacen set cantidad='"+String.valueOf(totaluni)+"' where id='" + id + "'");
                st.executeUpdate();*/
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("./WEB-INF/jsp/Menu.jsp");
                rd.forward(request, response);

            } catch (SQLException ex) {
                out.print(ex);
                Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
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
