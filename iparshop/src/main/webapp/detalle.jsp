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

</body>
</html>