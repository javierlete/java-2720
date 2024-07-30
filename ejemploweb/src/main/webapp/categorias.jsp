<%@ include file="/includes/cabecera.jsp"%>

<main class="container">
	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<c:forEach items="${categorias}" var="c">
			<div class="col">
				<div class="card h-100">
					<img src="imgs/categorias/${c.id}.jpg" class="card-img-top"
						alt="...">
					<div class="card-body">
						<h5 class="card-title">
							<a class="stretched-link"
								href="productos?idcategoria=${c.id}">${c.nombre}</a>
						</h5>
						<p class="card-text">${c.descripcion}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<p>
		<a class="btn btn-primary" href="formulario-categoria">Añadir
			categoría</a>
	</p>
</main>

<%@ include file="/includes/pie.jsp"%>