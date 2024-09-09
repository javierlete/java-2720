<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container">
	<c:choose>
		<c:when test="${producto != null}">
			<div class="card mb-3">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="https://picsum.photos/640/480"
							class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body h-100 d-flex flex-column">
							<h5 class="card-title">${producto.nombre}</h5>
							<p class="card-text">${producto.descripcion}</p>
							<dl class="card-text">
								<dt>Precio</dt>
								<dd>
									<fmt:formatNumber type="currency" value="${producto.precio}" />
								</dd>
							</dl>

							<p class="card-text mt-auto">
								<small class="text-body-secondary">${producto.fechaCaducidad}</small>
							</p>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<p class="lead">No se ha encontrado ese producto</p>
		</c:otherwise>
	</c:choose>
</main>

<%@ include file="/WEB-INF/includes/pie.jsp"%>