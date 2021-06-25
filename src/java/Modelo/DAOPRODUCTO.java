/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SUITE
 */
public class DAOPRODUCTO  extends Conexion2 {
    
    
    
        public List<Producto> listarproducto() throws Exception {
        List<Producto> producto;
        Producto product;
        ResultSet rs = null;
        String sql = "select idProducto, desProducto from producto";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            producto = new ArrayList<>();
            while (rs.next() == true) {
                product = new Producto();
                product.setIdProducto(rs.getInt("idProducto"));
                product.setDesProducto(rs.getString("desProducto"));
                producto.add(product);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return producto;
    }
    
    
    
    
    
    
    
    
}
