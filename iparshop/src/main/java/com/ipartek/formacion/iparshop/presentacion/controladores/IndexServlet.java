package com.ipartek.formacion.iparshop.presentacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.ipartek.formacion.iparshop.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var producto1 = Producto.builder().nombre("Portátil").precio(new BigDecimal("1234.56")).build();
		var producto2 = Producto.builder().nombre("Monitor").precio(new BigDecimal("234.56")).build();
		
		var al = new ArrayList<Producto>();
		al.add(producto1);
		al.add(producto2);
		
		request.setAttribute("productos", al);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
