package com.ipartek.formacion.almacen.presentacion;

import static com.ipartek.formacion.biblioteca.Consola.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.almacen.accesodatos.DaoProducto;
import com.ipartek.formacion.almacen.accesodatos.DaoProductoCsv;
import com.ipartek.formacion.almacen.entidades.Producto;

public class PresentacionConsola {
	private static final int SALIR = 0;

	private static final DaoProducto dao = new DaoProductoCsv("productos.csv");
	
	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private static void mostrarMenu() {
		pl("""
				1. Listado
				2. Buscar por id
				3. Añadir
				4. Modificar
				5. Borrar

				0. Salir
						""");

	}

	private static int pedirOpcion() {
		return leerInt("Elige una opción");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 0 -> pl("Adios muy buenas");
		case 1 -> listado();
		case 2 -> buscar();
		case 3 -> insertar();
		case 4 -> modificar();
		case 5 -> borrar();
		default -> pl("No reconozco esa opción");
		}
	}

	private static void listado() {
		for(var p: dao.obtenerTodos()) {
			mostrarLinea(p);
		}
	}

	private static void mostrarLinea(Producto p) {
		pl(p);
	}

	private static void buscar() {
		Long id = leerLong("Dime el id a buscar");
		
		var producto = dao.obtenerPorId(id);
		
		mostrarFicha(producto);
	}

	private static void mostrarFicha(Producto producto) {
		pl(producto);
	}

	private static void insertar() {
		var producto = leerProducto();
		
		dao.insertar(producto);
	}

	private static Producto leerProducto() {
		String nombre = leerString("Nombre", OBLIGATORIO);
		BigDecimal precio = leerBigDecimal("Precio", OBLIGATORIO, BigDecimal.ZERO);
		Integer stock = leerInt("Stock", OPCIONAL, 0);
		LocalDate fechaCaducidad = leerLocalDate("Fecha de caducidad", OPCIONAL, LocalDate.now());
		
		return new Producto(null, nombre, precio, stock, fechaCaducidad);
	}

	private static void modificar() {
		Long id = leerLong("Id");
		
		var producto = leerProducto();
		
		producto.setId(id);
		
		dao.modificar(producto);
	}

	private static void borrar() {
		Long id = leerLong("Id");
		
		dao.borrar(id);
	}
}
