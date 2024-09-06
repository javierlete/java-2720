package com.ipartek.formacion.iparshop.negocio;

import java.util.Set;
import java.util.TreeMap;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Producto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class AdminNegocioImplJpa implements AdminNegocio {

	@Override
	public void agregarProducto(Producto producto) {
		Fabrica.getDaoProducto().insertar(producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
		Fabrica.getDaoProducto().modificar(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		Fabrica.getDaoProducto().borrar(id);
	}
	
	@Override
	public TreeMap<String, String> validarProducto(Producto producto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Producto>> constraintViolations = validator.validate(producto);
		
		var errores = new TreeMap<String, String>(); 
		
		for(var error: constraintViolations) {
			errores.put(error.getPropertyPath().toString(), error.getMessage());
		}
		return errores;
	}

	@Override
	public TreeMap<String, String> guardarProducto(Producto producto) {
		var errores = validarProducto(producto);
		
		if(errores.size() == 0) {
			if (producto.getId() == null) {
				agregarProducto(producto);
			} else {
				modificarProducto(producto);
			}
		}
		
		return errores;
	}

}
