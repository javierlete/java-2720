<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container">
	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<c:forEach items="${productos}" var="p">
			<div class="col">
				<div class="card h-100">
					<img src="https://picsum.photos/400/300?${p.id}"
						class="card-img-top" alt="...">
					<div class="card-body d-flex flex-column">
						<h5 class="card-title">${p.nombre}</h5>
						<p class="card-text mb-auto">${p.descripcion}</p>
						<div class="d-flex mt-2">
							<a class="btn btn-primary me-1 flex-fill" href="detalle?id=${p.id}"><i
								class="bi bi-search"></i></a> <a class="btn btn-primary flex-fill"
								href="carrito?id=${p.id}"><i class="bi bi-cart-plus"></i></a>
						</div>
					</div>
					<div class="card-footer">
						<small class="text-body-secondary"><fmt:formatNumber
								type="currency" value="${p.precio}" /></small>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</main>

<%@ include file="/WEB-INF/includes/pie.jsp"%>