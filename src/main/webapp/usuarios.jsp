<%@page import="controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/usuario.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
</head>
<body>
<%!String c="",n="",e="",u="",p="";%>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Generica</h1>
<div class="Logo" id="logo"></div>
</div>
<input class="loginusu" type="text" value="${usu.getUsuario()}">
<nav class="nav">
<ul class="ul">
<li class="li"><a href="menu.jsp">Menu</a></li>
<li class="li"><a href="clientes.jsp">Clientes</a></li>
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
<form action="ServletGestion" method="post" class="mensj">
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
<fieldset class="cont-form">
<legend> Menú Usuarios </legend>
<form action="ServletGestion" method="post">
<label>Cedula
<input type="number" name="cedula">
</label>
<label>Nombre Completo
<input type="text" name="nombre">
</label>
<label>Correo electronico
<input type="text" name="correo">
</label>
<label>Usuario
<input type="text" name="usu">
</label>
<label>Contraseña
<input type="password" name="pass">
</label>
<label class="btn">
<input type="submit" name="btnins" value="Insertar">
<input type="submit" name="btnact" value="Actualizar">
<input type="submit" name="btncons" value="Consultar">
<input class="btneli" type="submit" name="btneli" value="Eliminar">
</label>
</form>
<form class="form"action="ServletGestion" method="post">
        <input class="con" type="button" name="btnconsg" value="Consulta General">
    </form>
<table class="tabla" id="tabla">
<%if(request.getParameter("cedula")!=null) {
	c=request.getParameter("cedula");
	n=request.getParameter("nombre");
	e=request.getParameter("correo");
	u=request.getParameter("usu");
	p=request.getParameter("pass");
%> 
<thead class="encabezado">
<tr class="cont_enc">
<th>Cedula</th>
<th>Nombre</th>
<th>Correo</th>
<th>Usuario</th>
<th>Contraseña</th>
</tr>
</thead>
<tbody class="body">
<tr class="cont_body">
<td><%=c%></td>
<td><%=n%></td>
<td><%=e%></td>
<td><%=u%></td>
<td><%=p%></td>
</tr>
</tbody>   
<%} %>  
</table>
<form class="acabado"action="">
</form>
</fieldset>
</body>
</html>