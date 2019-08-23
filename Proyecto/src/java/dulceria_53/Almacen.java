/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.swing.JOptionPane;

/**
 *
 * @author Gera
 */
public class Almacen {

    private Producto dulce;
    private Empleado usuario;
    Connection cn;
    Conexion conex = new Conexion();

    public boolean Alta(Producto ingreso, Empleado ingresador) throws ClassNotFoundException {
        usuario = ingresador;
        dulce = ingreso;
        try {
            
            Conexion c=new Conexion();
            cn=c.inicializa();
            String tsql = "INSERT INTO Almacen values ('" + dulce.getIdPrducto() + "','" + dulce.getNombre() + "'," + dulce.getCantidad()
                    + "," + dulce.getPrecio() + ");";
            PreparedStatement s = cn.prepareStatement(tsql);
            s.executeUpdate();
            //4. Cierre de la conexión
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int actualizar(String idProducto, String nombre, int precio, int cantidad) {
        int resultado = 0;
        try {
            //1. Conexión con la base de datos
            Statement st;
            st = cn.createStatement();
            String tsql = "UPDATE Almacen SET Nombre ='" + nombre + "',Cantidad= " + cantidad + ",Precio =" + precio
                    + " WHERE ID = '" + idProducto + "';";
            //3. Ejecución de la instrucción
            PreparedStatement s = cn.prepareStatement(tsql);
            s.executeUpdate();
            //4. Cierre de la conexión
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar " + e);
        }
        return resultado;
    }

    public int eliminar(String condicion) {
        int resultado = 0;
        try {
            //1. Conexión con la base de datos
            Statement st;
            st = cn.createStatement();
            String tsql = "DELETE FROM  Almacen WHERE Nombre = '" + condicion
                    + "';";
            //3. Ejecución de la instrucción
            resultado = st.executeUpdate(tsql);
            //4. Cierre de la conexión
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar " + e);
        }
        return resultado;
    }

    public ResultSet consultarNombres() {//ResulSet es una cuadrilla de resultados
        ResultSet resultado = null;
        try {
            Statement st;
            st = cn.createStatement();
            String tsql = "SELECT Nombre FROM Almacen;";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
            // cn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet consultaPersonal(String parametro) {//ResulSet es una cuadrilla de resultados
        ResultSet resultado = null;
        try {
            Statement st;
            st = cn.createStatement();
            String tsql = "SELECT * FROM Almacen where Nombre='" + parametro + "';";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
            //cn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet consultar() {//ResulSet es una cuadrilla de resultados
        ResultSet resultado = null;
        try {
            Statement st;
            st = cn.createStatement();
            String tsql = "SELECT * FROM Almacen;";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
            // cn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet consultarID(String parametro) {//ResulSet es una cuadrilla de resultados
        ResultSet resultado = null;
        try {
            Statement st;
            st = cn.createStatement();
            String tsql = "SELECT ID FROM Almacen where Nombre='" + parametro + "';";
            //3. Ejecución de la instrucción
            resultado = st.executeQuery(tsql);
            //4. Cierre de la conexión
            //cn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void cerrarConexion() {
        try {
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
