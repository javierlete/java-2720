package com.ipartek.formacion.almacen.accesodatos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoSqliteLambda extends DaoSql<Producto> implements DaoProducto {
	private static final String SQL_SELECT = "SELECT id, nombre, precio, stock, fecha_caducidad FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_SELECT_PRECIO = SQL_SELECT + " WHERE precio BETWEEN ? AND ?";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, stock, fecha_caducidad) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, stock=?, fecha_caducidad=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	public DaoProductoSqliteLambda(String url, String user, String pass) {
		super(url, user, pass);
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return ejecutarConsulta(SQL_SELECT, pst -> {
		});
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return ejecutarConsultaUno(SQL_SELECT_ID, pst -> pst.setLong(1, id));
	}
	
//	public Producto obtenerPorIdSinLambda(Long id) {
//		return ejecutarConsultaUno(SQL_SELECT_ID, new Codigo<PreparedStatement>() {
//			@Override
//			public void ejecutar(PreparedStatement pst) throws SQLException {
//				pst.setLong(1, id);
//			}
//		});
//	}

	@Override
	public Producto insertar(Producto producto) {
		ejecutarCambio(SQL_INSERT, pst -> productoAFila(producto, pst));
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		ejecutarCambio(SQL_UPDATE, pst -> productoAFila(producto, pst));
		return producto;
	}

	@Override
	public void borrar(Long id) {
		ejecutarCambio(SQL_DELETE, pst -> pst.setLong(1, id));
	}

	@Override
	public Iterable<Producto> productosPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		return ejecutarConsulta(SQL_SELECT_PRECIO, pst -> {
			pst.setBigDecimal(1, minimo);
			pst.setBigDecimal(2, maximo);
		});
	}

	private void ejecutarCambio(String sql, Codigo lambda) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(sql);) {
			lambda.ejecutar(pst);

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido cambiar el registro", e);
		}
	}

	private Iterable<Producto> ejecutarConsulta(String sql, Codigo lambda) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(sql);) {
			lambda.ejecutar(pst);

			ArrayList<Producto> productos = new ArrayList<>();
			Producto producto;

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					producto = filaAProducto(rs);

					productos.add(producto);
				}
			}
			
			return productos;

		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener los registros", e);
		}
	}

	private Producto ejecutarConsultaUno(String sql, Codigo codigo) {
		Iterable<Producto> productos = ejecutarConsulta(sql, codigo);

		return productos.iterator().hasNext() ? productos.iterator().next() : null;
	}

	@FunctionalInterface
	private interface Codigo {
		void ejecutar(PreparedStatement pst) throws SQLException;
	}

	private Producto filaAProducto(ResultSet rs) throws SQLException {
		long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		BigDecimal precio = rs.getBigDecimal("precio");
		Integer stock = rs.getObject("stock") != null ? rs.getInt("stock") : null;
		LocalDate fechaCaducidad = rs.getDate("fecha_caducidad") != null ? rs.getDate("fecha_caducidad").toLocalDate()
				: null;
		
		return new Producto(id, nombre, precio, stock, fechaCaducidad);
	}

	private void productoAFila(Producto producto, PreparedStatement pst) throws SQLException {
		pst.setString(1, producto.getNombre());
		pst.setBigDecimal(2, producto.getPrecio());
		pst.setObject(3, producto.getStock());
		pst.setDate(4,
				producto.getFechaCaducidad() != null ? java.sql.Date.valueOf(producto.getFechaCaducidad()) : null);

		if (producto.getId() != null) {
			pst.setLong(5, producto.getId());
		}
	}

}
