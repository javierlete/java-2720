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

	<h2>Login</h2>

	<form action="login" method="post">
		<input name="email" placeholder="Email" value="${email}"><input type="password" name="password" placeholder="Contraseña">
		<button>Iniciar sesión</button>
		<div>${errores}</div>
	</form>
</body>
</html>