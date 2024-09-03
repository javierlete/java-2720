<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<fmt:setLocale value="es-ES"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IparShop</title>
</head>
<body>

	<h1>IparShop</h1>
	
	<dl>
		<dt>Nombre</dt>
		<dd>${producto.nombre}</dd>
		<dt>Precio</dt>
		<dd><fmt:formatNumber type="currency" value="${producto.precio}"/></dd>
	</dl>

</body>
</html>