package com.ipartek.formacion.almacen.accesodatos;

import com.ipartek.formacion.almacen.entidades.Categoria;

public interface DaoCategoria extends Dao<Categoria> {
	default Iterable<Categoria> buscarPorNombre(String nombre) {
		throw new AccesoDatosException("NO ESTÁ IMPLEMENTADO");
	}
}
