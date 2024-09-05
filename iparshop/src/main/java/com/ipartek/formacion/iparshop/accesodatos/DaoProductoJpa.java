package com.ipartek.formacion.iparshop.accesodatos;

import com.ipartek.formacion.iparshop.entidades.Producto;

public class DaoProductoJpa extends DaoJpa implements DaoProducto {

	public DaoProductoJpa() {
		super("com.ipartek.formacion.iparshop.entidades", "", "");
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return enTransaccion(em -> em.createQuery("select p from Producto p", Producto.class).getResultList());

//		return enTransaccion(new Function<EntityManager, List<Producto>>() {
//			@Override
//			public List<Producto> apply(EntityManager em) {
//				return em.createQuery("select p from Producto", Producto.class).getResultList();
//			}
//		});
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
}
