package com.ipartek.formacion.iparshop.presentacion.controladores;

import java.io.IOException;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Cliente;
import com.ipartek.formacion.iparshop.modelos.Carrito;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/factura")
public class FacturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sId = request.getParameter("id");
		
		if(sId != null) {
			// NOS DAN UN ID DE FACTURA PARA VISUALIZAR
			var id = Long.parseLong(sId);
			var factura = Fabrica.getUsuarioNegocio().pedirFactura(id);
			
			request.setAttribute("factura", factura);
			
			request.getRequestDispatcher("factura.jsp").forward(request, response);
			
			return;
		}
		
		HttpSession session = request.getSession();

		var carrito = (Carrito) session.getAttribute("carrito");

		if(!carrito.getLineas().iterator().hasNext()) {
			// CARRITO VACÍO
			response.sendRedirect("carrito");
			return;
		}
		
		// CARRITO LLENO
		var cliente = (Cliente) session.getAttribute("cliente");

		Fabrica.getUsuarioNegocio().guardarCliente(cliente);
		
		var factura = Fabrica.getUsuarioNegocio().pedirFactura(cliente, carrito);
		var facturaGuardada = Fabrica.getUsuarioNegocio().guardarFactura(factura);
		
		carrito = new Carrito();
		session.setAttribute("carrito", carrito);
		
		response.sendRedirect("factura?id=" + facturaGuardada.getId());
	}

}
