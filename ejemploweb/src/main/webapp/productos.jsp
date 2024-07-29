<%@page import="com.ipartek.formacion.almacen.entidades.Producto"%>
<%@page import="com.ipartek.formacion.almacen.accesodatos.FabricaGenerica"%>
<%@page import="com.ipartek.formacion.almacen.accesodatos.DaoProducto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
</head>
<body>

	<% 
	DaoProducto dao = FabricaGenerica.getDaoProducto(); 
	String sIdCategoria = request.getParameter("idcategoria");
	Long idCategoria = Long.parseLong(sIdCategoria);
	%>

	<ul>
		<% for(Producto p: dao.productosPorIdCategoria(idCategoria)) { %>
		<li><%= p.getNombre() %></li>
		<% } %>	
	</ul>

	<p>
		<a href="categorias.jsp">Volver</a>
	</p>
</body>
</html>