package com.ipartek.formacion.iparshopspring.servicios;

import com.ipartek.formacion.iparshopspring.entidades.Producto;

public interface AdminService extends UsuarioService {

	default Producto agregarProducto(Producto producto) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default Producto modificarProducto(Producto producto) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default void borrarProducto(Long id) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default Producto guardarProducto(Producto producto) {
		throw new ServicioException("NO IMPLEMENTADO");
	}
}
