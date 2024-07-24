package com.ipartek.formacion.almacen.accesodatos;

import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoJpa {
	private EntityManagerFactory entityManagerFactory;

	public DaoJpa(String persistenceUnit, String noUtilizado1, String noUtilizado2) {
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
	}

	protected <T> T enTransaccion(Function<EntityManager, T> codigo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			var resultado = codigo.apply(entityManager);
			transaction.commit();

			return resultado;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new AccesoDatosException("Ha habido un error en la operación JPA", e);
		} finally {
			entityManager.close();
		}
	}
}
