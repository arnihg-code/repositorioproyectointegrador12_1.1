
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
    
    private static String DRIVER ="com.mysql.jdbc.Driver";
    private static String USUARIO ="root";
    private static String PASSWORD ="mysql";
    private final String URL ="jdbc:mysql://localhost:3306/bdsys";
    
  
    
    
    
    public Connection getConnection(){
    
     Connection cn = null;
    try{
    
    Class.forName(DRIVER);
    cn = DriverManager.getConnection(URL,USUARIO,PASSWORD);
        System.out.println("Conexion exitosa");
    }
    catch(Exception e){
        System.out.println("Error al conectar"+e.getMessage());
    }
    
    return cn;
    
    }
    

    
        
   
    
    
    }
    
    
    
   
    
    
    

