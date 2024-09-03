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
}
