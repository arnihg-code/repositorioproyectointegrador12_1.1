/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAOCARGO;
import Modelo.DAOUSUARIO;
import Modelo.DAOVALEDEINGRESO;
import Modelo.DAOVALESALIDA;
import Modelo.Producto;
import Modelo.cargo;
import Modelo.usuario;
import Modelo.valeIngreso;
import Modelo.ValeSalida;
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

                    case "registrar":
                        registrarUsuario(request, response);
                        break;

                    case "listarProductos":
                        listarProductos(request, response);
                        break;
                    case "listarValeIngreso":
                        listarValeIngreso(request, response);
                        break;
                    case "nuevo":
                        presentarFormulario(request, response);
                        break;

                    case "leerUsuario":
                        presentarUsuario(request, response);
                        break;

                    case "actualizarUsuario":
                        actualizarUsuario(request, response);
                        break;
                    case "eliminarUsuario":
                        eliminarUsuario(request, response);
                        break;
                    case "listarValeSalida":
                        listarValeSalida(request, response);
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
            request.setAttribute("usuarios", usus);
        } catch (Exception e) {

            request.setAttribute("msje", "No se pudo listar los usuarios" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/Vistas/usuarios.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se pudo realizar la peticion" + ex.getMessage());
        }

    }

    private void listarProductos(HttpServletRequest request, HttpServletResponse response) {

        DAOUSUARIO dao = new DAOUSUARIO();
        List<Producto> produ = null;

        try {
            produ = dao.listarProductos();
            request.setAttribute("Productos", produ);
        } catch (Exception e) {

            request.setAttribute("msje", "No se pudo listar los Productos" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/Vistas/productos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se pudo realizar la peticion" + ex.getMessage());
        }

    }

    /*
    private void mostrarValeingreso(HttpServletRequest request, HttpServletResponse response){
        
           try {
            this.getServletConfig().getServletContext()
                      .getRequestDispatcher("/Vistas/ValedeIngreso.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "No se pudo realizar la peticion"+ex.getMessage());
        }
        
        
        
        
    }
     */
    private void listarValeIngreso(HttpServletRequest request, HttpServletResponse response) {
        DAOVALEDEINGRESO dao = new DAOVALEDEINGRESO();
        List<valeIngreso> vale1 = null;
        try {
            vale1 = dao.listarValeIngreso();
            request.setAttribute("valesdeingreso", vale1);

        } catch (Exception ex) {

            request.setAttribute("msje", "No se listo los vales de ingreso" + ex.getMessage());

        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/Vistas/ValedeIngreso.jsp").forward(request, response);;

        } catch (Exception x) {
            request.setAttribute("msj", "no se relizo la peticion" + x.getMessage());
        }

    }

    private void presentarFormulario(HttpServletRequest request, HttpServletResponse response) {

        try {
            this.cargarCargos(request);
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/Vistas/nuevoUsuario.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar la vista");
        }

    }

    private void cargarCargos(HttpServletRequest request) {
        DAOCARGO dao = new DAOCARGO();
        List<cargo> car = null;
        try {
            car = dao.listarCargos();
            request.setAttribute("cargos", car);//en esta parte del codigo quiere decir lo de car es ahora cargos y ese cargos lo encontraras en la parte del servlet
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los cargos :( " + e.getMessage());
        } finally {
            car = null;
            dao = null;
        }
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) {

        DAOUSUARIO daoUsu;
        usuario usu = null;
        cargo carg;
        if (request.getParameter("txtNombre") != null
                && request.getParameter("txtClave") != null
                && request.getParameter("cboCargo") != null) {

            usu = new usuario();
            usu.setNombreUsuario(request.getParameter("txtNombre"));
            usu.setClave(request.getParameter("txtClave"));
            carg = new cargo();
            carg.setCodigo(Integer.parseInt(request.getParameter("cboCargo")));
            usu.setCargo(carg);
            if (request.getParameter("chkEstado") != null) {
                usu.setEstado(true);
            } else {
                usu.setEstado(false);
            }
            daoUsu = new DAOUSUARIO();
            try {
                daoUsu.registrarUsuarios(usu);
                response.sendRedirect("srvUsuario?accion=listarUsuarios");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el usuario" + e.getMessage());
                request.setAttribute("usuario", usu);
                this.presentarFormulario(request, response);
            }
        }

    }

    private void presentarUsuario(HttpServletRequest request, HttpServletResponse response) {
        DAOUSUARIO dao;
        usuario usus;
        if (request.getParameter("cod") != null) {
            usus = new usuario();
            usus.setId_usuario(Integer.parseInt(request.getParameter("cod")));

            dao = new DAOUSUARIO();
            try {
                usus = dao.leerUsuario(usus);
                if (usus != null) {
                    request.setAttribute("usuario", usus);
                } else {
                    request.setAttribute("msje", "No se encontró el usuario");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se tiene el parámetro necesario");
        }
        try {
            this.cargarCargos(request);
            this.getServletConfig().getServletContext().
                    getRequestDispatcher("/Vistas/actualizarUsuario.jsp"
                    ).forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la operacion" + e.getMessage());
        }
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) {

        DAOUSUARIO daoUsu;
        usuario usus = null;
        cargo car;

        if (request.getParameter("hCodigo") != null
                && request.getParameter("txtNombre") != null
                && request.getParameter("txtClave") != null
                && request.getParameter("cboCargo") != null) {

            usus = new usuario();
            usus.setId_usuario(Integer.parseInt(request.getParameter("hCodigo")));
            usus.setNombreUsuario(request.getParameter("txtNombre"));
            usus.setClave(request.getParameter("txtClave"));
            car = new cargo();
            car.setCodigo(Integer.parseInt(request.getParameter("cboCargo")));
            usus.setCargo(car);
            if (request.getParameter("chkEstado") != null) {
                usus.setEstado(true);
            } else {
                usus.setEstado(false);
            }
            daoUsu = new DAOUSUARIO();
            try {
                daoUsu.actualizarUsuarios(usus);
                response.sendRedirect("srvUsuario?accion=listarUsuarios");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo actualizar el usuario" + e.getMessage());
                request.setAttribute("usuario", usus);

            }
            try {
                this.cargarCargos(request);
                this.getServletConfig().getServletContext().
                        getRequestDispatcher("/Vistas/actualizarUsuario.jsp"
                        ).forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());
            }
        }

    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) {
         DAOUSUARIO dao = new DAOUSUARIO();
        usuario usus = new usuario();
        if (request.getParameter("cod")!=null){
            usus.setId_usuario(Integer.parseInt(request.getParameter("cod")));
            try{
                dao.eliminarUsuario(usus);
                response.sendRedirect("srvUsuario?accion=listarUsuarios");
            }catch(Exception e){
                request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
            }
        }else{
            request.setAttribute("msje", "No se encontro el usuario");
        }
        
        
    }

    private void listarValeSalida(HttpServletRequest request, HttpServletResponse response) {
        
        
        DAOVALESALIDA dao = new DAOVALESALIDA();
        List<ValeSalida> vale1 = null;
        try {
            vale1 = dao.listarValedeSalida();
            request.setAttribute("valesdesalidaa", vale1);

        } catch (Exception ex) {

            request.setAttribute("msje", "No se listo los vales de salida" + ex.getMessage());

        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/Vistas/ValedeSalida.jsp").forward(request, response);

        } catch (Exception x) {
            request.setAttribute("msj", "no se relizo la peticion" + x.getMessage());
        }
        
        
        
        
        
    }

}
