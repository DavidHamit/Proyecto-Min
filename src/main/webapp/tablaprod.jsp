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
<%! String codigo="",nit="",nom="",prec="",iva="",total="",h2;%>
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
<%HttpSession titulo=request.getSession(); %>
<%h2=(String)titulo.getAttribute("h2");%>
<h2><%=h2%></h2>
<fieldset class="cont-form">
<form action="ServletReporte" method="post">
<label>Codigo
<input class="cedula" type="number" name="codprod">
</label>
<input type="submit" name="consc" value="Consultar">
<input class="prod" type="button" name="consg" value="Consulta General">
<table class="tablaprod" id="tablaprod">
<%if(request.getParameter("codigo")!=null){
	codigo=request.getParameter("codigo");
	nom=request.getParameter("nomprod");
	nit=request.getParameter("nit");
	prec=request.getParameter("prec");
	iva=request.getParameter("iva");
	total=request.getParameter("venta");
	%>
<tr>
<th>Codigo</th>
<th>Nombre</th>
<th>NIT Proveedor</th>
<th>Precio Compra</th>
<th>IVA</th>
<th>Precio Venta</th>
</tr>
<tr>
<td><%=codigo%></td>
<td><%=nom%></td>
<td><%=nit%></td>
<td><%=prec%></td>
<td><%=iva%></td>
<td><%=total%></td>
</tr>
<%} %>
</table>

<input class="back" type="submit" name="back" value="Volver">
</form>
</fieldset>
</body>
</html>