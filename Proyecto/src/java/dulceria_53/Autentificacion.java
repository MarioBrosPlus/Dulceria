/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import dulceria_53.Conexion;
import java.sql.SQLException;
import org.apache.commons.dbcp.DelegatingResultSet;

/**
 *
 * @author Gera
 */
public class Autentificacion {

    private String usuario;
    private String clave;
    private Empleado persona;

    public Autentificacion(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;

    }

    public boolean validacion() throws ClassNotFoundException {
        Connection cn;
        
        try {
            Conexion c=new Conexion();
            cn=c.inicializa();
            if (cn != null) {
                Statement sta = cn.createStatement();
                ResultSet res = sta.executeQuery("Select * from Registro where usuario ='" + getUsuario() + "' and clave='" + getClave() + "'");
                if (res.next()) {
                    String nombre = res.getString("Nombre");
                    res.close();
                    sta.close();
                    return true;
                } else {
                    res.close();
                    sta.close();

                }
            }
            return false;
            //4. Cierre de la conexión
            //cn.close(); 
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return false;
        }
    }

//    public Empleado obtenerDatos() {
//        Connection cn;
//        Conexion conex = new Conexion();
//        try {
//            cn = conex.dataSource.getConnection();
//                Statement sta = cn.createStatement();
//                ResultSet resultado = sta.executeQuery("Select * from Registro where usuario ='" + getUsuario() + "'");
//            //3. Ejecución de la instrucción
//                if (resultado.next()) {
//                    persona = new Empleado(resultado.getString("ID"), resultado.getString("Nombre"),
//                            resultado.getString("Apellido"), resultado.getString("Usuario"), resultado.getString("Clave"),
//                            resultado.getString("Puesto"), resultado.getString("Imagen"));
//                }
//            
//            //4. Cierre de la conexión
//            //cn.close(); 
//        } catch (Exception e) {
//            //JOptionPane.showMessageDialog(null, "Error "+e);
//        }
//        return persona;
//    }
    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
}
