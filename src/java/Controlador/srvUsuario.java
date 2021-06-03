/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAOUSUARIO;
import Modelo.Producto;
import Modelo.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "srvUsuario", urlPatterns = {"/srvUsuario"})
public class srvUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "verificar":
                        verificar(request, response);
                        break;
                    case "cerrar":
                        cerrarsession(request, response);
                    case "listarUsuarios":
                        listarUsuarios(request, response);
                        break;
                    case "listarProductos":
                        listarProductos(request, response);
                        break;
                    default:
                        response.sendRedirect("Identificar.jsp");

                }
            } else {
                response.sendRedirect("Identificar.jsp");
            }

        } catch (Exception e) {

            try {
                this.getServletConfig().getServletContext().getRequestDispatcher("/mensaje").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Error" + e.getMessage());
            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion;
        DAOUSUARIO dao;
        usuario usuario;
        usuario = this.obtenerUsuario(request);//aqui tienes la contraseña y el nombreUsuario.

        dao = new DAOUSUARIO();//solo la instanci a de un objeto

        usuario = dao.identificar(usuario);//este es el procedimiento almacenado en si. que se guarda en ese nuevo usuario

        if (usuario != null && usuario.getCargo().getNombreCargo().equals("ADMINISTRADOR")) {

            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            request.setAttribute("msje", "Bienvenido al sistema");
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/index.jsp").forward(request, response);

        } else if (usuario != null && usuario.getCargo().getNombreCargo().equals("VENDEDOR")) {

            sesion = request.getSession();
            sesion.setAttribute("vendedor", usuario);
            this.getServletConfig().getServletContext().getRequestDispatcher("/Vistas/Trabajador.jsp").forward(request, response);
        } else {
            request.setAttribute("msje", " Credenciales Incorrectas");
            request.getRequestDispatcher("Identificar.jsp").forward(request, response);
        }

    }

    private void cerrarsession(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        response.sendRedirect("Identificar.jsp");
    }

    private usuario obtenerUsuario(HttpServletRequest request) {
        usuario u = new usuario();
        u.setNombreUsuario(request.getParameter("txtUsu"));
        u.setClave(request.getParameter("txtPass"));
        return u;

    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) {
    
        DAOUSUARIO dao = new DAOUSUARIO();
        List<usuario> usus = null;
        
        try {
            usus = dao.listarUsuarios();
            request.setAttribute("usuarios",usus);
        } catch (Exception e) {
            
            request.setAttribute("msje","No se pudo listar los usuarios"+e.getMessage());
        }
        finally{
            dao=null;
        }
        try {
            this.getServletConfig().getServletContext()
                      .getRequestDispatcher("/Vistas/usuarios.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se pudo realizar la peticion"+ex.getMessage());
        }
        
        
        
        
        
    }
    
    
    
    private void listarProductos(HttpServletRequest request, HttpServletResponse response) {
    
        DAOUSUARIO dao = new DAOUSUARIO();
        List<Producto> produ = null;
        
        try {
            produ = dao.listarProductos();
            request.setAttribute("Productos",produ);
        } catch (Exception e) {
            
            request.setAttribute("msje","No se pudo listar los Productos"+e.getMessage());
        }
        finally{
            dao=null;
        }
        try {
            this.getServletConfig().getServletContext()
                      .getRequestDispatcher("/Vistas/productos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se pudo realizar la peticion"+ex.getMessage());
        }
        
        
        
        
        
    }
    
    

}
