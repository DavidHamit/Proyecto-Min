<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/clientes.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
</head>
<body>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Generica</h1>
<div class="Logo" id="logo"></div>
</div>
<input class="loginusu" type="text" value="${usu.getUsuario()}">
<nav class="nav">
<ul class="ul">
<li class="li"><a href="menu.jsp">Menu</a>
<li class="li"><a href="usuarios.jsp">Usuarios</a></li>
<li class="li"><a href="proveedores.jsp">Proveedores</a></li>
<li class="li"><a href="productos.jsp">Productos</a></li>
<li class="li"><a href="ventas.jsp">Ventas</a></li>
<li class="li"><a href="reportes.jsp">Reportes</a></li>
<li class="li"><a href="index.jsp">Salir</a></li>
</ul>
</nav>
</header>
<fieldset class="cont-form">
<legend> Menú Clientes </legend>
<form action="ServletCliente" method="post">
<label>Cedula
<input type="number" name="cedula" value="">
</label>
<label>Nombre
<input type="text" name="nombre">
</label>
<label>Direccion
<input type="text" name="direc">
</label>
<label>Telefono
<input type="number" name="tel" value="">
</label>
<label>Correo
<input type="text" name="email">
</label>
<label class="btn">
<input type="submit" name="btnins" value="Insertar">
<input type="submit" name="btneli" value="Eliminar">
<input type="submit" name="btnact" value="Actualizar">
<input type="submit" name="btncons" value="Consulta">
</label>
</form> 
<form action="ServletCliente" method="post">
<input class="concli" type="button" name="btnconsg" value="Consulta General">
</form>
</fieldset>
<table class="tablac"id="tablac">
<%! String cedula="",nom="",tel="",dir="",email=""; %>
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
</body>
</html>