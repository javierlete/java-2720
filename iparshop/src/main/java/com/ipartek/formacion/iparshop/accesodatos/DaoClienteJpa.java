package com.ipartek.formacion.iparshop.accesodatos;

import com.ipartek.formacion.iparshop.entidades.Cliente;

import jakarta.persistence.NoResultException;

public class DaoClienteJpa extends DaoJpa implements DaoCliente {

	public DaoClienteJpa() {
		super("com.ipartek.formacion.iparshop.entidades", null, null);
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		return enTransaccion(em -> {
			em.persist(cliente);
			return cliente;
		});
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		return enTransaccion(em -> {
			em.merge(cliente);
			return cliente;
		});
	}

	@Override
	public Cliente buscarPorEmail(String email) {
		return enTransaccion(em -> {
			try {
				return em.createQuery("select c from Cliente c where email=:email", Cliente.class).setParameter("email", email).getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
}
