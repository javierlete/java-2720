package com.ipartek.formacion.iparshop.presentacion.controladores;

import java.io.IOException;

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
		
		if("admin@email.net".equals(email) && "admin".equals(password)) {
			request.getSession().setAttribute("usuario", email);
			
			response.sendRedirect("admin/productos");
			
			return;
		} else {
			request.setAttribute("email", email);
			request.setAttribute("errores", "Usuario o contraseña incorrectos");
		}
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
