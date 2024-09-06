package com.ipartek.formacion.iparshop.negocio;

import java.util.TreeMap;

import com.ipartek.formacion.iparshop.entidades.Producto;

public interface AdminNegocio {

	void agregarProducto(Producto producto);

	void modificarProducto(Producto producto);

	void borrarProducto(Long id);
	
	TreeMap<String, String> validarProducto(Producto producto);
	
	TreeMap<String, String> guardarProducto(Producto producto);
}
