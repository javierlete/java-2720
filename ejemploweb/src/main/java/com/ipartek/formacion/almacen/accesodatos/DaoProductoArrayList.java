package com.ipartek.formacion.almacen.accesodatos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoArrayList implements DaoProducto {
	private final ArrayList<Producto> productos = new ArrayList<>();

	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos;
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Producto insertar(Producto producto) {
		Optional<Long> maxId = productos.stream().map(p -> p.getId()).max((id1, id2) -> id1.compareTo(id2));
		Long id = maxId.orElse(0L) + 1L;

		producto.setId(id);

		productos.add(producto);

		return producto;
	}

	@Override
	public Producto modificar(Producto productoModificado) {
//		if(productoModificado.getId() == null) {
//			throw new AccesoDatosException("Necesitamos el id a modificar");
//		}
//		
//		Producto productoOriginal = productos.stream().filter(p -> p.getId() == productoModificado.getId()).findFirst().orElse(null);
//		
//		if(productoOriginal == null) {
//			throw new AccesoDatosException("No se ha encontrado el producto a modificar");
//		}
//		
//		int posicion = productos.indexOf(productoOriginal);
//		
//		productos.set(posicion, productoModificado);

		productos.replaceAll(p -> p.getId() == productoModificado.getId() ? productoModificado : p);

		return productoModificado;
	}

	@Override
	public void borrar(Long id) {
		productos.removeIf(p -> p.getId() == id);
	}

	@Override
	public Iterable<Producto> productosPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		return productos.stream()
				.filter(p -> p.getPrecio().compareTo(minimo) >= 0 && p.getPrecio().compareTo(maximo) <= 0).toList();
	}

}
