package com.ipartek.formacion.iparshop.negocio;

import com.ipartek.formacion.iparshop.entidades.Producto;

public interface AdminNegocio {

	void agregarProducto(Producto producto);

	void modificarProducto(Producto producto);

	void borrarProducto(Long id);
}
