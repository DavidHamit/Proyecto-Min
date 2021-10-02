<%@page import="controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
Conexion con=new Conexion();
con.conexionbd();
%>
<fieldset class="cont-form">
<legend> Bienvenidos</legend>
<legend class="l2">a la Tienda Generica</legend>
<form action="ServletLogin" method="get">
<label>Usuario
<input type="text" name="usu">
</label>
<label>Contraseña
<input type="password" name="pass">
</label>
<input class="btnacep" type="submit" name="btnacep" value="Aceptar">
<input class="btncan" type="submit" name="btncan" value="Cancelar">
</form>
</fieldset>

</body>
</html>