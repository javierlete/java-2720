package com.ipartek.formacion.iparshop.accesodatos;

import com.ipartek.formacion.iparshop.entidades.Factura;

import jakarta.persistence.NoResultException;

public class DaoFacturaJpa extends DaoJpa implements DaoFactura {

	public DaoFacturaJpa() {
		super("com.ipartek.formacion.iparshop.entidades", null, null);
	}

	@Override
	public Factura insertar(Factura factura) {
		return enTransaccion(em -> {
			em.persist(factura);
			return factura;
		});
	}

	@Override
	public String obtenerUltimoNumero() {
		return enTransaccion(em -> {
			String resultado;
			try {
				resultado = em.createQuery("select max(f.numero) from Factura f", String.class).getSingleResult();
				return resultado;
			} catch (NoResultException e) {
				return null;
			}
		});
	}

}
