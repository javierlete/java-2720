package com.ipartek.formacion.iparshop.accesodatos;

import com.ipartek.formacion.iparshop.entidades.Cliente;

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
}
