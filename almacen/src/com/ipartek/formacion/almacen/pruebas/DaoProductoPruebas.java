package com.ipartek.formacion.almacen.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.almacen.accesodatos.DaoProducto;
import com.ipartek.formacion.almacen.accesodatos.DaoProductoCsv;
import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoPruebas {
	public static void main(String[] args) {
		DaoProducto dao = new DaoProductoCsv("productos.csv");

		dao.insertar(new Producto(null, "Producto 1", 15, new BigDecimal("1234.56"), null));
		dao.insertar(new Producto(null, "Producto 2", 26, new BigDecimal("234.56"), null));
		dao.insertar(new Producto(null, "Producto 3", 37, new BigDecimal("34.56"), null));
		dao.insertar(new Producto(null, "Producto 4", 48, new BigDecimal("4.56"), null));

		dao.modificar(new Producto(3L, "Modificado", 32, new BigDecimal("3456.56"), null));

		dao.borrar(2L);

		System.out.println("LISTADO DE TODOS LOS PRODUCTOS");
		
		for (Producto p : dao.obtenerTodos()) {
			System.out.println(p);
		}

		System.out.println("PRODUCTO 4");
		
		System.out.println(dao.obtenerPorId(4L));

		System.out.println("PRODUCTOS POR PRECIO");
		
		for(Producto p: dao.productosPorPrecio(new BigDecimal(100), new BigDecimal(10000))) {
			System.out.println(p);
		}

	}
}
