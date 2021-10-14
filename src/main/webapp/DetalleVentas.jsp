<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/ventas.css">
</head>
<body>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Genérica</h1>
<div class="Logo" id="logo"></div>
</div>
<input class="loginusu" type="text" value="${usu.getUsuario()}">
<nav class="nav">
<ul class="ul">
<li class="li"><a href="usuarios.jsp">Usuarios</a></li>
<li class="li"><a href="clientes.jsp">Clientes</a></li>
<li class="li"><a href="proveedores.jsp">Proveedores</a></li>
<li class="li"><a href="productos.jsp">Productos</a></li>
<li class="li"><a href="reportes.jsp">Reportes</a></li>
<li class="li"><a href="index.jsp">Salir</a></li>
</ul>
</nav>
</header>
<fieldset class="cont-form">
<form action="ServletReporte" method="post">
<label>Código de Venta
<input class="codven" type="number" name="codven">
</label>
<input type="submit" name="cons" value="Consultar">
<input class="vent" id="vent" type="button" name="consg" value="Consulta General">
<table class="tablav" id="tablav">
<%! String cedula="",nom="",total="",vtotal=""; %>
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
<label>Total Ventas $
<input value="${suma}" class="sum">
</label>
<input class="back" type="submit" name="back" value="Volver">
</form>
</fieldset>

</body>
</html>