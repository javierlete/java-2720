<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container-fuild">

	<h2>Administración</h2>

	<table class="table table-bordered table-striped table-hover">
		<caption>Productos</caption>
		<thead class="table-secondary">
			<tr>
				<th class="text-end">Id</th>
				<th>Nombre</th>
				<th class="text-end">Precio</th>
				<th>Fecha de caducidad</th>
				<th>OPCIONES</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<th class="text-end">${p.id}</th>
					<td>${p.nombre}</td>
					<td class="text-end"><fmt:formatNumber type="currency" value="${p.precio}" /></td>
					<td>${p.fechaCaducidad}</td>
					<td><a class="btn btn-sm btn-outline-primary" href="admin/producto?id=${p.id}"><i class="bi bi-pencil"></i></a> <a
						class="btn btn-sm btn-outline-danger" href="admin/productos/borrar?id=${p.id}"
						onclick="javascript:return confirm('¿Estás seguro de borrar el ${p.nombre}?')"><i class="bi bi-x"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="table-secondary">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a class="btn btn-sm btn-outline-primary" href="admin/producto"><i class="bi bi-plus"></i></a></td>
			</tr>
		</tfoot>
	</table>

</main>

<%@ include file="/WEB-INF/includes/pie.jsp"%>