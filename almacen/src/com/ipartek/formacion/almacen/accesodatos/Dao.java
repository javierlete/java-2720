package com.ipartek.formacion.almacen.accesodatos;

// Data Access Object
public interface Dao<T> {
	// CRUD: Create, Retrieve, Update, Delete
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("NO ESTÁ IMPLEMENTADO");
	}

	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("NO ESTÁ IMPLEMENTADO");
	}

	default T insertar(T o) {
		throw new AccesoDatosException("NO ESTÁ IMPLEMENTADO");
	}

	default T modificar(T o) {
		throw new AccesoDatosException("NO ESTÁ IMPLEMENTADO");
	}

	default void borrar(Long id) {
		throw new AccesoDatosException("NO ESTÁ IMPLEMENTADO");
	}
}
