<%@ include file="/includes/cabecera.jsp"%>

<%
String sId = request.getParameter("id");

String nombre = request.getParameter("nombre");
String descripcion = request.getParameter("descripcion");

if (nombre != null) {
	Categoria categoria = Categoria.builder().nombre(nombre).descripcion(descripcion).build();

	if(sId.equals("null")) {
		daoCategoria.insertar(categoria);
	} else {
		Long id = Long.parseLong(sId);
		categoria.setId(id);
		
		daoCategoria.modificar(categoria);
	}

	response.sendRedirect("categorias.jsp");
	
	return;
}

Categoria categoria = Categoria.builder().nombre("").descripcion("").build();

if (sId != null) {
	Long id = Long.parseLong(sId);
	
	categoria = daoCategoria.obtenerPorId(id);
}
%>

<main class="container">

	<form action="formulario-categoria.jsp" method="post">
		<input type="text" name="id" value="<%=categoria.getId()%>">
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm-10">
				<input class="form-control" id="nombre" name="nombre" value="<%=categoria.getNombre()%>">
			</div>
		</div>
		<div class="row mb-3">
			<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
			<div class="col-sm-10">
				<textarea class="form-control" id="descripcion" name="descripcion"><%=categoria.getDescripcion()%></textarea>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Guardar</button>
	</form>

</main>

<%@ include file="/includes/pie.jsp"%>