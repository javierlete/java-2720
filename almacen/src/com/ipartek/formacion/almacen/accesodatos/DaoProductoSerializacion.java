package com.ipartek.formacion.almacen.accesodatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoSerializacion extends DaoProductoCsv implements DaoProducto {

	public DaoProductoSerializacion(String path) {
		super(path);
	}

	@Override
	protected void guardar() {
		try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(productos);
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido escribir el fichero", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void leer() {
		File f = new File(path);

		if (!f.exists()) {
			vaciar();
			guardar();
			return;
		}

		try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)) {
			productos = (TreeMap<Long, Producto>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new AccesoDatosException("No se ha podido leer del fichero", e);
		}
	}

}
