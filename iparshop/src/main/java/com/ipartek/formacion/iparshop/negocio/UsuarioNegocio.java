package com.ipartek.formacion.iparshop.negocio;

import com.ipartek.formacion.iparshop.entidades.Producto;

public interface UsuarioNegocio {
	Iterable<Producto> listarProductos();
}
