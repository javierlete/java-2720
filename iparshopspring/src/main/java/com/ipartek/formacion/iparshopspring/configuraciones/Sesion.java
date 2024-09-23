package com.ipartek.formacion.iparshopspring.configuraciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ipartek.formacion.iparshopspring.modelos.Carrito;

@ControllerAdvice
@Configuration
public class Sesion {
	@Autowired
	private Carrito carrito;
	
	@ModelAttribute
	private void carrito(Model modelo) {
		modelo.addAttribute("carrito", carrito);
	}
}
