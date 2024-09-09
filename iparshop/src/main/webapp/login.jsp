<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container">

	<h2>Login</h2>

	<form action="login" method="post">
		<div class="row mb-3">
			<label for="email" class="col-sm-2 col-form-label">Usuario</label>
			<div class="col-sm-10">
				<input type="email" name="email" value="admin@email.net" class="form-control" id="email">
			</div>
		</div>
		<div class="row mb-3">
			<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
			<div class="col-sm-10">
				<input type="password" name="password" value="admin" class="form-control" id="password">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Inicio sesión</button>
		<div class="text-danger">${errores}</div>
	</form>

</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>