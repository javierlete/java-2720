<%@page import="com.ipartek.formacion.almacen.entidades.Categoria"%>
<%@page
	import="com.ipartek.formacion.almacen.accesodatos.FabricaGenerica"%>
<%@page import="com.ipartek.formacion.almacen.accesodatos.DaoCategoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categorías</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%
	DaoCategoria dao = FabricaGenerica.getDaoCategoria();
	%>

	<nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<%
					for (Categoria c : dao.obtenerTodos()) {
					%>
					<li class="nav-item border-start border-end"><a
						class="nav-link" href="#"><%=c.getNombre()%></a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<main class="container">
		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
			<%
			for (Categoria c : dao.obtenerTodos()) {
			%>
			<div class="col">
				<div class="card h-100">
					<img src="https://picsum.photos/400/300?<%=c.getId()%>"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title"><%=c.getNombre()%></h5>
						<p class="card-text"><%=c.getDescripcion()%></p>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>

		<p>
			<a class="btn btn-primary" href="formulario-categoria.jsp">Añadir
				categoría</a>
		</p>
	</main>
	
	<footer class="p-2 text-bg-dark">
		<p>&copy;2024 Javier Lete</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>