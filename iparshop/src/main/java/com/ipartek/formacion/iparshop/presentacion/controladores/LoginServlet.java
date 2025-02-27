package com.ipartek.formacion.iparshop.presentacion.controladores;

import java.io.IOException;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Cliente cliente = Fabrica.getUsuarioNegocio().autenticarCliente(email, password);
		
		if(cliente != null) {
			request.getSession().setAttribute("cliente", cliente);
			
			response.sendRedirect(request.getContextPath() + "/");
			
			return;
		} else {
			request.setAttribute("email", email);
			request.setAttribute("errores", "Usuario o contraseña incorrectos");
		}
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
