package com.ipartek.formacion.almacen.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.almacen.accesodatos.DaoProducto;
import com.ipartek.formacion.almacen.accesodatos.DaoProductoSerializacion;
import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoPruebas {
	public static void main(String[] args) {
		DaoProducto dao = new DaoProductoSerializacion("productos.dat"); // new DaoProductoCsv("productos.csv"); // new
																			// DaoProductoTreeMap(); // new
																			// DaoProductoArrayList();

		dao.insertar(new Producto(null, "Producto 1", new BigDecimal("1234.56"), 15, null));
		dao.insertar(new Producto(null, "Producto 2", new BigDecimal("234.56"), 26, null));
		dao.insertar(new Producto(null, "Producto 3", new BigDecimal("34.56"), 37, null));
		dao.insertar(new Producto(null, "Producto 4", new BigDecimal("4.56"), 48, null));
		dao.insertar(Producto.builder().nombre("Producto 5").precio(new BigDecimal("54321")).stock(32).build());

		dao.modificar(new Producto(3L, "Modificado", new BigDecimal("3456.56"), 32, null));

		dao.borrar(2L);

		System.out.println("LISTADO DE TODOS LOS PRODUCTOS");

		for (Producto p : dao.obtenerTodos()) {
			System.out.println(p);
		}

		System.out.println("PRODUCTO 4");

		System.out.println(dao.obtenerPorId(4L));

		System.out.println("PRODUCTOS POR PRECIO");

		for (Producto p : dao.productosPorPrecio(new BigDecimal(100), new BigDecimal(10000))) {
			System.out.println(p);
		}

	}
}
