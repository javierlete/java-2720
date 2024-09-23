package com.ipartek.formacion.iparshopspring.presentacion.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.iparshopspring.entidades.Producto;
import com.ipartek.formacion.iparshopspring.servicios.AdminService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/productos")
	public String productos(Model modelo) {
		modelo.addAttribute("productos", adminService.listarProductos());
		return "admin/productos";
	}
	
	@GetMapping("/producto") 
	public String producto(Long id, Model modelo) {
		
		if(id != null) {
			modelo.addAttribute("producto", adminService.detalleProducto(id));
		} else {
			modelo.addAttribute("producto", new Producto());
		}
		
		return "admin/producto";
	}
	
	@PostMapping("/producto")
	public String productoPost(@Valid Producto producto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "admin/producto";
		}
		
		adminService.guardarProducto(producto);
		
		return "redirect:/admin/productos";
	}
	
	@GetMapping("/productos/borrar")
	public String productoBorrar(Long id) {
		adminService.borrarProducto(id);
		
		return "redirect:/admin/productos";
	}
}
