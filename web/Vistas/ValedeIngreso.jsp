



<%--esta sera la vista del administrador--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Conexion" %>
<%@page import="Modelo.DAOUSUARIO" %>
<%@page import="Modelo.Producto" %>
<%@page import="Modelo.Proveedores" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--Ahora verificamos la sesion--%>
<%
    if (session.getAttribute("usuario") != null) {
%>



<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Sistema Bodega| Inicio</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>

        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
              page. However, you can choose any other skin. Make sure you
              apply the skin class to the body tag so the changes take effect. -->
        <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>

    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <!-- Main Header -->
            <header class="main-header">
                <a href="#" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>S</b>BL</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Sistema </b>Inventario</span>
                </a>

                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- User Account Menu -->
                            <li class="dropdown user user-menu">
                                <!-- Menu Toggle Button -->
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <!-- The user image in the navbar-->
                                    <img src="dist/img/avatar.png" class="user-image" alt="User Image">
                                    <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                    <span class="hidden-xs"> ${usuario.nombreUsuario}</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- The user image in the menu -->
                                    <li class="user-header">
                                        <img src="dist/img/avatar.png" class="img-circle" alt="User Image">

                                        <p>                    
                                            Bienvenido - ${vendedor.nombreUsuario}
                                            <small>Usted es, ${usuario.cargo.nombreCargo} </small>
                                        </p>
                                    </li>
                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                        <div class="pull-right">
                                            <a href="srvUsuario?accion=cerrar" class="btn btn-default btn-flat">Cerrar Session</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">

                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">

                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <!-- <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">-->

                            <br><br>
                        </div>
                        <div class="pull-left info">
                            <p>Bienvenido,${usuario.nombreUsuario} </p>
                            <!-- Status -->
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>

                    <!-- search form (Optional) -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->

                    <!-- Sidebar Menu -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">INICIO</li>
                        <!-- Optionally, you can add icons to the links -->
                        <li ><a href="#"><i class="fa fa-link"></i> <span>Panel Administrativo</span></a></li>
                        <li class="treeview active">
                            <a href="#"><i class="glyphicon glyphicon-th-large"></i> <span>Registros</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#"><i class="fa fa-archive"></i>Categorias</a></li>
                                <li><a href="#"><i class="fa fa-tags"></i>Marcas</a></li>
                                <li><a href="#"><i class="fa fa-cube"></i>Productos</a></li>
                                <li><a href="#"><i class="fa fa-users"></i>Clientes</a></li>
                                <li><a href="#"><i class="fa fa-truck"></i>Proveedores</a></li>
                                <li><a href=""><i class="fa fa-user-plus"></i>Empleados</a></li>
                                <li><a href="srvUsuario?accion=listarUsuarios"><i class="fa fa-address-card"></i>Usuarios</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-cart-arrow-down"></i> <span>Mantenimientos</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href=""><i class="fa fa-cart-arrow-down"></i>Nueva Venta</a></li>
                                <li><a href=""><i class="fa fa-tags"></i>Administrar Ventas</a></li>
                                <li class="active"><a href="srvUsuario?accion=listarValeIngreso"><i class="fa fa-address-card"></i>Vale de ingreso</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-area-chart"></i> <span>Reportes</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#"><i class="fa fa-bar-chart"></i>Reportes Ventas</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- /.sidebar-menu -->
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>Página Vale de Ingreso</h1>
                </section>
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <a href="" class="btn btn-success">
                        <i class="fa fa-plus"></i> Nuevo </a>

                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li class="active">Vales de Ingreso</li>
                    </ol>
                </section>

                <section class="content">
                    <div class="box">    
                        <div class="box-header with-border">             
                            <h3 class="box-title">Listado de Vales de Ingreso</h3>
                        </div>
                        <div class="box-body">
                            <div class="table-responsive" >                                 
                                <table class="table table-bordered table-striped dataTable table-hover" id="tablaValeIngreso" class="display">
                                    <thead>
                                        <tr>
                                            <th>Codigo Vale Ingreso</th>
                                            <th>Concepto</th>
                                            <th>Proveedores</th>
                                            <th>Detalle de Vale</th>
                                            <th>Observacion</th>
                                            <th>Fecha</th> 
                                           
                                        </tr>
                                    </thead>
                                    <c:forEach var="user" items="${valesdeingreso}" varStatus="iteracion">  <!--ese usaurio viene de el listado usuario en tu servlet-->                                                  
                                        <tr>
                                            <!--el nombre de ese nombreUsuario es igual a los atributos de la clase-->
                                            <td>${user.idValeIngreso}</td>
                                            <td>${user.idConcepto}</td>
                                            <td>${user.idProveedores}</td>
                                            <td>${user.idDetalleVaIngreso}</td>
                                            <td>${user.observacion}</td>
                                            <td>${user.fecha}</td>
                                         
                                            
                                        </tr>                                                    
                                    </c:forEach>                                               
                                </table>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <!--Pie de página-->
                        </div>
                        <!-- /.box-footer-->
                    </div>
                </section>
                <!-- /.content -->
            </div>





            <!-- /.content-wrapper -->
            <!-- /.content-wrapper -->

            <!-- Main Footer -->



            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED JS SCRIPTS -->

        <!-- jQuery 3 -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.min.js"></script>

        <!-- Optionally, you can add Slimscroll and FastClick plugins.
             Both of these plugins are recommended to enhance the
             user experience. -->
    </body>
</html>

<%
    } else {

        response.sendRedirect("Identificar.jsp");
    }


%>
