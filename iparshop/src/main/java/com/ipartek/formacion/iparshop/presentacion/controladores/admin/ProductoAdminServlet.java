package com.ipartek.formacion.iparshop.presentacion.controladores.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Producto;

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
//	Convertir
	    Long id = !sId.isBlank() ? Long.parseLong(sId) : null;
	    BigDecimal precio = !sPrecio.isBlank() ? new BigDecimal(sPrecio) : null;
	    LocalDate fechaCaducidad = !sFechaCaducidad.isBlank() ? LocalDate.parse(sFechaCaducidad) : null;
//	Empaquetar en modelos
	    var producto = Producto.builder().id(id).nombre(nombre).precio(precio).fechaCaducidad(fechaCaducidad).descripcion(descripcion).build();
//	Llamar a la lógica de negocio
	    if(producto.getId() == null) {
	    	Fabrica.getAdminNegocio().agregarProducto(producto);
	    } else {
	    	Fabrica.getAdminNegocio().modificarProducto(producto);
	    }
//	Empaquetamos los objetos que queremos ver en pantalla
	    
//	Llamamos a la pantalla
	    response.sendRedirect("productos");
	}
}
