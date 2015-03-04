<%@page import="pe.com.upccompany.util.SystemUtil"%>
<%@page import="java.util.List"%>
<%@page import="pe.com.upccompany.dao.entity.Empleado"%>
<%@page import="pe.com.upccompany.web.util.WebUtil"%>
<%@page import="pe.com.upccompany.service.EmpleadoService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EmpleadoService empleadoService = (EmpleadoService) WebUtil.obtenerService("EMPLEADO");
    List<Empleado> listaEmpleados = null;
    String mensaje = SystemUtil.validaNulo(request.getParameter("mensaje"));
    try {
        listaEmpleados = empleadoService.listar();
    } catch (Exception ex) {
        mensaje = WebUtil.controlarError(ex);
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../Resources/templates/metaData.jsp" %>
        <title>UpcCompany - Mnt Empleados</title>
        <script type="text/javascript">
            $(document).ready(function ()
            {
                $('#empleados-nav').addClass('active');
            });
        </script>
    </head>
    <body>
        <header>
            <%@include file="../../Resources/templates/header.jsp" %>
        </header>
        <div class="container">
            <%@include file="../../Resources/templates/mensaje.jsp" %>
            <div class="row">
                <div class="col-xs-12 col-md-1"></div>
                <div class="col-xs-12 col-md-10">
                    <div class="row">
                        <h2 class="text-center">Lista de Empleados</h2>
                    </div>
                    <div class="row">
                        <h4 class="text-center">Resultados</h4>
                        <br/>
                        <div id="toolbar" class="btn-group">
                            <%String rReg = request.getContextPath() + "/Pages/Empleado/regEmpleado.jsp";
                            %>
                            <a id="btnRegEmp" href="<%= rReg%>" class="btn btn-default">Registrar empleado</a>
                        </div>
                        <table id="tabla" data-toggle="table" 
                               class="table table-hover table-striped table-responsive"
                               data-sort-name="ID"
                               data-sort-order="asc"
                               data-search="true"
                               data-pagination="true"
                               data-show-toggle="true"
                               data-show-columns="true"
                               data-toolbar="#toolbar">
                            <thead>
                                <tr>
                                    <th data-field="ID"
                                        data-sortable="true">
                                        ID
                                    </th>
                                    <th data-sortable="true">
                                        DNI
                                    </th>
                                    <th data-sortable="true">
                                        Nombre
                                    </th>               
                                    <th data-sortable="true">
                                        Apellido
                                    </th>                     
                                    <th data-sortable="true">
                                        Sexo
                                    </th>                
                                    <th data-sortable="true">
                                        Departamento
                                    </th>
                                    <th data-sortable="true">
                                        Idiomas
                                    </th> 
                                    <th>
                                        <span class="glyphicon glyphicon-cog"></span>
                                    </th>
                                    <th>
                                        <span class="glyphicon glyphicon-trash"></span>
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <% if (listaEmpleados != null) {
                                        for (Empleado e : listaEmpleados) {
                                %>
                                <tr>
                                    <td><%= e.getIdEmpleado()%></td>
                                    <td><%= e.getDni()%></td>
                                    <td><%= e.getNombre()%></td>
                                    <td><%= e.getApellido()%></td>
                                    <td><%= e.getSexo()%></td>
                                    <%
                                        if (e.getIdDepartamento().getEliminado() == true) {
                                    %>
                                    <td class="text-danger" >
                                        <%= e.getIdDepartamento().getNombre()%>
                                    </td> 
                                    <%
                                    } else {
                                    %>
                                    <td><%= e.getIdDepartamento().getNombre()%></td>
                                    <%
                                        }
                                    %>
                                    <td><%= WebUtil.encadenaIdiomas(e.getIdiomaList())%></td>
                                    <%
                                        String rAct = request.getContextPath() + "/Pages/Empleado/actEmpleado.jsp";
                                        rAct += "?id=" + e.getIdEmpleado();
                                        String rEli = request.getContextPath() + "/EmpleadoController";
                                        rEli += "?id=" + e.getIdEmpleado() + "&txtAction=ELIMINAR";
                                    %>
                                    <td><a  id="btnActEmp<%= e.getIdEmpleado()%>" href="<%= rAct%>" class="btn btn-primary btn-xs">Modificar</a></td>
                                    <td><a  id="btnEliDep<%= e.getIdEmpleado()%>" href="<%= rEli%>" class="btn btn-danger btn-xs">Eliminar</a></td>
                                </tr>
                                <%
                                        }
                                    }
                                %>
                            </tbody>
                        </table>
                    </div> 
                </div>
                <div class="col-xs-12 col-md-1"></div>
            </div>
        </div>
    </body>
</html>