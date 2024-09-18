package com.ipartek.formacion.iparshopspring.servicios;

import java.util.TreeMap;

import com.ipartek.formacion.iparshopspring.entidades.Producto;
import com.ipartek.formacion.iparshopspring.modelos.ProductoForm;

public interface AdminService {

	default void agregarProducto(Producto producto) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default void modificarProducto(Producto producto) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default void borrarProducto(Long id) {
		throw new ServicioException("NO IMPLEMENTADO");
	}
	
	default TreeMap<String, String> validarProducto(Producto producto) {
		throw new ServicioException("NO IMPLEMENTADO");
	}
	
	default TreeMap<String, String> validarProducto(ProductoForm productoForm) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default TreeMap<String, String> guardarProducto(Producto producto) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default TreeMap<String, String> guardarProducto(ProductoForm productoForm) {
		throw new ServicioException("NO IMPLEMENTADO");
	}
}
