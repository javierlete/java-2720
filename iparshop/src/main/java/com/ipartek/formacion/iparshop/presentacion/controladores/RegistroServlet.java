package com.ipartek.formacion.iparshop.presentacion.controladores;

import java.io.IOException;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("registro.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String codigoPostal = request.getParameter("codigo-postal");
		String ciudad = request.getParameter("ciudad");
		String nif = request.getParameter("nif");
		
		var cliente = Cliente.builder().email(email).password(password).nombre(nombre).direccion(direccion).codigoPostal(codigoPostal).ciudad(ciudad).nif(nif).build();
		
		var errores = Fabrica.getUsuarioNegocio().guardarCliente(cliente);
		
		if(errores.size() == 0) {
			request.getSession().setAttribute("cliente", cliente);
			
			response.sendRedirect("index");
			
			return;
		} else {
			request.setAttribute("cliente", cliente);
			request.setAttribute("errores", errores);
			
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			
			return;
		}
		
	}

}
