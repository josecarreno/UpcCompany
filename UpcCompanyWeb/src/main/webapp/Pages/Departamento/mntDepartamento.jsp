
<%@page import="pe.com.upccompany.util.SystemUtil"%>
<%@page import="pe.com.upccompany.dao.entity.Departamento"%>
<%@page import="java.util.List"%>
<%@page import="pe.com.upccompany.web.util.WebUtil"%>
<%@page import="pe.com.upccompany.service.DepartamentoService"%>
<%-- 
    Document   : mntDepartamento
    Created on : Feb 6, 2015, 3:58:14 PM
    Author     : Renato
--%>
<%
    DepartamentoService departamentoService = (DepartamentoService) WebUtil.obtenerService("DEPARTAMENTO");
    List<Departamento> listaDepartamentos = null;
    String mensaje = SystemUtil.validaNulo(request.getParameter("mensaje"));
    try {
        listaDepartamentos = departamentoService.listar();
    } catch (Exception ex) {
        mensaje = WebUtil.controlarError(ex);
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../Resources/templates/metaData.jsp" %>
        <title>UpcCompany - Mnt Departamentos</title>
        <script type="text/javascript">
            $(document).ready(function ()
            {
                $('#departamentos-nav').addClass('active');
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
                <div class="col-xs-12 col-md-3"></div>
                <div class="col-xs-12 col-md-6">
                    <div class="row">
                        <h2 class="text-center">Lista de Departamentos</h2>
                    </div>
                    <div class="row">
                        <h4 class="text-center">Resultados</h4>
                        <br/>
                        <div id="toolbar" class="btn-group">
                            <%String rReg = request.getContextPath() + "/Pages/Departamento/regDepartamento.jsp";
                            %>
                            <a id="btnRegDep" href="<%= rReg%>" class="btn btn-default pull-right">Registrar departamento</a>
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
                                        Departamento
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
                                <% if (listaDepartamentos != null) {
                                        for (Departamento d : listaDepartamentos) {
                                %>
                                <tr>
                                    <td><%= d.getIdDepartamento()%></td>
                                    <td><%= d.getNombre()%></td>

                                    <%
                                        String rAct = request.getContextPath() + "/Pages/Departamento/actDepartamento.jsp";
                                        rAct += "?id=" + d.getIdDepartamento();
                                        String rEli = request.getContextPath() + "/DepartamentoController";
                                        rEli += "?id=" + d.getIdDepartamento() + "&txtAction=ELIMINAR";
                                    %>
                                    <td><a  id="btnActDep<%= d.getIdDepartamento()%>" href="<%= rAct%>" class="btn btn-primary btn-xs">Modificar</a></td>
                                    <td><a  id="btnEliDep<%= d.getIdDepartamento()%>" href="<%= rEli%>" class="btn btn-danger btn-xs">Eliminar</a></td>
                                </tr>
                                <%
                                        }
                                    }
                                %>
                            </tbody>
                        </table>
                    </div> 
                </div>
                <div class="col-xs-12 col-md-3"></div>
            </div>
        </div>
    </body>
</html>