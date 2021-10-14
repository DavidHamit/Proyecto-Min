<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="Stylesheet" href="css/header.css">
<link rel="Stylesheet" href="css/productos.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
</head>
<body>
<%! String nomprod="",cod="",nit="",vlr="",iva="",total="";%>
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
<li class="li"><a href="ventas.jsp">Ventas</a></li>
<li class="li"><a href="reportes.jsp">Reportes</a></li>
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
<form action="ServletProducto" method="get">
<label class="codigo">Codigo del Producto
<input class="cod" type="number" name="codigo">
</label>
<input class="cons" type="submit" name="cons" value="Consultar">
<input class="conprod" type="button" name="consg" value="Consulta General">
</form>
</fieldset>
<table class="tablap" id="tablap">
<% if(request.getParameter("cod")!=null){
		cod=request.getParameter("cod");
		nomprod=request.getParameter("nomprod");
		nit=request.getParameter("nit");
		vlr=request.getParameter("vlr");
		iva=request.getParameter("iva");
		total=request.getParameter("total");%>
<thead>
<tr>
<th>Codigo</th>
<th>Nombre</th>
<th>NIT Proveedor</th>
<th></th>
<th>Precio Compra</th>
<th>IVA</th>
<th>Precio Venta</th>
</tr>
</thead>
<tbody>
<tr>
<td><%=cod%></td>
<td><%=nomprod%></td>
<td><%=nit%><td>
<td><%=vlr%></td>
<td><%=iva%></td>
<td><%=total%></td>
</tr>
</tbody>
<%} %>
</table>
</body>
</html>