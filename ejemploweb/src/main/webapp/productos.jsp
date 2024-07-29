<%@page import="com.ipartek.formacion.almacen.entidades.Producto"%>
<%@ include file="/includes/cabecera.jsp"%>

<%
String sIdCategoria = request.getParameter("idcategoria");
Long idCategoria = Long.parseLong(sIdCategoria);
%>

<main class="container">
	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<%
		for (Producto p : daoProducto.productosPorIdCategoria(idCategoria)) {
		%>
		<div class="col">
			<div class="card h-100">
				<img src="imgs/productos/<%=p.getId()%>.jpg"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">
						<a class="stretched-link" href="#"><%=p.getNombre()%></a>
					</h5>
					<p class="card-text"><%=p.getPrecio()%></p>
				</div>
			</div>
		</div>
		<%
		}
		%>
	</div>
	<p>
		<a class="btn btn-primary" href="categorias.jsp">Volver</a>
	</p>
</main>

<%@ include file="/includes/pie.jsp"%>