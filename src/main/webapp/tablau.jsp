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
<%! String c="",n="",e="",u="",p="",h2;%>
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
<h2><%=h2%></h2>
<fieldset class="cont-form">
<form action="ServletReporte" method="post">
<label>Cedula
<input class="cedula" type="number" name="cedula">
</label>
<input type="submit" name="cons" value="Consultar">
<input class="usu" type="button" name="consg" value="Consulta General">

<table class="tablau" id="tablau">
<%h2=request.getParameter("h2");
if(request.getParameter("cedula")!=null) {
	c=request.getParameter("cedula");
	n=request.getParameter("nombre");
	e=request.getParameter("correo");
	u=request.getParameter("usu");
	p=request.getParameter("pass");
	%>
<tr>
<th>Documento</th>
<th>Nombre</th>
<th>Correo</th>
<th>Usuario</th>
<th>Clave</th>
</tr>
<tr><td><%=c%></td>
<td><%=n%></td>
<td><%=e%></td>
<td><%=u%></td>
<td><%=p%></td></tr>
<%} %>
</table>
<input class="back" type="submit" name="back" value="Volver">
</form>
</fieldset>
</body>
</html>