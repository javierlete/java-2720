package com.ipartek.formacion.almacen.accesodatos;

import java.io.IOException;
import java.util.Properties;

public class Fabrica {
	private static DaoProducto daoProducto;

	static {
		try {
			Properties props = new Properties();
			props.load(Fabrica.class.getClassLoader().getResourceAsStream("almacen.properties"));

			String motor = props.getProperty("dao.producto.motor");
			String url = props.getProperty("dao.producto.url");
			String user = props.getProperty("dao.producto.user");
			String pass = props.getProperty("dao.producto.pass");

			daoProducto = switch (motor) {
			case "arraylist" -> new DaoProductoArrayList();
			case "treemap" -> new DaoProductoTreeMap();
			case "csv" -> new DaoProductoCsv(url);
			case "serializacion" -> new DaoProductoSerializacion(url);
			case "sqlite" -> new DaoProductoSqlite("jdbc:sqlite:" + url, user, pass);
			case "sqlitelambda" -> new DaoProductoSqliteLambda("jdbc:sqlite:" + url, user, pass);
			default -> null;
			};
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido leer la configuración del acceso a datos", e);
		}
	}

	public static DaoProducto getDaoProducto() {
		return daoProducto;
	}
}
