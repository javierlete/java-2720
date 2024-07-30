<%@page import="com.ipartek.formacion.almacen.entidades.Producto"%>
<%@ include file="/includes/cabecera.jsp"%>

<main class="container">
	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<c:forEach items="${productos}" var="p">
			<div class="col">
				<div class="card h-100">
					<img src="imgs/productos/${p.id}.jpg" class="card-img-top"
						alt="...">
					<div class="card-body">
						<h5 class="card-title">
							<a class="stretched-link" href="#">${p.nombre}</a>
						</h5>
						<p class="card-text"><fmt:formatNumber type="currency" value="${p.precio}"/></p>
					</div>
				</div>
			</div>
		</c:forEach>
		
		<c:if test="${empty productos}">
			<div class="col">
				<div class="card h-100">
					<img src="https://picsum.photos/400/300" class="card-img-top"
						alt="...">
					<div class="card-body">
						<h5 class="card-title">
							<a class="stretched-link" href="#">NO HAY NINGÚN PRODUCTO</a>
						</h5>
						<p class="card-text">No hay nada que ver, circulen</p>
					</div>
				</div>
			</div>
		</c:if>
	</div>
	<p>
		<a class="btn btn-primary" href="categorias.jsp">Volver</a>
	</p>
</main>

<%@ include file="/includes/pie.jsp"%>