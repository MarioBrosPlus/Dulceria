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
public class Producto {
    private String idProducto;
    private int precio;
    private int cantidad;
    private String nombre;

    public Producto(String idProducto, int precio, int cantidad, String nombre) {
        this.idProducto = idProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public String getIdPrducto() {
        return idProducto;
    }


    public int getPrecio() {
        return precio;
    }


    public int getCantidad() {
        return cantidad;
    }


    public String getNombre() {
        return nombre;
    }


    
    
}
