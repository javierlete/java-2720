<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container text-center">
	<h2>CARRITO</h2>

	<table class="table w-auto m-auto">
		<thead>
			<tr>
				<th>Eliminar</th>
				<th>Nombre</th>
				<th class="text-end">Precio</th>
				<th class="text-start">Cantidad</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${carrito.lineas}" var="l">
				<tr>
					<td class="align-baseline">
						<form action="carrito" method="post">
							<input type="hidden" name="actualizar">
							<input type="hidden" name="id" value="${l.producto.id}">
							<input type="hidden" name="cantidad" value="0">

							<button class="btn btn-danger">
								<i class="bi bi-x-lg"></i>
							</button>
						</form>
					</td>
					<td class="align-baseline">${l.producto.nombre}</td>
					<td class="text-end align-baseline"><fmt:formatNumber
							type="currency" value="${l.producto.precio}" /></td>
					<td class="align-baseline">
						<form action="carrito" method="post">
							<input type="hidden" name="actualizar">
							<input type="hidden" name="id" value="${l.producto.id}">
							<div class="cantidad input-group mt-3 align-baseline">
								<button class="btn btn-outline-secondary fs-5" type="button">
									<i class="bi bi-dash-lg"></i>
								</button>
								<input name="cantidad" type="number" style="max-width: 3rem"
									min="0" class="form-control text-center align-baseline"
									value="${l.cantidad}">
								<button class="btn btn-outline-secondary fs-5" type="button">
									<i class="bi bi-plus-lg"></i>
								</button>
								<button type="submit" class="btn btn-primary">
									<i class="bi bi-check-lg"></i>
								</button>
							</div>
						</form>
					</td>
					<td class="align-baseline"><fmt:formatNumber type="currency"
							value="${l.total}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td>
					<form action="carrito" method="post">
						<input type="hidden" name="vaciar">

						<button data-bs-toggle="tooltip" data-bs-title="Vaciar carrito" class="btn btn-danger">
							<i class="bi bi-cart-x"></i>
						</button>
					</form>
				</td>
				<td></td>
				<td></td>
				<th class="text-end">Total</th>
				<th class="text-end"><fmt:formatNumber type="currency"
						value="${carrito.total}" /></th>
			</tr>
		</tfoot>
	</table>
</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>