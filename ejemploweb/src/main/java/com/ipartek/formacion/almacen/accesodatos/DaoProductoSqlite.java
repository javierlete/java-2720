package com.ipartek.formacion.almacen.accesodatos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartek.formacion.almacen.entidades.Categoria;
import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoSqlite extends DaoSql<Producto> implements DaoProducto {

	private static final String SQL_SELECT = """
					SELECT *
					FROM productos p
					JOIN categorias c ON c.id = p.categorias_id
			""";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE p.id=?";
	private static final String SQL_SELECT_PRECIO = SQL_SELECT + " WHERE p.precio BETWEEN ? AND ?";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, stock, fecha_caducidad, categorias_id) VALUES (?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, stock=?, fecha_caducidad=?, categorias_id=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";
	private static final String SQL_SELECT_CATEGORIA = SQL_SELECT + " WHERE p.categorias_id = ?";

	public DaoProductoSqlite(String url, String user, String pass) {
		super(url, user, pass);
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Producto> productos = new ArrayList<>();
			Producto producto;

			while (rs.next()) {
				producto = filaAProducto(rs);

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Producto obtenerPorId(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			Producto producto = null;

			if (rs.next()) {
				producto = filaAProducto(rs);
			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener el registro", e);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {
			productoAFila(producto, pst);

			pst.executeUpdate();

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido cambiar los registros", e);
		}
	}

	@Override
	public Producto modificar(Producto producto) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			productoAFila(producto, pst);

			pst.executeUpdate();

			return producto;
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
	public Iterable<Producto> productosPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_PRECIO);) {
			pst.setBigDecimal(1, minimo);
			pst.setBigDecimal(2, maximo);

			ResultSet rs = pst.executeQuery();

			ArrayList<Producto> productos = new ArrayList<>();
			Producto producto;

			while (rs.next()) {
				producto = filaAProducto(rs);

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener los registros", e);
		}
	}

	@Override
	public Iterable<Producto> productosPorIdCategoria(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_CATEGORIA);) {
			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			ArrayList<Producto> productos = new ArrayList<>();
			Producto producto;

			while (rs.next()) {
				producto = filaAProducto(rs);

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener los registros", e);
		}
		
	}

	private Producto filaAProducto(ResultSet rs) throws SQLException {
		long id = rs.getLong("p.id");
		String nombre = rs.getString("p.nombre");
		BigDecimal precio = rs.getBigDecimal("p.precio");
		Integer stock = rs.getObject("p.stock") != null ? rs.getInt("p.stock") : null;
		LocalDate fechaCaducidad = rs.getDate("p.fecha_caducidad") != null
				? rs.getDate("p.fecha_caducidad").toLocalDate()
				: null;

		Categoria categoria = new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"),
				rs.getString("c.descripcion"));

		return new Producto(id, nombre, precio, stock, fechaCaducidad, categoria);
	}

	private void productoAFila(Producto producto, PreparedStatement pst) throws SQLException {
		pst.setString(1, producto.getNombre());
		pst.setBigDecimal(2, producto.getPrecio());
		pst.setObject(3, producto.getStock());
		pst.setDate(4,
				producto.getFechaCaducidad() != null ? java.sql.Date.valueOf(producto.getFechaCaducidad()) : null);
		pst.setLong(5, producto.getCategoria().getId());
		
		if (producto.getId() != null) {
			pst.setLong(6, producto.getId());
		}
	}

}
