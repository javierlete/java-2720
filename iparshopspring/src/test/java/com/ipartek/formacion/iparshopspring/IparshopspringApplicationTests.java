package com.ipartek.formacion.iparshopspring;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipartek.formacion.iparshopspring.entidades.Producto;
import com.ipartek.formacion.iparshopspring.repositorios.ProductoRepository;
import com.ipartek.formacion.iparshopspring.servicios.UsuarioService;

@SpringBootTest
class IparshopspringApplicationTests {

	@Autowired
	private ProductoRepository repo;
	
	@Test
	void pruebaRepositorios() {
//		repo.save(Producto.builder().nombre("Primero").precio(new BigDecimal("1234.56")).build());
		
		for(Producto p: repo.findByPrecioBetween(new BigDecimal(1000), new BigDecimal(2000))) {
			System.out.println(p);
		}
	}
	
	@Autowired
	private UsuarioService servicio;
	
	@Test
	void pruebaServicios() {
		for(Producto p: servicio.listarProductos()) {
			System.out.println(p);
		}
	}

}
