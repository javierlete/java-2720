package com.ipartek.formacion.iparshopspring.presentacion.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.iparshopspring.servicios.UsuarioService;

@Controller
public class IndexController {
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping("/")
	public String indice(Model modelo) {
		var productos = servicio.listarProductos();

		modelo.addAttribute("productos", productos);
		
		return "index";
	}
	
	@GetMapping("/detalle")
	public String detalle(Long id, Model modelo) {
		modelo.addAttribute("producto", servicio.detalleProducto(id));
		
		return "detalle";
	}
}