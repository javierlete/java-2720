package com.ipartek.formacion.almacen.presentacion;

import static com.ipartek.formacion.biblioteca.Consola.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.almacen.accesodatos.DaoCategoria;
import com.ipartek.formacion.almacen.accesodatos.DaoProducto;
import com.ipartek.formacion.almacen.accesodatos.FabricaGenerica;
import com.ipartek.formacion.almacen.entidades.Categoria;
import com.ipartek.formacion.almacen.entidades.Producto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class PresentacionConsola {
	private static final int SALIR = 0;

	private static final DaoProducto dao = FabricaGenerica.getDaoProducto();
	private static final DaoCategoria daoCategoria = FabricaGenerica.getDaoCategoria();

	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static final Validator validator = factory.getValidator();

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
				6. Buscar por categoría

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
		case 6 -> categoria();
		default -> pl("No reconozco esa opción");
		}
	}

	private static void listado() {
		for (var p : dao.obtenerTodos()) {
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
		String nombre;

		do {
			nombre = leerString("Nombre");
		} while (!validar("nombre", nombre));

		BigDecimal precio;
		do {
			precio = leerBigDecimal("Precio");
		} while (!validar("precio", precio));

		Integer stock;
		do {
			stock = leerInt("Stock", OPCIONAL);
		} while (!validar("stock", stock));

		LocalDate fechaCaducidad;
		do {
			fechaCaducidad = leerLocalDate("Fecha de caducidad", OPCIONAL);
		} while (!validar("fechaCaducidad", fechaCaducidad));

		listadoCategorias();

		Long idCategoria = leerLong("Id categoría");

		Categoria categoria = new Categoria(idCategoria, null, null);

		return new Producto(null, nombre, precio, stock, fechaCaducidad, categoria);
	}

	private static boolean validar(String nombreCampo, Object valorCampo) {
		var constraints = validator.validateValue(Producto.class, nombreCampo, valorCampo);
		
		if(constraints.size() > 0) {
			for(var constraint: constraints) {
				System.out.println(constraint.getMessage());
			}
			return false;
		}
		
		return true;
	}

	private static void listadoCategorias() {
		for (Categoria c : daoCategoria.obtenerTodos()) {
			System.out.println(c);
		}
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

	private static void categoria() {
		Long id = leerLong("Id categoría");

		Categoria categoria = daoCategoria.obtenerPorId(id);

		System.out.println(categoria);

		for (Producto p : categoria.getProductos()) {
			System.out.println(p);
		}
	}
}
