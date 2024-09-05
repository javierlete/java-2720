package com.ipartek.formacion.iparshop.presentacion.controladores.admin;

import java.io.IOException;

import com.ipartek.formacion.iparshop.Fabrica;

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

}
