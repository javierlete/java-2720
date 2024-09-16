package com.ipartek.formacion.iparshop.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Cliente;

class UsuarioNegocioTest {
	private static final UsuarioNegocio negocio = Fabrica.getUsuarioNegocio();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAutenticarCliente() {
		Cliente cliente = negocio.autenticarCliente("correo@incorrecto", "ni idea");
		
		assertNull(cliente);
		
		cliente = negocio.autenticarCliente("admin@email.net", "ni idea");
		
		assertNull(cliente);
		
		cliente = negocio.autenticarCliente("admin@email.net", "Pa$$w0rd");
		
		System.out.println(cliente);
		
		assertNotNull(cliente);
		
		assertEquals("Javier Lete", cliente.getNombre());
	}

}
