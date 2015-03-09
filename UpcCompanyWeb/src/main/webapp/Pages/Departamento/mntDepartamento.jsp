
<%@page import="pe.com.upccompany.util.SystemUtil"%>
<%
    String mensaje = SystemUtil.validaNulo(request.getParameter("mensaje"));
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
                        <table id="table" 
                               data-toggle="table"
                               data-url="<%= request.getContextPath() %>/DepartamentoController?txtAction=LISTAR"
                               data-sort-name="idDepartamento"
                               data-sort-order="desc"
                               data-search="true"
                               data-pagination="true"
                               data-side-pagination="server"
                               data-show-toggle="true"
                               data-show-columns="true"
                               data-toolbar="#toolbar"
                               class="table table-hover table-striped table-responsive">
                            <thead>
                                <tr>
                                    <th data-field="idDepartamento"
                                        data-sortable="true">
                                        ID
                                    </th>
                                    <th data-field="nombre"
                                        data-sortable="true">
                                        Departamento
                                    </th>
                                    <th data-field="actualizar">
                                        <span class="glyphicon glyphicon-cog"></span>
                                    </th>
                                    <th data-field="eliminar">
                                        <span class="glyphicon glyphicon-trash"></span>
                                    </th>
                                </tr>
                            </thead>                            
                        </table>
                    </div> 
                </div>
                <div class="col-xs-12 col-md-3"></div>
            </div>
        </div>
    </body>
</html>