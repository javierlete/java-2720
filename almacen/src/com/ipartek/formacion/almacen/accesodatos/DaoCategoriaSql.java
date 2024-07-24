package com.ipartek.formacion.almacen.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.almacen.entidades.Categoria;
import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoCategoriaSql extends DaoSql<Categoria> implements DaoCategoria {

	private static final String SQL_SELECT = "SELECT id, nombre, descripcion FROM categorias";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_INSERT = "INSERT INTO categorias (nombre, descripcion) VALUES (?,?)";
	private static final String SQL_UPDATE = "UPDATE categorias SET nombre=?, descripcion=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM categorias WHERE id=?";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE nombre LIKE ?";

	public DaoCategoriaSql(String url, String user, String pass) {
		super(url, user, pass);
	}

	@Override
	public Iterable<Categoria> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Categoria> categorias = new ArrayList<>();
			Categoria categoria;

			while (rs.next()) {
				categoria = filaACategoria(rs);

				categorias.add(categoria);
			}

			return categorias;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Categoria obtenerPorId(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			Categoria categoria = null;

			if (rs.next()) {
				categoria = filaACategoria(rs);

				Iterable<Producto> resultado = FabricaGenerica.getDaoProducto().productosPorIdCategoria(id);

				var productos = categoria.getProductos();

				for (Producto p : resultado) {
					productos.add(p);
				}
			}

			return categoria;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro", e);
		}
	}

	@Override
	public Categoria insertar(Categoria categoria) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {
			categoriaAFila(categoria, pst);

			pst.executeUpdate();

			return categoria;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido cambiar los registros", e);
		}
	}

	@Override
	public Categoria modificar(Categoria categoria) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			categoriaAFila(categoria, pst);

			pst.executeUpdate();

			return categoria;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido cambiar los registros", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido cambiar los registros", e);
		}
	}

	@Override
	public Iterable<Categoria> buscarPorNombre(String nombre) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_NOMBRE);) {
			pst.setString(1, "%" + nombre + "%");

			ResultSet rs = pst.executeQuery();

			ArrayList<Categoria> categorias = new ArrayList<>();
			Categoria categoria;

			while (rs.next()) {
				categoria = filaACategoria(rs);

				categorias.add(categoria);
			}

			return categorias;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener los registros", e);
		}
	}

	private Categoria filaACategoria(ResultSet rs) throws SQLException {
		long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String descripcion = rs.getString("descripcion");

		return new Categoria(id, nombre, descripcion);
	}

	private void categoriaAFila(Categoria categoria, PreparedStatement pst) throws SQLException {
		pst.setString(1, categoria.getNombre());
		pst.setString(2, categoria.getDescripcion());

		if (categoria.getId() != null) {
			pst.setLong(3, categoria.getId());
		}
	}

}
