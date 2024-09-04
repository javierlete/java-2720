package com.ipartek.formacion.iparshop.presentacion.filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = -8047514992085519926L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		var usuario = req.getSession().getAttribute("usuario");
		
		if(usuario == null) {
			res.sendRedirect("../login");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
