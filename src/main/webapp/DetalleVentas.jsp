<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/DetlleVentas.css">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/reporte.js"></script>

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
<h2>Detalle Ventas</h2>
<fieldset class="cont-form">
<form action="ServletReporte" method="post">
<label class = "codventas">Código de Venta
<input class="codigoven" type="number" name="codigoven">
</label>
<input class = "consultas" type="submit" name="cons" value="Consultar" id="consultas">
<input class="dven" id="dven" type="button" name="consg" value="Consulta General">
<table class="tabladv" id="tabladv">
<%! String codven="",codprod="",nom="",cant="",total="", vIVA = "", vtotal=""; %>
<%
	codven=request.getParameter("codv");
	codprod=request.getParameter("cod");
	//nom=request.getParameter("nom");
	//nom="nombre";
	cant=request.getParameter("cant");
	vIVA = request.getParameter("iva");
	total=request.getParameter("tsv");
	vtotal=request.getParameter("total");
	HttpSession sesion=request.getSession();
	
	
	/*codven1=request.getParameter("codv1");
	codprod1=request.getParameter("cod1");
	cant1=request.getParameter("cant1");
	vIVA1= request.getParameter("iva1");
	total1=request.getParameter("tsv1");
	vtotal1=request.getParameter("total1");
	
	codven2=request.getParameter("codv2");
	codprod2=request.getParameter("cod2");
	cant2=request.getParameter("cant2");
	vIVA2= request.getParameter("iva2");
	total2=request.getParameter("tsv2");
	vtotal2=request.getParameter("total2");*/
	%>
<tr>
<!-- <th>Codigo de Venta</th> -->
<th>Codigo del Producto</th>
<!-- <th>Nombre</th> -->
<th>Cantidad</th>
<th>Total Venta</th>
<th>Valor de IVA</th>
<th>Valor Total Venta</th>
</tr>
<tr>
<!-- <td><%=codven%></td> -->
<td><%=cant%></td>
<td><%=codprod%></td>
<!-- <td><%=nom%></td> -->
<td><%=vIVA%></td>
<td><%=total%></td>
<td><%=vtotal%></td>
</tr>
<%//}%>
</table>
<input class="back" type="submit" name="back" value="Volver">
</form>
</fieldset>
</body>
</html>