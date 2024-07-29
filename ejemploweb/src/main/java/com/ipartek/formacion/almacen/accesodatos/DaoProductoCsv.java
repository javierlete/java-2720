package com.ipartek.formacion.almacen.accesodatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoCsv extends DaoProductoTreeMap implements DaoProducto {
	protected String path;

	public DaoProductoCsv(String path) {
		this.path = path;
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		leer();
		return super.obtenerTodos();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		leer();
		return super.obtenerPorId(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		leer();

		Producto p = super.insertar(producto);

		guardar();

		return p;
	}

	@Override
	public Producto modificar(Producto producto) {
		leer();

		Producto p = super.modificar(producto);

		guardar();

		return p;
	}

	@Override
	public void borrar(Long id) {
		leer();
		super.borrar(id);
		guardar();
	}

	@Override
	public Iterable<Producto> productosPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		leer();
		return super.productosPorPrecio(minimo, maximo);
	}

	protected void guardar() {
		try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
			for (Producto p : super.obtenerTodos()) {
				pw.printf("%s;%s;%s;%s;%s\n", p.getId(), p.getNombre(), p.getPrecio(), p.getStock(),
						p.getFechaCaducidad());
			}
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido guardar en fichero", e);
		}
	}

	protected void leer() {
		File f = new File(path);
		
		if(!f.exists()) {
			vaciar();
			guardar();
			return;
		}
		
		try (Scanner sc = new Scanner(new FileReader(path))) {
			vaciar();

			Producto p;
			String linea;
			String[] partes;

			while (sc.hasNext()) {
				linea = sc.nextLine();

				partes = linea.split(";");

				long id = Long.parseLong(partes[0]);
				String nombre = partes[1];
				BigDecimal precio = new BigDecimal(partes[2]);
				Integer stock = "null".equals(partes[3]) ? null : Integer.parseInt(partes[3]);
				LocalDate fechaCaducidad = "null".equals(partes[4]) ? null : LocalDate.parse(partes[4]);

				p = new Producto(id, nombre, precio, stock, fechaCaducidad);

				super.modificar(p);
			}
		} catch (NumberFormatException | FileNotFoundException e) {
			throw new AccesoDatosException("No se ha podido leer el fichero", e);
		}
	}
}
