<%@ include file="/includes/cabecera.jsp"%>

<%
String nombre = request.getParameter("nombre");
String descripcion = request.getParameter("descripcion");

if (nombre != null) {
	Categoria categoria = Categoria.builder().nombre(nombre).descripcion(descripcion).build();

	daoCategoria.insertar(categoria);

	response.sendRedirect("categorias.jsp");
}
%>

<main class="container">

	<form action="formulario-categoria.jsp" method="post">
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm-10">
				<input class="form-control" id="nombre" name="nombre">
			</div>
		</div>
		<div class="row mb-3">
			<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
			<div class="col-sm-10">
				<textarea class="form-control" id="descripcion" name="descripcion"></textarea>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Guardar</button>
	</form>

</main>

<%@ include file="/includes/pie.jsp"%>