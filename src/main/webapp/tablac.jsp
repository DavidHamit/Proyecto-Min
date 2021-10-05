<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/table.css">
</head>
<body>
<%! String cedula,tel,nom,dir,email;%>
<%cedula=request.getParameter("cedula");
nom=request.getParameter("nombre");
dir=request.getParameter("direc");
tel=request.getParameter("tel");
email=request.getParameter("email");%>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Generica</h1>
<div class="logo" id="logo"></div>
</div>
<nav class="nav">
<ul>
<li><a href="index.jsp">Index</a>
<li><a href="menu.jsp">Menu</a></li>
<li><a href="usuarios.jsp">Usuarios</a></li>
<li><a href="clientes.jsp">Clientes</a>
<li><a href="">Proveedores</a></li>
<li><a href="">Productos</a></li>
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
<th>Direccion</th>
<th>Telefono</th>
<th>Correo</th>
</tr>
</thead>
<tbody class="body">
<tr class="cont_body">
<td><%=cedula%></td>
<td><%=nom %></td>
<td><%=dir%></td>
<td><%=tel%></td>
<td><%=email%></td>
</tr>
</tbody>
</table>
</body>
</html>