/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SMK GAMING
 */
public class Conexion {
    
     String url="jdbc:mysql://localhost/mydbLab";
    String root="root";
    String pass="";
    	
    public Connection conexion(){
        
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url,root,pass); 
            System.out.println(" conexion exitosa.");
        } catch (InstantiationException e) {
            System.out.println("Error instanciacion."+ e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Error acceso ilegal. "+ e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error class. "+ e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de sql. "+ e.getMessage());       
        } 

        return conn;
	}
    
}
