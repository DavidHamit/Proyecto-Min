<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="Stylesheet" href="css/header.css">
<link rel="Stylesheet" href="css/table.css">
</head>
<body>
<%!String c="",n="",e="",u="",p="";%>
<%if(request.getParameter("cedula")!=null) {
	c=request.getParameter("cedula");
	n=request.getParameter("nombre");
	e=request.getParameter("correo");
	u=request.getParameter("usu");
	p=request.getParameter("pass");
}
%>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Generica</h1>
<div class="logo" id="logo"></div>
</div>
<input class="loginusu" type="text" value="${usu.getUsuario()}">
<nav class="nav">
<ul>
<li><a href="menu.jsp">Menu</a></li>
<li><a href="usuarios.jsp">Usuarios</a></li>
<li><a href="clientes.jsp">Clientes</a></li>
<li><a href="proveedores.jsp">Proveedores</a></li>
<li><a href="productos.jsp">Productos</a></li>
<li><a href="">Ventas</a></li>
<li><a href="">Reportes</a></li>
</ul>
</nav>
</header>
<table class="tabla">
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
</table>
</body>
</html>