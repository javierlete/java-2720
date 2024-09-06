<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<h2>Administración</h2>

<form action="admin/producto" method="post">
	<input name="id" placeholder="Id" value="${producto.id}" readonly>
	<div>${errores.id}</div>
	<input name="nombre" placeholder="Nombre" value="${producto.nombre}">
	<div>${errores.nombre}</div>
	<input name="precio" type="number" step=".01" placeholder="Precio"
		value="${producto.precio}">
	<div>${errores.precio}</div>
	<input name="fecha-caducidad" type="date"
		placeholder="Fecha de caducidad" value="${producto.fechaCaducidad}">
	<div>${errores.fechaCaducidad}</div>
	<textarea name="descripcion" placeholder="Descripción">${producto.descripcion}</textarea>
	<div>${errores.descripcion}</div>
	<button>Guardar</button>
</form>

<%@ include file="/WEB-INF/includes/pie.jsp"%>