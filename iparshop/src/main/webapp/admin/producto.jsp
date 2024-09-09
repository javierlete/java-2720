<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container">

	<h2>Administración</h2>

	<form action="admin/producto" method="post">
		<div class="row mb-3">
			<label for="id" class="col-sm-2 col-form-label">Id</label>
			<div class="col-sm-10">
				<input type="number" class="form-control ${errores.id != null ? 'is-invalid' : '' }" id="id" name="id" placeholder="Id" value="${producto.id}" readonly>
				<div class="invalid-feedback">Debe ser un número positivo y entero</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm-10">
				<input type="text" class="form-control ${errores.nombre != null ? 'is-invalid' : '' }" id="nombre" name="nombre" placeholder="Nombre" value="${producto.nombre}">
				<div class="invalid-feedback">El nombre debe ser rellenado</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm-10">
				<input type="number" step=".01" class="form-control ${errores.precio != null ? 'is-invalid' : '' }" id="precio" name="precio" placeholder="Precio" value="${producto.precio}">
				<div class="invalid-feedback">El precio es obligatorio y debe ser positivo</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="fecha-caducidad" class="col-sm-2 col-form-label">Fecha de caducidad</label>
			<div class="col-sm-10">
				<input type="date" class="form-control ${errores.fechaCaducidad != null ? 'is-invalid' : '' }" id="fecha-caducidad" name="fecha-caducidad" placeholder="Fecha de caducidad" value="${producto.fechaCaducidad}">
				<div class="invalid-feedback">La fecha de caducidad debe ser posterior o igual que la fecha actual</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
			<div class="col-sm-10">
				<textarea class="form-control ${errores.descripcion != null ? 'is-invalid' : '' }" id="descripcion" name="descripcion" placeholder="Descripción">${producto.descripcion}</textarea>
				<div class="invalid-feedback">La descripción es demasiado larga</div>
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Guardar</button>
	</form>

</main>

<%@ include file="/WEB-INF/includes/pie.jsp"%>