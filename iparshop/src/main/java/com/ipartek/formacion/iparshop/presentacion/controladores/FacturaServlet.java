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
		
		HttpSession session = request.getSession();

		var carrito = (Carrito) session.getAttribute("carrito");
		var cliente = (Cliente) session.getAttribute("cliente");

		cliente = Cliente.builder().nombre("Pepe Pérez").ciudad("Bilbao").codigoPostal("12345").direccion("Su casa").nif("12345678Z").build();
		
		Fabrica.getUsuarioNegocio().guardarCliente(cliente);
		
		var factura = Fabrica.getUsuarioNegocio().pedirFactura(cliente, carrito);
		var facturaGuardada = Fabrica.getUsuarioNegocio().guardarFactura(factura);
		
		request.setAttribute("factura", facturaGuardada);
		
		request.getRequestDispatcher("factura.jsp").forward(request, response);
	}

}
