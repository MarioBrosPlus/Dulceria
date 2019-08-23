/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dulceria_53.Venta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author crist
 */
@WebServlet(name = "Vender", urlPatterns = {"/Vender"})
public class Vender extends HttpServlet {

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    String codigo;
    String descripcion;
    int precio;
    int cantidad;
    int subtotal;
    int item;
    int total;
    int cantidadTotal;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            codigo = request.getParameter("id");
            descripcion = request.getParameter("nombre");
            precio = Integer.parseInt(request.getParameter("precio"));
            cantidad = Integer.parseInt(request.getParameter("cantidad"));
            cantidadTotal=Integer.parseInt(request.getParameter("can"));
            System.out.println("La cantidad del producto es : "+cantidadTotal);
            subtotal = precio * cantidad;
            total = 0;
            v.setCodigo(codigo);
            v.setPrecio(precio);
            v.setProducto(descripcion);
            v.setSubtotal(subtotal);
            v.setCantidad(cantidad);
            lista.add(v);
            request.setAttribute("lista", lista);
            for (int i = 0; i < lista.size(); i++) {
                total = total + lista.get(i).getSubtotal();
            }
            request.setAttribute("codigo",v.getCodigo());
            request.setAttribute("precio",v.getPrecio());
            request.setAttribute("producto",v.getProducto());
            request.setAttribute("cantidad",v.getCantidad());
            request.setAttribute("subtotal",subtotal);
            request.setAttribute("cantidadactual",cantidadTotal);
            request.getRequestDispatcher("./WEB-INF/jsp/RegistrarVenta.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(Vender.class.getName()).log(Level.SEVERE, null, ex);
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
