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
<%String mensaje;%>
<%mensaje=request.getParameter("mensaje");%>
<form action="ServletLogin" method="get" class="mensj">
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