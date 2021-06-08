package Modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOUSUARIO extends Conexion {

    public usuario identificar(usuario user) throws Exception {
//comentario
        usuario usu = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT U.IDUSUARIO, C.NOMBRECARGO FROM usuario U"
                + " INNER JOIN cargo C ON U.IDCARGO = C.IDCARGO\n"
                + "WHERE U.ESTADO =1 AND U.NOMBREUSUARIO = '" + user.getNombreUsuario() + "'"
                + " AND U.CLAVE ='" + user.getClave() + "'";

        con = new Conexion();
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next() == true) {
                usu = new usuario();
                usu.setId_usuario(rs.getInt("IDUSUARIO"));
                usu.setNombreUsuario(user.getNombreUsuario());
                usu.setCargo(new cargo());
                usu.getCargo().setNombreCargo(rs.getString("NOMBRECARGO"));
                usu.setEstado(true);

            }

        } catch (Exception e) {

            System.out.println("Error" + e.getMessage());

        } finally {
            if (rs != null && rs.isClosed() == false) {
                rs.close();

            }
            rs = null;
            if (st != null && st.isClosed() == false) {
                st.close();

            }

            st = null;
            if (cn != null && cn.isClosed() == false) {
                cn.close();

            }
            cn = null;

        }
        return usu;

    }

    public List<usuario> listarUsuarios() throws Exception {

        Conexion con;
        Connection cn;
        Statement st = null;

        List<usuario> usuarios;
        usuario usu;
        ResultSet rs = null;
        String sql = "SELECT U.IDUSUARIO, U.NOMBREUSUARIO, U.CLAVE, U.ESTADO, C.NOMBRECARGO \n"
                + "FROM usuario U INNER JOIN cargo C \n"
                + "ON C.IDCARGO = U.IDCARGO \n"
                + "ORDER BY U.IDUSUARIO";

        con = new Conexion();
        try {

            cn = con.getConnection();
            st = cn.createStatement();

            //this.conectar(false);
            rs = st.executeQuery(sql);
            // rs = this.ejecutarOrdenDatos(sql);
            usuarios = new ArrayList<>();
            while (rs.next() == true) {
                usu = new usuario();
                usu.setId_usuario(rs.getInt("IDUSUARIO"));
                usu.setNombreUsuario(rs.getString("NOMBREUSUARIO"));
                //usu.setClave(rs.getString("CLAVE"));
                usu.setEstado(rs.getBoolean("ESTADO"));
                usu.setCargo(new cargo());
                usu.getCargo().setNombreCargo(rs.getString("NOMBRECARGO"));
                usuarios.add(usu);
            }

            cn.close();

            //this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return usuarios;

    }

    public List<Producto> listarProductos() throws Exception {

        Conexion con;
        Connection cn;
        Statement st = null;

        List<Producto> producto;
        Producto pro;
        ResultSet rs = null;
        String sql = "select idProducto, idCategoria,desProducto,stockProducto,precioProducto from \n" +
                      "Producto ";

        con = new Conexion();
        try {

            cn = con.getConnection();
            st = cn.createStatement();

            //this.conectar(false);
            rs = st.executeQuery(sql);
            // rs = this.ejecutarOrdenDatos(sql);
            producto = new ArrayList<>();
            while (rs.next() == true) {
                pro = new Producto();
                pro.setIdProducto(rs.getInt("idProducto"));
                pro.setIdCategoria(rs.getInt("idCategoria"));
                //usu.setClave(rs.getString("CLAVE"));

                //pro.setProveedor(new Proveedores());
               // pro.getProveedor().setIdProveedores(rs.getInt(idProveedores));
                pro.setDesProducto(rs.getString("desProducto"));
                pro.setStockProducto(rs.getInt("stockProducto"));
                pro.setPrecioProducto(rs.getDouble("precioProducto"));
                producto.add(pro);
            }

            cn.close();

            //this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return producto;

    }

}
