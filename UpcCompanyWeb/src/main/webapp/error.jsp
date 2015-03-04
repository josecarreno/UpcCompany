<%-- 
    Document   : index
    Created on : 07-feb-2015, 5:11:25
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="Resources/templates/metaData.jsp" %>
        <title>UpcCompany</title>
    </head>
    <body>
        <div class="container" style="margin-top: 40px">
            <div class="alert alert-danger" role="alert">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                <h3>Error:</h3>
                <p><%= request.getParameter("mensaje") %></p>
                <br/>
                <a href="<%= request.getContextPath() %>">Volver al Inicio</a>
            </div>
        </div>
    </body>
</html>
