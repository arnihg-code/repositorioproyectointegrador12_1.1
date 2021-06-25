package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOPROVEEDORES extends Conexion2 {

    public List<Proveedores> listarproveedores() throws Exception {
        List<Proveedores> proveedores;
        Proveedores prov;
        ResultSet rs = null;
        String sql = "select idProveedores, nombreProveedor from proveedores";

        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            proveedores = new ArrayList<>();
            while (rs.next() == true) {
                prov = new Proveedores();
                prov.setIdProveedores(rs.getInt("idProveedores"));
                prov.setNombreProveedor(rs.getString("nombreProveedor"));
                proveedores.add(prov);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return proveedores;
    }

    
    
    
    
    
    
    
    
    
    
}
