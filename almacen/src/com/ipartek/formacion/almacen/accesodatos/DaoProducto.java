package com.ipartek.formacion.almacen.accesodatos;

import java.math.BigDecimal;

import com.ipartek.formacion.almacen.entidades.Producto;

public interface DaoProducto extends Dao<Producto> {
	default Iterable<Producto> productosPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		throw new AccesoDatosException("NO ESTÁ IMPLEMENTADO");
	}
	
	default Iterable<Producto> productosPorIdCategoria(Long id) {
		throw new AccesoDatosException("NO ESTÁ IMPLEMENTADO");
	}
}
