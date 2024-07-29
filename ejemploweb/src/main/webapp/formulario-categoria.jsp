<%@page
	import="com.ipartek.formacion.almacen.accesodatos.FabricaGenerica"%>
<%@page import="com.ipartek.formacion.almacen.accesodatos.DaoCategoria"%>
<%@page import="com.ipartek.formacion.almacen.entidades.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categoría</title>
</head>
<body>

	<form action="formulario-categoria.jsp" method="post">
		<input name="nombre" placeholder="Nombre">
		<textarea name="descripcion" placeholder="Descripción"></textarea>
		<button>Guardar</button>
	</form>

	<%
	String nombre = request.getParameter("nombre");
	String descripcion = request.getParameter("descripcion");

	if (nombre != null) {
		Categoria categoria = Categoria.builder().nombre(nombre).descripcion(descripcion).build();

		DaoCategoria dao = FabricaGenerica.getDaoCategoria();

		dao.insertar(categoria);
		
		response.sendRedirect("categorias.jsp");
	}
	%>

	<pre>
<%=nombre%>
<%=descripcion%>
</pre>

</body>
</html>