<%@page import="controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="stylesheet" href="css//style.css">
</head>
<body>
<%
Conexion con=new Conexion();
con.conexionbd();
%>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1">Bienvenido a la Tienda Generica</h1>
<div class="logo"></div>
</div>
</header>
<form action="ServletLogin" method="get">
<fieldset>
<label>Usuario
<input type="text" name="usu">
</label>
<label>Contraseña
<input type="password" name="pass">
</label>
</fieldset>
<fieldset class="field_btn">
<label class="btn">
<input class="btnacep" type="submit" name="btnacep" value="Aceptar">
<input class="btncan" type="submit" name="btncan" value="Cancelar">
</label>
</fieldset>
</form>
</body>
</html>