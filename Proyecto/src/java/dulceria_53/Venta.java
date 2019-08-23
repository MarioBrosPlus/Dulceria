/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

/**
 *
 * @author Gera
 */
public class Venta {
    
   private String producto;
   private int cantidad;
   private int precio;
   private int total;
   private String codigo;
   private int subtotal;

    public Venta() {
    }

    public Venta(String producto, int cantidad, int precio, int total, String codigo, int subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.codigo = codigo;
        this.subtotal = subtotal;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
