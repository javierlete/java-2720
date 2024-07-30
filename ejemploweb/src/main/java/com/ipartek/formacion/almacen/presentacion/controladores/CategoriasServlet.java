package com.ipartek.formacion.almacen.presentacion.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ipartek.formacion.almacen.accesodatos.FabricaGenerica;

@WebServlet("/categorias")
public class CategoriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var categorias = FabricaGenerica.getDaoCategoria().obtenerTodos();
		
		request.setAttribute("categorias", categorias);
		
		request.getRequestDispatcher("categorias.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
