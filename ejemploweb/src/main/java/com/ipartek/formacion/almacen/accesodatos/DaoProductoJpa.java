package com.ipartek.formacion.almacen.accesodatos;

import java.math.BigDecimal;

import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoJpa extends DaoJpa implements DaoProducto {

	public DaoProductoJpa(String persistenceUnit, String noUtilizado1, String noUtilizado2) {
		super(persistenceUnit, null, null);
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return enTransaccion(em -> em.createQuery("select p from Producto p join fetch p.categoria", Producto.class).getResultList());
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return enTransaccion(em -> em.find(Producto.class, id));
	}

	@Override
	public Producto insertar(Producto producto) {
		return enTransaccion(em -> {
			em.persist(producto);
			return producto;
		});
	}

	@Override
	public Producto modificar(Producto producto) {
		return enTransaccion(em -> {
			em.merge(producto);
			return producto;
		});
	}

	@Override
	public void borrar(Long id) {
		enTransaccion(em -> {
			em.remove(em.find(Producto.class, id));
			return null;
		});
	}

	@Override
	public Iterable<Producto> productosPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		return enTransaccion(
				em -> em.createQuery("select p from Producto p where p.precio between :minimo and :maximo", Producto.class)
						.setParameter("minimo", minimo).setParameter("maximo", maximo).getResultList());
	}

	@Override
	public Iterable<Producto> productosPorIdCategoria(Long id) {
		return enTransaccion(em -> em.createQuery("select p from Producto p where p.categoria.id = :id", Producto.class)
				.setParameter("id", id).getResultList());
	}

}
