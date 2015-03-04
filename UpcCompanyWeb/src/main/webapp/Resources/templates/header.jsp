<%--
    Document   : header
    Created on : Feb 6, 2015, 4:35:42 PM
    Author     : Renato
--%>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%= application.getContextPath()%>/index.jsp"><span class="glyphicon glyphicon-globe"></span>&nbsp;&nbsp;UpcCompany</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li id="empleados-nav" class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Empleados <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a id="empleados" href="<%= application.getContextPath()%>/Pages/Empleado/mntEmpleado.jsp">Listar</a></li>
                        <li><a href="<%= application.getContextPath()%>/Pages/Empleado/regEmpleado.jsp">Registrar</a></li>
                    </ul>
                </li>
                <li id="departamentos-nav" class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Departamentos <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a id="departamentos" href="<%= application.getContextPath()%>/Pages/Departamento/mntDepartamento.jsp">Listar</a></li>
                        <li><a href="<%= application.getContextPath()%>/Pages/Departamento/regDepartamento.jsp">Registrar</a></li>
                    </ul>
                </li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>