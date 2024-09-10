package com.ipartek.formacion.iparshop.presentacion.controladores;

import java.io.IOException;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.modelos.Carrito;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		String sCantidad = request.getParameter("cantidad");

		HttpSession session = request.getSession();

		var carrito = (Carrito) session.getAttribute("carrito");

		if (carrito == null) {
			carrito = new Carrito();

			session.setAttribute("carrito", carrito);
		}

		if (sId != null) {
			Long id = Long.parseLong(sId);

			var producto = Fabrica.getUsuarioNegocio().detalleProducto(id);
			
			if(sCantidad != null) {
				int cantidad = Integer.parseInt(sCantidad);
				
				carrito.agregarProducto(producto, cantidad);
			} else {
				carrito.agregarProducto(producto);
			}
		}

		response.sendRedirect("carrito");
	}

}
