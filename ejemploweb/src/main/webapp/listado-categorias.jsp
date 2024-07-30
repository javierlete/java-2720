<%@ include file="/includes/cabecera.jsp"%>

<%
	String sBorrarId = request.getParameter("borrar");

	if(sBorrarId != null) {
		Long id = Long.parseLong(sBorrarId);
		
		daoCategoria.borrar(id);
	}
%>

<main class="container">
	<table class="table table-hover table-bordered table-striped">
		<thead class="table-dark">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Descripción</th>
				<th>OPCIONES</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Categoria c : daoCategoria.obtenerTodos()) {
			%>
			<tr>
				<th><%=c.getId()%></th>
				<td><%=c.getNombre()%></td>
				<td><%=c.getDescripcion()%></td>
				<td><a class="btn btn-primary btn-sm" href="formulario-categoria.jsp?id=<%=c.getId()%>">Editar</a> <a class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que quieres borrar el registro <%=c.getId() %>?')" href="listado-categorias.jsp?borrar=<%=c.getId()%>">Borrar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><a class="btn btn-primary btn-sm" href="formulario-categoria.jsp">Añadir
						categoría</a></td>
			</tr>
		</tfoot>
	</table>
</main>

<%@ include file="/includes/pie.jsp"%>