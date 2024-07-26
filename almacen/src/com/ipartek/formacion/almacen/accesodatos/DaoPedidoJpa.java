package com.ipartek.formacion.almacen.accesodatos;

import com.ipartek.formacion.almacen.entidades.LineaPedido;
import com.ipartek.formacion.almacen.entidades.Pedido;

public class DaoPedidoJpa extends DaoJpa implements DaoPedido {

	public DaoPedidoJpa(String persistenceUnit, String noUtilizado1, String noUtilizado2) {
		super(persistenceUnit, noUtilizado1, noUtilizado2);
	}

	@Override
	public Iterable<Pedido> obtenerTodos() {
		return enTransaccion(em -> em.createQuery("select p from Pedido p", Pedido.class).getResultList());
	}

	@Override
	public Pedido obtenerPorId(Long id) {
		return enTransaccion(
				em -> em.createQuery("select p from Pedido p join fetch p.lineas l join fetch l.producto pr join fetch pr.categoria where p.id = :id", Pedido.class)
						.setParameter("id", id).getSingleResult());
	}

	@Override
	public Pedido insertar(Pedido pedido) {
		return enTransaccion(em -> {
			em.persist(pedido);

			for (LineaPedido linea : pedido.getLineas()) {
				linea.setPedido(pedido);
				em.persist(linea);
			}

			return pedido;
		});
	}

	@Override
	public Pedido modificar(Pedido pedido) {
		return enTransaccion(em -> {
			em.merge(pedido);
			return pedido;
		});
	}

	@Override
	public void borrar(Long id) {
		enTransaccion(em -> {
			em.remove(em.find(Pedido.class, id));
			return null;
		});
	}
}
