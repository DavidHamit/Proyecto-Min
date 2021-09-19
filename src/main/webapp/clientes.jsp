<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="Stylesheet" href="css/StyleMenu.css">
<link rel="Stylesheet" href="">
</head>
<body>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Generica</h1>
<div class="logo" id="logo"></div>
</div>
<nav class="nav">
<ul>
<li><a href="index.jsp">Login</a>
<li><a href="menu.jsp">Menu</a>
<li><a href="usuarios.jsp">Usuarios</a></li>
<li><a href="">Proveedores</a></li>
<li><a href="">Productos</a></li>
<li><a href="">Ventas</a></li>
<li><a href="">Reportes</a></li>
</ul>
</nav>
</header>
<form action="ServletCliente" method="post">
<label>Cedula
<input type="number" name="cedula" value="<%=0%>">
</label>
<label>Nombre
<input type="text" name="nombre">
</label>
<label>Direccion
<input type="text" name="direc">
</label>
<label>Telefono
<input type="number" name="tel" value="<%=0%>">
</label>
<label>Correo
<input type="text" name="email">
</label>
<input type="submit" name="btnins" value="Insertar">
<input type="submit" name="btneli" value="Eliminar">
<input type="submit" name="btnact" value="Actualizar">
<input type="submit" name="btncons" value="Consulta">
<input type="submit" name="btnconsg" Value="Consulta General">
</form> 
</body>
</html>