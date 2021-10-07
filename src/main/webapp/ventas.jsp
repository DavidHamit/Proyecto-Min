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
<fieldset>
<legend>Menú Ventas</legend>
<form action="ServletVentas" method="post">
<input type="number" name="cedula" placeholder="cedula" value="${cliente.getCedula()}">
<input type="text" name="nombre" placeholder="nombre" value="${cliente.getNombre()}">
<input type="submit" name="cedcli" value="Confirmar">
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
<td><input type="submit" name="cons1" value="Buscar Producto"></td>
<td><input type="text" name="nomprod1" value="${prod1.getNomprod()}"></td>
<td><input type="text" name="cant1"></td>
<td><input type="number" name="precio1" value="${prod1.getPrecventa()}"></td>
</tr>
<tr>
<td><input type="text" name="codigo2" value="${prod2.getCodigo()}"></td>
<td><input type="submit" name="cons2" value="Consultar"></td>
<td><input type="text" name="nomprod2" value="${prod2.getNomprod()}"></td>
<td><input type="text" name="cant2"></td>
<td><input type="number" name="precio2" value="${prod2.getPrecventa()}"></td>
</tr>
<tr>
<td><input type="text" name="codigo3" value="${prod3.getCodigo()}"></td>
<td><input type="submit" name="cons3" value="Consultar"></td>
<td><input type="text" name="nomprod3" value="${prod3.getNomprod()}"></td>
<td><input type="text" name="cant3"></td>
<td><input type="number" name="precio3" value="${prod3.getPrecventa()}"></td>
</tr>
<tr>
<td><input type="submit" name="enviar" value="Enviar venta"></td>
</tr>
</tbody>
</table>
<!--<input type="hidden" name="cedusu" value="${usuario.getCedula()}"> -->
<input type="text" name="cedusu" value="${usu.getCedula()}">
</form>
</fieldset>
</body>
</html>