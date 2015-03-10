<%@page import="pe.com.upccompany.util.SystemUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = SystemUtil.validaNulo(request.getParameter("mensaje"));
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
                        <table id="table" 
                               data-toggle="table"
                               data-url="<%= request.getContextPath() %>/EmpleadoController?txtAction=LISTAR"
                               data-sort-name="idEmpleado"
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
                                    <th data-field="idEmpleado"
                                        data-sortable="true">
                                        ID
                                    </th>
                                    <th data-field="dni"
                                        data-sortable="true">
                                        DNI
                                    </th>
                                    <th data-field="nombre"
                                        data-sortable="true">
                                        Nombre
                                    </th>               
                                    <th data-field="apellido"
                                        data-sortable="true">
                                        Apellido
                                    </th>                     
                                    <th data-field="sexo"
                                        data-sortable="true">
                                        Sexo
                                    </th>                
                                    <th data-field="departamento"
                                        data-sortable="true">
                                        Departamento
                                    </th>
                                    <th data-field="idiomas">
                                        Idiomas
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
                <div class="col-xs-12 col-md-1"></div>
            </div>
        </div>
    </body>
</html>