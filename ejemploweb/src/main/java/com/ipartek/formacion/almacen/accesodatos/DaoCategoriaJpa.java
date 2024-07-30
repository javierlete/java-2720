package com.ipartek.formacion.almacen.accesodatos;

import com.ipartek.formacion.almacen.entidades.Categoria;

public class DaoCategoriaJpa extends DaoJpa implements DaoCategoria {

	public DaoCategoriaJpa(String persistenceUnit, String noUtilizado1, String noUtilizado2) {
		super(persistenceUnit, noUtilizado1, noUtilizado2);
	}

	@Override
	public Iterable<Categoria> obtenerTodos() {
		return enTransaccion(em -> em.createQuery("select c from Categoria c", Categoria.class).getResultList());
	}

	@Override
	public Categoria obtenerPorId(Long id) {
		return enTransaccion(em -> em.createQuery("select c from Categoria c left join fetch c.productos where c.id = ?1", Categoria.class).setParameter(1, id).getSingleResult());
	}

	@Override
	public Categoria insertar(Categoria categoria) {
		return enTransaccion(em -> {
			em.persist(categoria);
			return categoria;
		});
	}

	@Override
	public Categoria modificar(Categoria categoria) {
		return enTransaccion(em -> {
			em.merge(categoria);
			return categoria;
		});
	}

	@Override
	public void borrar(Long id) {
		enTransaccion(em -> {
			em.remove(em.find(Categoria.class, id));
			return null;
		});
	}

	@Override
	public Iterable<Categoria> buscarPorNombre(String nombre) {
		return enTransaccion(em -> em.createQuery("select c from Categoria c where nombre like ?", Categoria.class)
				.setParameter(1, "%" + nombre + "%").getResultList());
	}

}
