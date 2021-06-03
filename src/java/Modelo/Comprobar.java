
package Modelo;
import java.sql.Connection;

import java.sql.DriverManager;

public class Comprobar {
    
   public static void main(String[] args){
   
       connect();
  
       
       /**Conexion c = new Conexion();
   
   if(c.getConnection()!=null){
   System.out.println("conexion es correcta");
   
   }else
   {
  System.out.println("conexion erronea");
   
   }**/
   
   

  
   }
    
   
   public static void connect(){
   
       Connection con = null;
                 String driver ="com.mysql.jdbc.Driver";
              
                 
                 try{
                     Class.forName(driver);
                     System.out.println("driver exitosa");
                     
                     try {
                          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdsys","root","mysql");
                        if(con!=null)
                       System.out.println("Conexion exitosa");
                         
                     } catch (Exception e) {
                          System.out.println("Ha ocurrido un errro al intertar conectar con la besade de datos"+e.getMessage());
                     }
                     
                     
        
               }catch(Exception e){
                System.out.println("ha ocurrido un error al caragr el driver"+e.getMessage());
               
               }
       
       
   
   
   }
   
   //  private static String DRIVER ="com.mysql.jdbc.Driver";
    //private static String USUARIO ="root";
   // private static String PASSWORD ="mysql";
    //private final String URL ="jdbc:mysql://localhost:3306/bdsys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    
       
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    
}
