package com.ipartek.formacion.almacen.accesodatos;

import java.util.Properties;

public class FabricaGenerica {
	private static DaoProducto daoProducto;

	static {
		try {
			Properties props = new Properties();
			props.load(FabricaGenerica.class.getClassLoader().getResourceAsStream("almacengenerico.properties"));

			String motor = props.getProperty("dao.producto.motor");
			String url = props.getProperty("dao.producto.url");
			String user = props.getProperty("dao.producto.user");
			String pass = props.getProperty("dao.producto.pass");

			daoProducto = (DaoProducto) Class.forName(motor).getConstructor(String.class, String.class, String.class).newInstance(url,
					user, pass);
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido leer la configuración del acceso a datos", e);
		}
	}

	public static DaoProducto getDaoProducto() {
		return daoProducto;
	}
}
