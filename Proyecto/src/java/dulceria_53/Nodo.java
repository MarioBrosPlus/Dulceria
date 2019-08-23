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
public class Nodo {
    private Object elemento;
    private Nodo siguiente;
    public Nodo(Venta x)
    {
        elemento = x;
        siguiente = null;
    } 

    public Venta getElemento() {
        return (Venta) elemento;
    }

    public void setElemento(Venta elemento) {
        this.elemento = elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
