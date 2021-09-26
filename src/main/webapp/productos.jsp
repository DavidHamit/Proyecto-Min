<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="Stylesheet" href="css/StyleMenu.css">
<link rel="Stylesheet" href="css/productos.css">
</head>
<body>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Generica</h1>
<div class="logo" id="logo"></div>
</div>
<nav class="nav">
<ul>
<li><a href="index.jsp">Login</a></li>
<li><a href="menu.jsp">Menu</a></li>
<li><a href="usuarios.jsp">Usuarios</a></li>
<li><a href="clientes.jsp">Clientes</a></li>
<li><a href="proveedores.jsp">Proveedores</a></li>
<li><a href="">Ventas</a></li>
<li><a href="">Reportes</a></li>
</ul>
</nav>
</header>
<fieldset class="cont-form">
<form action="ServletProducto" method="post" enctype="multipart/form-data">
<label>Nombre del producto
<input type="file" name="exam" value=null>
</label>
<input type="submit" name="btncarg" value="Cargar">
</form>
</fieldset>
</body>
</html>