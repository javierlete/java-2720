<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<h2>Login</h2>

<form action="login" method="post">
	<input name="email" placeholder="Email" value="admin@email.net"><input
		type="password" name="password" placeholder="Contraseña" value="admin">
	<button>Iniciar sesión</button>
	<div>${errores}</div>
</form>
<%@ include file="/WEB-INF/includes/pie.jsp"%>