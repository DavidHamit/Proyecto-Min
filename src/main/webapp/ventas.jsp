<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/ventas.css">
</head>
<body>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Genérica</h1>
<div class="Logo" id="logo"></div>
</div>
<input class="loginusu" type="text" value="${usu.getUsuario()}">
<nav class="nav">
<ul class="ul">
<li class="li"><a href="usuarios.jsp">Usuarios</a></li>
<li class="li"><a href="clientes.jsp">Clientes</a></li>
<li class="li"><a href="proveedores.jsp">Proveedores</a></li>
<li class="li"><a href="productos.jsp">Productos</a></li>
<li class="li"><a href="reportes.jsp">Reportes</a></li>
<li class="li"><a href="index.jsp">Salir</a></li>
</ul>
</nav>
</header>
<%String mensaje,alert;
HttpSession sesion=request.getSession();%>
<%mensaje=request.getParameter("mensaje");
alert=(String)sesion.getAttribute("alert");
alert="";%>
<%if(alert!=null){ %>
<table class="cont-alert">
<tr>
<th class="alert"><%=alert%></th>
</tr>
</table>
<%} %>
<form action="ServletVentas" method="post" class="mensj">
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
<fieldset>
<legend>Menú Ventas</legend>
<form action="ServletVentas" method="post">
<label>
<input class="cedcli" type="number" name="cedula" placeholder="cedula" value="${cliente.getCedula()}">
<input class="nomcli" type="text" name="nombre" placeholder="nombre" value="${cliente.getNombre()}">
</label>
<input class="btnced" type="submit" name="cedcli" value="Confirmar">
<table>
<tbody>
<tr>
<th>Codigo del producto</th>
<th> Consultar producto</th>
<th> Nombre del producto</th>
<th> Cantidad del producto</th>
<th> Precio del producto</th> 
</tr>
<tr>
<td><input type="text" name="codigo1" value="${prod1.getCodigo()}"></td>
<td><input type="submit" name="cons1" value="Consultar"></td>
<td><input type="text" name="nomprod1" value="${prod1.getNomprod()}" class="nomprod"></td>
<td><input type="text" name="cant1"></td>
<td><input type="number" name="precio1" value="${prod1.getPrecventa()}" class="precprod"></td>
</tr>
<tr>
<td><input type="text" name="codigo2" value="${prod2.getCodigo()}"></td>
<td><input type="submit" name="cons2" value="Consultar"></td>
<td><input type="text" name="nomprod2" value="${prod2.getNomprod()}" class="nomprod"></td>
<td><input type="text" name="cant2"></td>
<td><input type="number" name="precio2" value="${prod2.getPrecventa()}" class="precprod"></td>
</tr>
<tr>
<td><input type="text" name="codigo3" value="${prod3.getCodigo()}"></td>
<td><input type="submit" name="cons3" value="Consultar"></td>
<td><input type="text" name="nomprod3" value="${prod3.getNomprod()}" class="nomprod"></td>
<td><input type="text" name="cant3"></td>
<td><input type="number" name="precio3" value="${prod3.getPrecventa()}" class="precprod"></td>
</tr>
<tr>
<td><input type="submit" name="enviar" value="Enviar venta" class="env"></td>
</tr>
</tbody>
</table>
<input type="hidden" name="cedusu" value="${usu.getCedula()}">
</form>
</fieldset>
</body>
</html>