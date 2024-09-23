package com.ipartek.formacion.iparshopspring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.iparshopspring.entidades.Producto;
import com.ipartek.formacion.iparshopspring.servicios.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/productos")
	public Iterable<Producto> listarProductos() {
		return adminService.listarProductos();
	}
	
	@GetMapping("/productos/{id}")
	public Producto detalleProducto(@PathVariable Long id) {
		var producto = adminService.detalleProducto(id);
		
		if(producto == null) {
			throw new ResourceNotFoundException();
		}
		
		return producto;
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto postProducto(@RequestBody Producto producto) {
		return adminService.agregarProducto(producto);
	}

	@PutMapping("/productos/{id}")
	public Producto putProducto(@RequestBody Producto producto, @PathVariable Long id) {
		if(id != producto.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id pedido y el id del producto deben ser el mismo");
		}
		
		return adminService.modificarProducto(producto);
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarProducto(@PathVariable Long id) {
		adminService.borrarProducto(id);
	}
}
