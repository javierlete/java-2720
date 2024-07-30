<%@ page import="com.ipartek.formacion.almacen.accesodatos.DaoProducto"%>
<%@ page import="com.ipartek.formacion.almacen.entidades.Categoria"%>
<%@ page
	import="com.ipartek.formacion.almacen.accesodatos.FabricaGenerica"%>
<%@ page import="com.ipartek.formacion.almacen.accesodatos.DaoCategoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<fmt:setLocale value="es-ES"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Almacén</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%
	DaoCategoria daoCategoria = FabricaGenerica.getDaoCategoria();
	DaoProducto daoProducto = FabricaGenerica.getDaoProducto();
	%>

	<nav class="navbar navbar-expand-lg bg-dark mb-4" data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="categorias.jsp">Almacén</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<%
					for (Categoria c : daoCategoria.obtenerTodos()) {
					%>
					<li class="nav-item border-start border-end"><a
						class="nav-link" href="productos.jsp?idcategoria=<%=c.getId()%>"><%=c.getNombre()%></a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>