<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container text-center">
	<h2>PERFIL</h2>
	
	<%@ include file="/WEB-INF/includes/cliente.jsp" %>

	<table class="table w-auto m-auto">
		<tbody>
			<c:forEach items="${cliente.facturas}" var="f">
				<td>
					${f.fecha}
				</td>
				<td>
					${f.total}
				</td>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<a class="btn btn-primary" href="factura">Comprar</a>
	</div>
</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>