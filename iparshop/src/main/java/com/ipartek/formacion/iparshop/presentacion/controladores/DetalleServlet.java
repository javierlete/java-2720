package com.ipartek.formacion.iparshop.presentacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;

import com.ipartek.formacion.iparshop.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detalle")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("producto", Producto.builder().nombre("Prueba").precio(new BigDecimal("4321.23")).build());
		
		request.getRequestDispatcher("detalle.jsp").forward(request, response);
	}

}
