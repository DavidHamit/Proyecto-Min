<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/table.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/reporte.js"></script>
</head>
<body>
<%! String h2;%>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Generica</h1>
<div class="logo" id="logo"></div>
</div>
<input class="loginusu" type="text" value="${usu.getUsuario()}">
<nav class="nav">
<ul class="ul">
<li class="li"><a href="menu.jsp">Menu</a></li>
<li class="li"><a href="usuarios.jsp">Usuarios</a></li>
<li class="li"><a href="clientes.jsp">Clientes</a>
<li class="li"><a href="proveedores.jsp">Proveedores</a></li>
<li class="li"><a href="productos.jsp">Productos</a></li>
<li class="li"><a href="ventas.jsp">Ventas</a></li>
<li class="li"><a href="reportes.jsp">Reportes</a></li>
<li class="li"><a href="index.jsp">Salir</a></li>
</ul>
</nav>
</header>
<%String mensaje;%>
<%mensaje=request.getParameter("mensaje");%>
<form action="ServletReporte" method="post" class="mensj">
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
<%HttpSession titulo=request.getSession(); %>
<%h2=(String)titulo.getAttribute("h2");%>
<h2><%=h2%></h2>
<fieldset class="cont-form">
<form action="ServletReporte" method="post">
<label>NIT
<input class="nitpr" type="number" name="nitpr">
</label>
<input type="submit" name="consp" value="Consultar">
<input class="prov" type="button" name="consg" value="Consulta General">
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
<td><%=c%></td></tr>
<%} %>
</table>

<input class="back" type="submit" name="back" value="Volver">
</form>
</fieldset>
</body>
</html>