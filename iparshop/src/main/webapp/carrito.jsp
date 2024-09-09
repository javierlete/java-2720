<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container text-center">
	<h2>CARRITO</h2>

	<table class="table w-auto m-auto">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Cantidad</th>
				<th class="text-end">Precio</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${carrito.lineas}" var="l">
				<tr>
					<td>${l.producto.nombre}</td>
					<td>${l.cantidad}</td>
					<td class="text-end"><fmt:formatNumber type="currency"
							value="${l.producto.precio}" /></td>
					<td><fmt:formatNumber type="currency"
							value="${l.total}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<th>Total</th>
				<th class="text-end"><fmt:formatNumber type="currency"
							value="${carrito.total}" /></th>
			</tr>
		</tfoot>
	</table>
</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>