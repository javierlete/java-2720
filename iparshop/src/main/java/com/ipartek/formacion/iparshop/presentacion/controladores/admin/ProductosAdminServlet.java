package com.ipartek.formacion.iparshop.presentacion.controladores.admin;

import java.io.IOException;

import com.ipartek.formacion.iparshop.Fabrica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/productos")
public class ProductosAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var productos = Fabrica.getUsuarioNegocio().listarProductos();
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("/admin/productos.jsp").forward(request, response);
	}

}
