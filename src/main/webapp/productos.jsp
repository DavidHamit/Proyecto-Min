<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="Stylesheet" href="css/header.css">
<link rel="Stylesheet" href="css/productos.css">
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
<li class="li"><a href="clientes.jsp">Clientes</a></li>
<li class="li"><a href="proveedores.jsp">Proovedores</a></li>
<li class="li"><a href="">Ventas</a></li>
<li class="li"><a href="">Reportes</a></li>
<li class="li"><a href="index.jsp">Salir</a></li>
</ul>
</nav>
</header>
<fieldset class="cont-form">
<legend> Menú Productos </legend>
<form action="ServletProducto" method="post" enctype="multipart/form-data">
<label>Nombre del producto
<input type="file" name="exam">
</label>
<input type="submit" name="btncarg" value="Cargar">
</form>
</fieldset>
</body>
</html>