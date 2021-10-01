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
</head>
<body>
<%
%>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Generica</h1>
<div class="Logo" id="logo"></div>
</div>
<nav class="nav">
<ul class="ul">
<li class="li"><a href="menu.jsp">Menu</a></li>
<li class="li"><a href="clientes.jsp">Clientes</a></li>
<li class="li"><a href="proveedores.jsp">Proveedores</a></li>
<li class="li"><a href="productos.jsp">Productos</a></li>
<li class="li"><a href="">Ventas</a></li>
<li class="li"><a href="">Reportes</a></li>
<li class="li"><a href="index.jsp">Salir</a></li>
</ul>
</nav>
</header>
<fieldset class="cont-form">
<legend> Men� Usuarios </legend>
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
<label>Contrase�a
<input type="password" name="pass">
</label>
<label class="btn">
<input type="submit" name="btnins" value="Insertar">
<input type="submit" name="btnact" value="Actualizar">
<input type="submit" name="btncons" value="Consultar">
<input class="btneli" type="submit" name="btneli" value="Eliminar">
<input class="btnconsg" type="submit" name="btnconsg" value="Consulta General">
</label>
</form>
</fieldset>
</body>
</html>