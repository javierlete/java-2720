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
			<p class="lh-1">${factura.nombreCliente}</p>
			<p class="lh-1">${factura.direccionCliente}</p>
			<p class="lh-1">${factura.codigoPostalCliente}</p>
			<p class="lh-1">${factura.ciudadCliente}</p>
			<p class="lh-1 fw-bold">${factura.nifCliente}</p>
		</address>
	</div>
	
	<div class="d-flex justify-content-between">
		<p class="fw-bold">Factura nº: ${factura.numero}</p>
		<p class="fw-bold">${factura.fecha}</p>
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
			<c:forEach items="${factura.lineas}" var="l">
				<tr>
					<td class="text-start align-baseline">${l.nombre}</td>
					<td class="text-end align-baseline"><fmt:formatNumber
							type="currency" value="${l.precio}" /></td>
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
				<th class="text-end">
					<fmt:formatNumber type="currency" value="${factura.subtotal}" />
				</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<th class="text-end">IVA (21%)</th>
				<th class="text-end">
					<fmt:formatNumber type="currency" value="${factura.iva}" />
				</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<th class="text-end">Total</th>
				<th class="text-end">
					<fmt:formatNumber type="currency" value="${factura.total}" />
				</th>
			</tr>
		</tfoot>
	</table>
</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>