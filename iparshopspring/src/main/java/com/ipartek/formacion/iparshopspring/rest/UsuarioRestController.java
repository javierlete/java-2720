package com.ipartek.formacion.iparshopspring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.iparshopspring.entidades.Producto;
import com.ipartek.formacion.iparshopspring.servicios.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping("/productos")
	public Iterable<Producto> listarProductos() {
		return servicio.listarProductos();
	}
}
