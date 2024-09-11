<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container text-center">
	<h2>FACTURA</h2>

	<div id="superior" class="d-flex justify-content-between">
		<address id="emisor" class="text-start">
			<p class="lh-1">IparShop S.A.</p>
			<p class="lh-1">Su casa</p>
			<p class="lh-1">12345</p>
			<p class="lh-1">Bilbao</p>
			<p class="lh-1 fw-bold">B12345678</p>
		</address>

		<address id="receptor" class="text-end">
			<p class="lh-1">Cliente Clientez</p>
			<p class="lh-1">Calle Kalea</p>
			<p class="lh-1">54321</p>
			<p class="lh-1">Su ciudad</p>
			<p class="lh-1 fw-bold">12345678Z</p>
		</address>
	</div>
	
	<div class="d-flex justify-content-between">
		<p class="fw-bold">Factura nº: 1234</p>
		<p class="fw-bold">2024-09-11</p>
	</div>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th class="text-start">Nombre</th>
				<th class="text-end">Precio</th>
				<th>Cantidad</th>
				<th class="text-end">Total</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="text-start align-baseline">Un producto</td>
				<td class="text-end align-baseline">1.234,56 €</td>
				<td class="align-baseline">3</td>
				<td class="align-baseline text-end">3456,78 €</td>
			</tr>
			<c:forEach items="${factura.lineas}" var="l">
				<tr>
					<td class="text-start align-baseline">${l.producto.nombre}</td>
					<td class="text-end align-baseline"><fmt:formatNumber
							type="currency" value="${l.producto.precio}" /></td>
					<td class="align-baseline">${l.cantidad}</td>
					<td class="align-baseline text-end"><fmt:formatNumber type="currency"
							value="${l.total}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<th class="text-end">Subtotal</th>
				<th class="text-end">3.456,78 € <%-- 					<fmt:formatNumber type="currency" --%>
					<%-- 						value="${factura.total}" /> --%>
				</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<th class="text-end">IVA (21%)</th>
				<th class="text-end">3.456,78 € <%-- 					<fmt:formatNumber type="currency" --%>
					<%-- 						value="${factura.total}" /> --%>
				</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<th class="text-end">Total</th>
				<th class="text-end">3.456,78 € <%-- 					<fmt:formatNumber type="currency" --%>
					<%-- 						value="${factura.total}" /> --%>
				</th>
			</tr>
		</tfoot>
	</table>
</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>