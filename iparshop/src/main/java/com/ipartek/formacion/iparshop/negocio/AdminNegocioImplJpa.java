package com.ipartek.formacion.iparshop.negocio;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Producto;

public class AdminNegocioImplJpa implements AdminNegocio {

	@Override
	public void agregarProducto(Producto producto) {
		Fabrica.getDaoProducto().insertar(producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
		Fabrica.getDaoProducto().modificar(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		Fabrica.getDaoProducto().borrar(id);
	}

}
