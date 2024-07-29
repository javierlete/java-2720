<%@page import="com.ipartek.formacion.almacen.entidades.Categoria"%>
<%@page import="com.ipartek.formacion.almacen.accesodatos.FabricaGenerica"%>
<%@page import="com.ipartek.formacion.almacen.accesodatos.DaoCategoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categorías</title>
</head>
<body>

	<%
	DaoCategoria dao = FabricaGenerica.getDaoCategoria();
	%>

	<ul>
		<% for(Categoria c: dao.obtenerTodos()) { %>
		<li>
			<a href="productos.jsp?idcategoria=<%= c.getId() %>">
			<%= c.getNombre() %>
			</a>
		</li>
		<% } %>
	</ul>
	
	<p>
		<a href="formulario-categoria.jsp">Añadir categoría</a>
	</p>

</body>
</html>