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
public class Empleado {
    private String idEmpleado;
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private String puesto;
    private String foto;

    public Empleado(String idEmpleado, String nombre, String apellido, String usuario, String clave, String puesto, String foto) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
        this.puesto = puesto;
        this.foto = foto;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }



    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public String getUsuario() {
        return usuario;
    }



    public String getClave() {
        return clave;
    }



    public String getPuesto() {
        return puesto;
    }


    public String getFoto() {
        return foto;
    }
    
    
    
}
