package oop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploJDBC {
	public static void main(String[] args) throws SQLException {
		final String URL = "jdbc:sqlite:sql/fichero.sqlite";
		final String USER = "no los";
		final String PASS = "usa";

		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement st = con.prepareStatement("SELECT * FROM usuarios");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			System.out.printf("%s, %s, %s\n", rs.getLong("id"), rs.getString("nombre"), rs.getString("password"));
		}

		String nombre = "otro nombre";
		String password = "otra password";

		PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios (nombre, password) VALUES (?,?)");
		
		pst.setString(1, nombre);
		pst.setString(2, password);
		
		int numeroRegistrosModificados = pst.executeUpdate();
		
		//int numeroRegistrosModificados = st
		//		.executeUpdate("INSERT INTO usuarios (nombre, password) VALUES ('" + nombre + "', '" + password + "')");

		System.out.println(numeroRegistrosModificados);
		
//		SELECT * FROM usuarios
//		SELECT * FROM usuarios WHERE id=ELNUMERO
//		INSERT INTO usuarios (nombre, password) VALUES ('elnombre', 'lapassword')
//		UPDATE usuarios SET nombre='elotronombre', password='laotrapassword' WHERE id=ELNUMERO
//		DELETE FROM usuarios WHERE id=ELNUMERO

	}
}
