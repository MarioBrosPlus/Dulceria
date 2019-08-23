/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gera
 */
public class ColaVentas {
    
    protected Nodo frente;
    public Nodo fin;
    // constructor: crea cola vacía
    public ColaVentas()
    {
     frente = fin = null;
    }
    
    public boolean colaVacia()
    {
        return (frente == null);
    } 
    // insertar: pone elemento por el final
    public void insertar(Venta elemento)
    {
        Nodo a;
        a = new Nodo(elemento);
        if (colaVacia())
        {
            frente = a;
        }
        else
        {
            fin.setSiguiente(a); 
        }
        fin = a;
    }
    public Venta quitar() throws Exception
    {
       Venta aux = null;
       if (!colaVacia())
       {
        aux = (Venta) frente.getElemento();
        frente = frente.getSiguiente();
       }
       else
           JOptionPane.showMessageDialog(null, "Las ventas estan vacias");
       return aux;
    }
    // libera todos los nodos de la cola
    public void borrarCola()
    {
        for (; frente != null;)
        {
            frente = frente.getSiguiente();
        }
        System.gc();   
    } 
    public Venta frenteCola() throws Exception
    {
        if (colaVacia())
        {
            JOptionPane.showMessageDialog(null, "Las ventas estan vacias");
        }
        return (Venta) (frente.getElemento());
    }

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    
    
}
