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

	<h2>CARRITO</h2>

	<ul>
		<c:forEach items="${carrito}" var="p">
			<li>${p.nombre}:<fmt:formatNumber type="currency"
					value="${p.precio}" /> <a href="detalle?id=${p.id}">Ver detalle</a> <a href="carrito?id=${p.id}">Agregar a carrito</a></li>
		</c:forEach>
	</ul>

</body>
</html>