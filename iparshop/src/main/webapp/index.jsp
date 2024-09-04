<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<ul>
	<c:forEach items="${productos}" var="p">
		<li>${p.nombre}:<fmt:formatNumber type="currency"
				value="${p.precio}" /> <a href="detalle?id=${p.id}">Ver detalle</a>
			<a href="carrito?id=${p.id}">Agregar a carrito</a></li>
	</c:forEach>
</ul>
<%@ include file="/WEB-INF/includes/pie.jsp"%>