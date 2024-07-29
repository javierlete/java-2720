package com.ipartek.formacion.almacen.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoSql<T> implements Dao<T> {
	private final String URL;
	private final String USER;
	private final String PASS;

	public DaoSql(String url, String user, String pass) {
		URL = url;
		USER = user;
		PASS = pass;
	}
	
	public Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar al origen de datos", e);
		}
	}
}
