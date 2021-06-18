/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SUITE
 */
public class DAOVALESALIDA {
    
    
    
    public List<ValeSalida> listarValedeSalida() throws Exception {

        Conexion con;
        Connection cn;
        Statement st = null;

        List<ValeSalida> valeSalidaa;
        ValeSalida vale;
        ResultSet rs = null;
        String sql = "select * from ValeSalida;";

        con = new Conexion();
        try {

            
            
            cn = con.getConnection();
            st = cn.createStatement();

            //this.conectar(false);
            rs = st.executeQuery(sql);
            // rs = this.ejecutarOrdenDatos(sql);
            valeSalidaa = new ArrayList<>();
            while (rs.next() == true) {
                
                vale = new ValeSalida();
                vale.setIdValeSalida(rs.getInt("idValeSalida"));
                vale.setIdConcepto(rs.getInt("idConcepto"));
                vale.setIdProveedores(rs.getInt("idProveedores"));
                vale.setIdDetalleValeSalida(rs.getInt("idDetalleValeSalida"));
                vale.setObservacion(rs.getString("observacion"));
                vale.setFecha(rs.getString("fecha"));
                valeSalidaa.add(vale);
                          
                 
                
            }

            cn.close();

            //this.cerrar(true);
            
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return valeSalidaa;

    }

    
    
    
    
    
    
}
