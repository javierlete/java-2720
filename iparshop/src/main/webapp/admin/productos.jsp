<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<h2>Administración</h2>

<div>
	<a href="../logout">Cerrar sesión</a>
</div>

<table>
	<caption>Productos</caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Fecha de caducidad</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="p">
			<tr>
				<th>${p.id}</th>
				<td>${p.nombre}</td>
				<td><fmt:formatNumber type="currency" value="${p.precio}" /></td>
				<td>${p.fechaCaducidad}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="/WEB-INF/includes/pie.jsp"%>