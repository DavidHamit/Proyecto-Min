<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="Stylesheet" href="css/proveedor.css">
<link rel="Stylesheet" href="css/header.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
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
<li class="li"><a href="productos.jsp">Productos</a></li>
<li class="li"><a href="ventas.jsp">Ventas</a></li>
<li class="li"><a href="reportes.jsp">Reportes</a></li>
<li class="li"><a href="index.jsp">Salir</a></li>
</ul>
</nav>
</header>
<%String mensaje;%>
<%mensaje=request.getParameter("mensaje");%>
<form action="ServletProveedor" method="post" class="mensj">
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
<legend> Men? Proovedores </legend>
<form action="ServletProveedor" method="post" >
<label for="">NIT
<input type="number" name="nitpr" value="">
</label>
<label for="">Nombre Proveedor
<input type="text" name="nompr">
</label>
<label for="">Direcci?n
<input type="text" name="dirpr">
</label>
<label for="">Tel?fono
<input type="number" name="telpr" value="">
</label>
<label for="">Ciudad
<input type="text" name="ciupr">
</label>
<label class="btn">
<input type="submit" name="btncre" value="Crear">
<input type="submit" name="btnbor" value="Borrar">
<input type="submit" name="btncon" value="Consultar">
<input type="submit" name="btnact" value="Actualizar">
</label>
</form>
<form action="ServletProovedor" method="post">
<input class="conpro" type="button" name="btnpro" value="Consulta General">
</form>
</fieldset>
<table class="tablap" id="tablap">
<%! String d="",n="",u="",t="",c="";%>
<%if(request.getParameter("nitpr")!=null){
	d=request.getParameter("nitpr");
	n=request.getParameter("nompr");
	u=request.getParameter("dirpr");
	t=request.getParameter("telpr");
	c=request.getParameter("ciupr");			
%>
<tr>
<th>NIT</th>
<th>Nombre</th>
<th>Direccion</th>
<th>Telefono</th>
<th>Ciudad</th>
</tr>
<tr><td><%=d%></td>
<td><%=n%></td>
<td><%=u%></td>
<td><%=t%></td>
<td><%=c%></td>
<%} %>
</table>
</body>
</html>