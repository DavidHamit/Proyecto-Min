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
<%! String cedula="",tel="",nom="",dir="",email="",h2;%>
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
<%String mensaje;%>
<%mensaje=request.getParameter("mensaje");%>
<form action="ServletReporte" method="post" class="mensj">
<%if(mensaje!=null){ %>
<table class="cont-menj">
<tr>
<th><%=mensaje%></th>
</tr>
<tr>
<td><input type="submit" name="ok" value="OK" class="ok"></td>
</tr>
</table>
<%}%>
</form>
<%HttpSession titulo=request.getSession(); %>
<%h2=(String)titulo.getAttribute("h2");%>
<h2><%=h2%></h2>
<fieldset class="cont-form">
<form action="ServletReporte" method="post">
<label>Cedula
<input class="cedula" type="number" name="cedula">
</label>
<input type="submit" name="consc" value="Consultar">
<input class="cli" type="button" name="consg" value="Consulta General">
<table class="tablac" id="tablac">
<%if(request.getParameter("cedula")!=null){
	cedula=request.getParameter("cedula");
	nom=request.getParameter("nombre");
	dir=request.getParameter("direc");
	tel=request.getParameter("tel");
	email=request.getParameter("email");
	%>
<tr>
<th>Cedula</th>
<th>Nombre</th>
<th>Direccion</th>
<th>Telefono</th>
<th>Correo</th>
</tr>
<tr><td><%=cedula%></td>
<td><%=nom%></td>
<td><%=dir%></td>
<td><%=tel%></td>
<td><%=email%></td></tr>
<%} %>
</table>

<input class="back" type="submit" name="back" value="Volver">
</form>
</fieldset>
</body>
</html>