<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IparShop</title>
</head>
<body>

	<h1>IparShop</h1>

	<h2>Administración</h2>

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

</body>
</html>