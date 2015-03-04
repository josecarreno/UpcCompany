<%-- 
    Document   : regDepartamento
    Created on : Feb 6, 2015, 3:58:53 PM
    Author     : Renato
--%>

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
        <title>UpcCompany - Reg Departamento</title>
    </head>
    <body>
        <header>
            <%@include file="../../Resources/templates/header.jsp" %>
        </header>
        <div class="container">
            <div class="col-xs-2 col-md-3"></div>
            <div class="col-xs-8 col-md-6">
                <form id="formDepartamento" class="form-horizontal" method="post" 
                      action="<%= request.getContextPath()%>/DepartamentoController">
                    <fieldset>
                        <legend>Registrar departamento</legend>
                        <div class="form-group">
                            <label for="txtNombre" class="col-sm-3 control-label">Nombre:</label>
                            <div class="col-sm-9">
                                <input name="txtNombre" type="text" class="form-control" id="txtNombre" placeholder="Ingrese el nombre">
                            </div>
                        </div>  
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <a id="btnCancelar" name="btnCancelar" class="btn btn-danger btn-w-top-margin" 
                                   href="<%= request.getContextPath()%>/Pages/Departamento/mntDepartamento.jsp">
                                    Cancelar
                                </a>
                                <input id="btnRegDepartamento" type="submit" class="btn btn-success btn-w-top-margin" value="Registrar"/>
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
