package com.ipartek.formacion.iparshop.serviciosrest;

import java.io.IOException;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Producto;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/productos/*")
public class ProductosRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Jsonb jsonb = JsonbBuilder.create();
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		Long id = obtenerId(request);
		
		if(id != null) {
			var producto = Fabrica.getUsuarioNegocio().detalleProducto(id);
			
			if(producto == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			String json = jsonb.toJson(producto);
			
			response.getWriter().write(json);
			
			return;
		}
		
		var productos = Fabrica.getUsuarioNegocio().listarProductos();
		
		String json = jsonb.toJson(productos);
		
		response.getWriter().write(json);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		var producto = jsonb.fromJson(request.getReader(), Producto.class);
		
		Fabrica.getAdminNegocio().agregarProducto(producto);
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		
		response.getWriter().write(jsonb.toJson(producto));
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		Long id = obtenerId(request);
		
		var producto = jsonb.fromJson(request.getReader(), Producto.class);
		
		if(producto.getId() != id) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		Fabrica.getAdminNegocio().modificarProducto(producto);
		
		response.getWriter().write(jsonb.toJson(producto));
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = obtenerId(request);
		
		Fabrica.getAdminNegocio().borrarProducto(id);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	private static Long obtenerId(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
		
		pathInfo = pathInfo == null ? "" : pathInfo.substring(1);
		
		if(pathInfo.length() > 0) {
			Long id = Long.parseLong(pathInfo);
			
			return id;
		}
		
		return null;
	}
	
}
