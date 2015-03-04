<%@page import="pe.com.upccompany.dao.entity.Idioma"%>
<%@page import="pe.com.upccompany.service.IdiomaService"%>
<%@page import="pe.com.upccompany.util.SystemUtil"%>
<%@page import="pe.com.upccompany.dao.entity.Departamento"%>
<%@page import="java.util.List"%>
<%@page import="pe.com.upccompany.web.util.WebUtil"%>
<%@page import="pe.com.upccompany.service.DepartamentoService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DepartamentoService departamentoService = (DepartamentoService) WebUtil.obtenerService("DEPARTAMENTO");
    IdiomaService idiomaService = (IdiomaService) WebUtil.obtenerService("Idioma");
    List<Departamento> listaDepartamentos = null;
    List<Idioma> listaIdiomas = null;
    String mensaje = SystemUtil.validaNulo(request.getParameter("mensaje"));
    try {
        listaDepartamentos = departamentoService.listar();
        listaIdiomas = idiomaService.listar();
    } catch (Exception e) {
        mensaje = WebUtil.controlarError(e);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../Resources/templates/metaData.jsp" %>
        <title>UpcCompany - Reg Empleado</title>
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
            <div class="col-xs-2 col-md-3"></div>
            <div class="col-xs-8 col-md-6">
                <form id="formEmpleado" class="form-horizontal" method="post" action="<%= request.getContextPath()%>/EmpleadoController">
                    <fieldset>
                        <legend>Registrar empleado</legend>
                        <div class="form-group">
                            <label for="txtDNI" class="col-sm-3 control-label">DNI:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="txtDNI" name="txtDNI" placeholder="Ingrese el DNI">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtNombre" class="col-sm-3 control-label">Nombre:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="txtNombre" name="txtNombre" placeholder="Ingrese el nombre">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtApellido" class="col-sm-3 control-label">Apellido:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="txtApellido" name="txtApellido" placeholder="Ingrese el apellido">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="radio" class="col-sm-3 control-label">Sexo:</label>
                            <div class="col-sm-9">
                                <label class="radio-inline">
                                    <input type="radio" name="rbSexo" id="rbSexoM" value="masculino" checked> masculino
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="rbSexo" id="rbSexoF" value="femenino"> femenino
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="selDepartamento" class="col-sm-3 control-label">Departamento:</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="selDepartamento" name="selDepartamento">
                                    <option value="default">Seleccione un departamento</option>
                                    <%
                                        for (Departamento d : listaDepartamentos) {

                                    %>
                                    <option value="<%= d.getIdDepartamento()%>"><%= d.getNombre()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="col-sm-3 control-label">Idiomas:</label>
                            <div class="checkbox col-sm-9">
                                <%
                                    for (Idioma i : listaIdiomas) {
                                %>
                                &nbsp;&nbsp;
                                <label>
                                    <input id="chk<%= i.getIdIdioma()%>" type="checkbox" name="idioma" value="<%= i.getIdIdioma()%>">
                                    <%= i.getNombre()%>
                                </label>
                                <%
                                    }
                                %>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <a id="btnCancelar" name="btnCancelar" class="btn btn-danger btn-w-top-margin" 
                                   href="<%= request.getContextPath()%>/Pages/Empleado/mntEmpleado.jsp">
                                    Cancelar
                                </a>
                                <input id="btnRegEmpleado" type="submit" class="btn btn-success btn-w-top-margin" value="Registrar"/>
                            </div>
                        </div>
                        <input type="hidden" name="txtAction" value="REGISTRAR" />
                    </fieldset>
                </form>
            </div>
            <div class="col-xs-2 col-md-3"></div>
        </div>
    </body>
</html>
