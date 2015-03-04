<%-- 
    Document   : regDepartamento
    Created on : Feb 6, 2015, 3:58:53 PM
    Author     : Renato
--%>
<%@page import="pe.com.upccompany.dao.entity.Departamento"%>
<%@page import="pe.com.upccompany.web.util.WebUtil"%>
<%@page import="pe.com.upccompany.service.DepartamentoService"%>
<%@page import="pe.com.upccompany.util.SystemUtil"%>
<%
    String mensaje = SystemUtil.validaNulo(request.getParameter("mensaje"));
    DepartamentoService departamentoService = (DepartamentoService) WebUtil.obtenerService("DEPARTAMENTO");
    Departamento d = null;
    try {
        d = departamentoService.obtener(Integer.parseInt(request.getParameter("id")));
    } catch (Exception e) {
        mensaje = WebUtil.controlarError(e);
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../Resources/templates/metaData.jsp" %>
        <script type="text/javascript">
            $(document).ready(function ()
            {
                $('#departamentos-nav').addClass('active');
            });
        </script>
        <title>UpcCompany - Act Departamento</title>
    </head>
    <body>
        <header>
            <%@include file="../../Resources/templates/header.jsp" %>
        </header>
        <div class="container">  
            <div class="col-xs-2 col-md-3"></div>
            <div class="col-xs-8 col-md-6">
                <form id="formDepartamento" class="form-horizontal" method="post" action="<%= request.getContextPath()%>/DepartamentoController">
                    <fieldset>
                        <legend>Actualizar departamento</legend>
                        <div class="form-group">
                            <label for="txtId" class="col-sm-3 control-label">ID:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="txtId" name="txtId"
                                       value="<%= d.getIdDepartamento()%>" readonly="">
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="txtNombre" class="col-sm-3 control-label">Nombre:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="txtNombre" name="txtNombre" placeholder="Ingrese el nombre"
                                       value="<%= d.getNombre()%>">
                            </div>
                        </div>  
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <a id="btnCancelar" name="btnCancelar" class="btn btn-danger btn-w-top-margin" 
                                   href="<%= request.getContextPath()%>/Pages/Departamento/mntDepartamento.jsp">
                                    Cancelar
                                </a>
                                <input id="btnActualizar" type="submit" class="btn btn-success btn-w-top-margin" value="Actualizar"/>
                            </div>
                        </div>
                        <input type="hidden" name="txtAction" value="ACTUALIZAR"/>
                    </fieldset>
                </form>
            </div>
            <div class="col-xs-2 col-md-3"></div>
        </div>
    </body>
</html>
