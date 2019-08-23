/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

import java.awt.Desktop;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Gera
 */
public class Ventas {
    
    Connection cn;
    ColaVentas cola;
    
   // public ResultSet obtenerCantidad(String parametro){
//        String cadena = "";
//        ResultSet resultado = null;
//        try {           
//            Statement st;
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
//            //2. Definición de la instrucción
//            st = cn.createStatement();
//            String tsql = "SELECT Cantidad FROM Almacen where Nombre='"+parametro+"';";
//            //3. Ejecución de la instrucción
//            resultado = st.executeQuery(tsql);
//            //4. Cierre de la conexión
//            //cn.close(); 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //cadena=String.valueOf(resultado);
//        return resultado;
//    }
//    
//    public ResultSet obtenerPrecio(String parametro){
//        String cadena = "";
//        int total = 0;
//        ResultSet resultado = null;
//        try {           
//            Statement st;
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
//            //2. Definición de la instrucción
//            st = cn.createStatement();
//            String tsql = "SELECT Precio FROM Almacen where Nombre='"+parametro+"';";
//            //3. Ejecución de la instrucción
//            resultado = st.executeQuery(tsql);
//            //4. Cierre de la conexión
//            //cn.close(); 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //cadena = String.valueOf(resultado);
//        //total=Integer.parseInt(cadena);
//        return resultado;
//    }
//    public void realizarInforme(ColaVentas vendido) throws IOException{
//        Date now = new Date(System.currentTimeMillis());
//        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
//        String fecha=String.valueOf(date.format(now));
//        try{
//            String ruta=fecha+".txt";
//            File file = new File(ruta);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            FileWriter fw = new FileWriter(file);
//            BufferedWriter bw = new BufferedWriter(fw);
//            bw.write("La ultima venta fue de: $"+vendido.fin.getElemento().getTotal()+" \n");
//            bw.write("La primer venta fue de: $"+vendido.frenteCola().getTotal()+" \n");
//            bw.close();
//            Desktop dt= Desktop.getDesktop();
//            dt.open(file);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//    public void cerrarConexion()
//    {
//        try{
//        cn.close();
//        }catch(SQLException e)
//        {
//            e.printStackTrace();
//        }
//    }
    public boolean insertarVentas(ColaVentas vendido){
        ColaVentas aux = null ;
        aux  = vendido;
        boolean resultado = false;
        do{
            try {
                //1. Conexión con la base de datos
                Statement st;
                Class.forName("com.mysql.cj.jdbc.Driver");
                //2. Definición de la instrucción
                st = cn.createStatement();
                String tsql = "INSERT INTO Ventas values ('"+aux.getFrente().getElemento().getProducto()+"',"+aux.getFrente().getElemento().getCantidad()+","+aux.getFrente().getElemento().getTotal()+
                            ",'"+aux.getFrente().getElemento().getCodigo()+"');";
                //3. Ejecución de la instrucción
                resultado = st.execute(tsql);
                //4. Cierre de la conexión
                cn.close();
                resultado = true;
                aux.quitar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar "+e);
                resultado = false;
            }
        }while(!aux.colaVacia());
        return resultado;
    }
//    
//    public boolean restarExistencia(String producto, String cantidad){
//        boolean bandera = false;
//        //Obtener cantidad existente
//        String existente = "";
//        Almacen auxiliar = new Almacen();
//        ResultSet tabla = auxiliar.consultaPersonal(producto);
//        if (tabla != null) {
//            try {
//            while (tabla.next()) {
//                existente=(tabla.getString("Cantidad"));
//            }
//            tabla.close();
//            auxiliar.cerrarConexion();
//            } catch(Exception e){
//                JOptionPane.showMessageDialog(null, "Error "+e);
//            }
//        }
//        //Restar cantidad
//        int cantidadExistente = 0;
//        int cantidadRestar = 0;
//        cantidadExistente = Integer.parseInt(existente);
//        cantidadRestar = Integer.parseInt(cantidad);
//        int total = cantidadExistente - cantidadRestar;
//        //Restar cantidad
//        int accion = 0;
//        try {
//            //1. Conexión con la base de datos
//            Statement st;
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);;
//            //2. Definición de la instrucción
//            st = cn.createStatement();
//            String tsql = "UPDATE Almacen SET Cantidad =" + total + 
//                    " WHERE Nombre = '"+ producto +"';";
//            //3. Ejecución de la instrucción
//            accion = st.executeUpdate(tsql);
//            bandera = true;
//            //4. Cierre de la conexión
//            cn.close();
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, "Error al modificar desde ventas "+e);
//        }
//        return bandera;
//    }
//    
//    public ResultSet consultar(){
//        ResultSet resultado = null;
//        try {           
//            Statement st;
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            cn = DriverManager.getConnection("jdbc:mysql://localhost/"+Conexion.nombreBD+"?serverTimezone=UTC", Conexion.usuario, Conexion.clave);
//            //2. Definición de la instrucción
//            st = cn.createStatement();
//            String tsql = "SELECT * FROM Ventas;";
//            //3. Ejecución de la instrucción
//            resultado = st.executeQuery(tsql);
//            //4. Cierre de la conexión
//            //cn.close(); 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return resultado;
   //}
    
}
