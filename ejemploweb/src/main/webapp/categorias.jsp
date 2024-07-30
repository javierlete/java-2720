<%@ include file="/includes/cabecera.jsp"%>

<main class="container">
	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<%
		for (Categoria c : daoCategoria.obtenerTodos()) {
		%>
		<div class="col">
			<div class="card h-100">
				<img src="imgs/categorias/<%=c.getId()%>.jpg" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">
						<a class="stretched-link"
							href="productos.jsp?idcategoria=<%=c.getId()%>"><%=c.getNombre()%></a>
					</h5>
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

<%@ include file="/includes/pie.jsp"%>