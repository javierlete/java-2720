<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<h2>Administración</h2>

<form>
	<input name="id" placeholder="Id" value="${producto.id}"> <input name="nombre"
		placeholder="Nombre" value="${producto.nombre}"> <input name="precio"
		placeholder="Precio" value="${producto.precio}"> <input name="fecha-caducidad"
		placeholder="Fecha de caducidad" value="${producto.fechaCaducidad}">
	<textarea name="descripcion" placeholder="Descripción">${producto.descripcion}</textarea>
	<button>Guardar</button>
</form>
<%@ include file="/WEB-INF/includes/pie.jsp"%>