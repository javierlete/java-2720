package com.ipartek.formacion.iparshop.presentacion.controladores.admin;

import java.io.IOException;

import com.ipartek.formacion.iparshop.Fabrica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/productos/borrar")
public class ProductoBorrarAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		Long id = Long.parseLong(sId);

		Fabrica.getAdminNegocio().borrarProducto(id);
		
		response.sendRedirect(request.getContextPath() + "/admin/productos");
//		request.getRequestDispatcher("/admin/productos").forward(request, response);
	}
}