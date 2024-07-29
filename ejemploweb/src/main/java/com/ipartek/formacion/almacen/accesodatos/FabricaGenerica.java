package com.ipartek.formacion.almacen.accesodatos;

import java.util.Properties;

public class FabricaGenerica {
	private static DaoProducto daoProducto;
	private static DaoCategoria daoCategoria;
	private static DaoPedido daoPedido;

	static {
		try {
			Properties props = new Properties();
			props.load(FabricaGenerica.class.getClassLoader().getResourceAsStream("almacengenerico.properties"));

			String url = props.getProperty("dao.url");
			String user = props.getProperty("dao.user");
			String pass = props.getProperty("dao.pass");

			String motorProducto = props.getProperty("dao.producto.motor");
			String motorCategoria = props.getProperty("dao.categoria.motor");
			String motorPedido = props.getProperty("dao.pedido.motor");

			daoProducto = (DaoProducto) Class.forName(motorProducto).getConstructor(String.class, String.class, String.class).newInstance(url,
					user, pass);
			daoCategoria = (DaoCategoria) Class.forName(motorCategoria).getConstructor(String.class, String.class, String.class).newInstance(url,
					user, pass);
			daoPedido = (DaoPedido) Class.forName(motorPedido).getConstructor(String.class, String.class, String.class).newInstance(url,
					user, pass);
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido leer la configuración del acceso a datos", e);
		}
	}

	public static DaoProducto getDaoProducto() {
		return daoProducto;
	}

	public static DaoCategoria getDaoCategoria() {
		return daoCategoria;
	}

	public static DaoPedido getDaoPedido() {
		return daoPedido;
	}
}
