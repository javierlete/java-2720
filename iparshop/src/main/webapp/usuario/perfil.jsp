<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container text-center">
	<h2>PERFIL</h2>

	<%@ include file="/WEB-INF/includes/cliente.jsp"%>

	<table class="table table-bordered w-auto m-auto">
		<tbody>
			<c:forEach items="${cliente.facturas}" var="f">
				<tr>
					<td>${f.fecha}</td>
					<td><fmt:formatNumber type="currency" value="${f.total}"/></td>
					<td><a class="btn btn-sm btn-primary" href="factura?id=${f.id}">Ver factura</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>