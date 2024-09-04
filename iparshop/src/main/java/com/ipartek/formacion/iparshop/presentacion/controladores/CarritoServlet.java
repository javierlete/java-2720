package com.ipartek.formacion.iparshop.presentacion.controladores;

import java.io.IOException;
import java.util.ArrayList;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Producto;

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
		String sId = request.getParameter("id");

		HttpSession session = request.getSession();

		@SuppressWarnings("unchecked")
		var carrito = (ArrayList<Producto>) session.getAttribute("carrito");

		if (carrito == null) {
			carrito = new ArrayList<Producto>();

			session.setAttribute("carrito", carrito);
		}

		if (sId != null) {
			Long id = Long.parseLong(sId);

			var producto = Fabrica.getUsuarioNegocio().detalleProducto(id);
			carrito.add(producto);
		}

		request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}

}
