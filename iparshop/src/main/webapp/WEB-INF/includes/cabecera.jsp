<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.contextPath}/">
<title>IparShop</title>
</head>
<body>

	<h1>IparShop</h1>

	<nav>
		<ul>
			<li><a href="index">Principal</a></li>
			<li><a href="carrito">Carrito</a></li>
			<c:choose>
				<c:when test="${sessionScope.usuario != null}">
					<li><a href="admin/productos">Administración</a></li>
					<li>${sessionScope.usuario}</li>
					<li><a href="logout">Cerrar sesión</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="login">Inicio sesión</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>