package com.ipartek.formacion.iparshop.negocio;

import java.util.TreeMap;

import com.ipartek.formacion.iparshop.entidades.Producto;
import com.ipartek.formacion.iparshop.modelos.ProductoForm;

public interface AdminNegocio {

	void agregarProducto(Producto producto);

	void modificarProducto(Producto producto);

	void borrarProducto(Long id);
	
	TreeMap<String, String> validarProducto(Producto producto);
	
	TreeMap<String, String> validarProducto(ProductoForm productoForm);

	TreeMap<String, String> guardarProducto(Producto producto);

	TreeMap<String, String> guardarProducto(ProductoForm productoForm);
}
