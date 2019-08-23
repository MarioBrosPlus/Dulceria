/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulceria_53;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author Gera
 */
public final class Conexion {

    public DataSource dataSource;
    public String db = "Dulceria";
    public String url = "jdbc:postgresql://localhost/" + db;
    public String user = "postgres";
    public String pass = "12345";

    public Connection inicializa() {
        
        Connection c=null;
        try{
         Class.forName("org.postgresql.Driver");
         c=DriverManager.getConnection("jdbc:postgresql://172.16.0.19/dulceria_53","postgres","12345");
        }catch(Exception e){
            e.printStackTrace();
    }
        return c;
//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setDriverClassName("org.postgresql.Driver");
//        basicDataSource.setUsername(user);
//        basicDataSource.setPassword(pass);
//        basicDataSource.setUrl(url);
//        basicDataSource.setMaxActive(50);
//
//        dataSource= basicDataSource;
        
        
    }
}
