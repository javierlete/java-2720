<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="favicon.svg">
<base href="${pageContext.request.contextPath}/">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="css/iparshop.css">
<title>IparShop</title>
</head>
<body>

	<nav class="d-print-none navbar navbar-expand-sm bg-dark sticky-top"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">IparShop</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-sm-0">
					<li class="nav-item"><a class="nav-link" href="index">Principal</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-sm-0">
					<li class="nav-item"><a class="nav-link" href="carrito">Carrito</a></li>

					<c:if test="${sessionScope.cliente.email == 'admin@email.net'}">
						<li class="nav-item"><a class="nav-link"
							href="admin/productos">Administración</a></li>
					</c:if>

					<c:choose>
						<c:when test="${sessionScope.cliente != null}">
							<li class="nav-item"><a class="nav-link"
								href="usuario/perfil">Perfil</a></li>
							<li class="navbar-text">${sessionScope.cliente.nombre}</li>
							<li class="nav-item"><a class="nav-link" href="logout">Cerrar
									sesión</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="login">Inicio
									sesión</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>
	</nav>

	<div class="mb-4"></div>