<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<c:choose>
	<c:when test="${producto != null}">
		<dl>
			<dt>Nombre</dt>
			<dd>${producto.nombre}</dd>
			<dt>Precio</dt>
			<dd>
				<fmt:formatNumber type="currency" value="${producto.precio}" />
			</dd>
		</dl>
	</c:when>
	<c:otherwise>
			No se ha encontrado ese producto
		</c:otherwise>
</c:choose>
<%@ include file="/WEB-INF/includes/pie.jsp"%>