<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container text-center">
	<h2>CARRITO</h2>

	<table class="table w-auto m-auto">
		<thead>
			<tr>
				<th>Nombre</th>
				<th class="text-end">Precio</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="total" value="${0}" />

			<c:forEach items="${carrito}" var="p">
				<c:set var="total" value="${total + p.precio}" />

				<tr>
					<td>${p.nombre}</td>
					<td class="text-end"><fmt:formatNumber type="currency"
							value="${p.precio}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th>Total</th>
				<th class="text-end"><fmt:formatNumber type="currency"
							value="${total}" /></th>
			</tr>
		</tfoot>
	</table>
</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>