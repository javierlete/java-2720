package com.ipartek.formacion.almacen.presentacion.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ipartek.formacion.almacen.accesodatos.FabricaGenerica;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sIdCategoria = request.getParameter("idcategoria");
		Long idCategoria = Long.parseLong(sIdCategoria);
		
		var productos = FabricaGenerica.getDaoProducto().productosPorIdCategoria(idCategoria);
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
