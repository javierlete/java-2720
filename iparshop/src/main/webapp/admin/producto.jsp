<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<h2>Administración</h2>

<form>
	<input name="id" placeholder="Id"> <input name="nombre"
		placeholder="Nombre"> <input name="precio"
		placeholder="Precio"> <input name="fecha-caducidad"
		placeholder="Fecha de caducidad">
	<textarea name="descripcion" placeholder="Descripción"></textarea>
	<button>Guardar</button>
</form>
<%@ include file="/WEB-INF/includes/pie.jsp"%>