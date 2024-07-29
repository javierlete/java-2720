package com.ipartek.formacion.almacen.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoTreeMap implements DaoProducto {
	protected TreeMap<Long, Producto> productos = new TreeMap<>();

	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productos.get(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		Long id = productos.size() > 0 ? productos.lastKey() + 1L: 1L;
		
		producto.setId(id);
		
		productos.put(id, producto);
		
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		productos.put(producto.getId(), producto);
		
		return producto;
	}

	@Override
	public void borrar(Long id) {
		productos.remove(id);
	}

	@Override
	public Iterable<Producto> productosPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		return productos.values().stream().filter(p -> p.getPrecio().compareTo(minimo) >= 0 && p.getPrecio().compareTo(maximo) <= 0).toList();
	}
	
	protected void vaciar() {
		productos.clear();
	}
	
}
