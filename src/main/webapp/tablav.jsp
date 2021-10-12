<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/table.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/reporte.js"></script>
</head>
<body>
<%! String cedula="",total="",nom="",vtotal="",h2;%>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Generica</h1>
<div class="logo" id="logo"></div>
</div>
<input class="loginusu" type="text" value="${usu.getUsuario()}">
<nav class="nav">
<ul class="ul">
<li class="li"><a href="menu.jsp">Menu</a></li>
<li class="li"><a href="usuarios.jsp">Usuarios</a></li>
<li class="li"><a href="clientes.jsp">Clientes</a>
<li class="li"><a href="proveedores.jsp">Proveedores</a></li>
<li class="li"><a href="productos.jsp">Productos</a></li>
<li class="li"><a href="ventas.jsp">Ventas</a></li>
<li class="li"><a href="reportes.jsp">Reportes</a></li>
<li class="li"><a href="index.jsp">Salir</a></li>
</ul>
</nav>
</header>
<%HttpSession titulo=request.getSession(); %>
<%h2=(String)titulo.getAttribute("h2");%>
<h2><%=h2%></h2>
<fieldset class="cont-form">
<form action="ServletReporte" method="post">
<label>Codigo de Venta
<input class="codven" type="number" name="codven">
</label>
<input type="submit" name="cons" value="Consultar">
<input class="vent" id="vent" type="button" name="consg" value="Consulta General">
<table class="tablav" id="tablav">
<%cedula=request.getParameter("ced");
	nom=request.getParameter("nom");
	total=request.getParameter("vlr");
	vtotal=request.getParameter("sum");
	HttpSession sesion=request.getSession();
	%>
<tr>
<th>Cedula</th>
<th>Nombre</th>
<th>Valor Total de Venta</th>
</tr>
<tr>
<td><%=cedula%></td>
<td><%=nom%></td>
<td><%=total%></td>
</tr>
</table>
<table id="tablan" class="tablan">
</table>
<label class="total">Total Ventas $
<input value="${suma}" class="sum">
</label>
<input class="back" type="submit" name="back" value="Volver">
</form>
</fieldset>
</body>
</html>