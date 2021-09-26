<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto</title>
<link rel="Stylesheet" href="css/proveedor.css">
<link rel="Stylesheet" href="css/StyleMenu.css">
</head>
<body>
<header class="cont-header">
<div class="logo-titulo">
<h1 class="h1" id="h1">Tienda Generica</h1>
<div class="logo" id="logo"></div>
</div>
<nav class="nav">
<ul class="ul">
<li><a href="index.jsp">Login</a></li>
<li><a href="menu.jsp">Menu</a></li>
<li><a href="usuarios.jsp">Usuarios</a></li>
<li><a href="clientes.jsp">Clientes</a></li>
<li><a href="productos.jsp">Productos</a></li>
<li><a href="">Ventas</a></li>
<li><a href="">Reportes</a></li>
</ul>
</nav>
</header>
<%
String d="",n="",u="",t="",c="";
if(request.getParameter("ni")!=null){
	d=request.getParameter("ni");
	n=request.getParameter("npr");
	u=request.getParameter("di");
	t=request.getParameter("te");
	c=request.getParameter("ci");			
}
%>
<fieldset class="cont-form">
<form action="ServletProveedor" method="post" >
<label for="">NIT
<input type="number" name="nit_pr" value="<%=d%>">
</label>
<label for="">Nombre Proveedor
<input type="text" name="nom_pr" value="<%=n%>">
</label>
<label for="">Direcci�n
<input type="text" name="dir_pr" value="<%=u%>">
</label>
<label for="">Tel�fono
<input type="text" name="tel_pr" value="<%=t%>">
</label>
<label for="">Ciudad
<input type="text" name="ciu_pr" value="<%=c%>">
</label>
<label class="btn">
<input type="submit" name="btncre" value="Crear">
<input type="submit" name="btnbor" value="Borrar">
<input type="submit" name="btncon" value="Consultar">
<input type="submit" name="btnact" value="Actualizar">
</label>
</form>
</fieldset>
</body>
</html>