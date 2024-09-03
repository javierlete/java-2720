package com.ipartek.formacion.iparshop.negocio;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Producto;

import lombok.extern.java.Log;

@Log
public class UsuarioNegocioImplJpa implements UsuarioNegocio {

	@Override
	public Iterable<Producto> listarProductos() {
		log.info("Se ha pedido un listado de productos");
		
		return Fabrica.getDaoProducto().obtenerTodos();
	}

	@Override
	public Producto detalleProducto(Long id) {
		log.info("Se ha pedido el producto " + id);
		
		return Fabrica.getDaoProducto().obtenerPorId(id);
	}

}
