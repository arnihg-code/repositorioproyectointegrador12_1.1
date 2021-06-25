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
public class DAOVALESALIDA extends Conexion2{
    
    
    
    public List<ValeSalida> listarValedeSalida() throws Exception {

        Conexion con;
        Connection cn;
        Statement st = null;

        List<ValeSalida> valeSalidaa;
        ValeSalida vale;
        ResultSet rs = null;
        String sql = "select v.idValeSalida,c.descripcion, p.nombreProveedor, o.desProducto, " +
                     "v.observacion,v.fecha " +
                     " from ValeSalida v join concepto c " +
                     " on v.idConcepto = c.idConcepto " +
                     " join proveedores p on p.idProveedores = v.idProveedores " +
                     " join producto o on o.idProducto = v.idProducto ";

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
                vale.setConcepto(new concepto());
                vale.getConcepto().setDescripcion(rs.getString("descripcion"));
                vale.setNombresProveedor(new Proveedores());
                vale.getNombresProveedor().setNombreProveedor(rs.getString("nombreProveedor"));
                vale.setNomProducto(new Producto());
                vale.getNomProducto().setDesProducto(rs.getString("desProducto"));
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

    
    
    
    public void registrarvalesalida(ValeSalida valesalida) throws Exception{
    
        String sql;
        sql="INSERT INTO valesalida (idValeSalida,idConcepto,idProveedores,idProducto,observacion)" +
            "VALUES (" + valesalida.getIdValeSalida() + "," + valesalida.getConcepto().getIdConcepto() + "," 
                + valesalida.getNombresProveedor().getIdProveedores() + "," 
                + valesalida.getNomProducto().getIdProducto() + ",'" + valesalida.getObservacion() + "')" ;
        
        try
        {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
            
            
        }
        catch(Exception e)
        {
            this.cerrar(false);
            throw e;
        
        }
        
    
    }
    
    
    
    
}
