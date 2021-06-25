package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOCONCEPTO extends Conexion2 {

        public List<concepto> listarconcepto() throws Exception {
        List<concepto> conceptoo;
        concepto con;
        ResultSet rs = null;
        String sql = "select idConcepto, descripcion from concepto;";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            conceptoo = new ArrayList<>();
            while (rs.next() == true) {
                con = new concepto();
                con.setIdConcepto(rs.getInt("idConcepto"));
                con.setDescripcion(rs.getString("descripcion"));
                conceptoo.add(con);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return conceptoo;
    }
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

