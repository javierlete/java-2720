package com.ipartek.formacion.iparshop.presentacion.controladores.admin;

import java.io.IOException;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.modelos.ProductoForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/producto")
public class ProductoAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.parseLong(sId);

			var producto = Fabrica.getUsuarioNegocio().detalleProducto(id);

			request.setAttribute("producto", producto);
		}

		request.getRequestDispatcher("/admin/producto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	Recoger información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String sFechaCaducidad = request.getParameter("fecha-caducidad");
		String descripcion = request.getParameter("descripcion");
//	Empaquetar en modelos
		var productoForm = ProductoForm.builder().id(sId).nombre(nombre).precio(sPrecio).fechaCaducidad(sFechaCaducidad).descripcion(descripcion).build();
//	Llamar a la lógica de negocio
		var errores = Fabrica.getAdminNegocio().guardarProducto(productoForm);

		if (errores.size() > 0) {
//			Empaquetamos los objetos que queremos ver en pantalla
			request.setAttribute("errores", errores);
			request.setAttribute("producto", productoForm);

//			Llamamos a la pantalla
			request.getRequestDispatcher("/admin/producto.jsp").forward(request, response);
			return;
		}
//	Llamamos a la pantalla
		response.sendRedirect("productos");
	}

}
