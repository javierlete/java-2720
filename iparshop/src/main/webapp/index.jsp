<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container">
	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<c:forEach items="${productos}" var="p">
			<div class="col">
				<div class="card h-100">
					<a href="detalle?id=${p.id}"> <img
						src="https://picsum.photos/400/300?${p.id}" class="card-img-top"
						alt="..."></a>
					<form action="carrito" method="post" class="card-body d-flex flex-column">
						<input type="hidden" name="id" value="${p.id}">
						<h5 class="card-title">${p.nombre}</h5>
						<p class="card-text mb-auto">${p.descripcion}</p>
						<div class="cantidad input-group mt-3">
							<button class="btn btn-outline-secondary fs-5" type="button"><i class="bi bi-dash-lg"></i></button>
							<input name="cantidad" type="number" min="1" class="form-control text-center" value="1">
							<button class="btn btn-outline-secondary fs-5" type="button"><i class="bi bi-plus-lg"></i></button>
						</div>
						<div class="d-flex mt-2">
							<a class="btn btn-primary me-1 flex-fill"
								href="detalle?id=${p.id}"><i class="bi bi-search"></i></a> <button type="submit"
								class="btn btn-primary flex-fill"><i
								class="bi bi-cart-plus"></i></button>
						</div>
					</form>
					<div class="card-footer text-end">
						<small class="text-body-secondary"><fmt:formatNumber
								type="currency" value="${p.precio}" /></small>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</main>

<script defer src="js/cantidades.js"></script>

<%@ include file="/WEB-INF/includes/pie.jsp"%>