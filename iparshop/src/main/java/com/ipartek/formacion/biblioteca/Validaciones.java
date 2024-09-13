package com.ipartek.formacion.biblioteca;

import java.util.Set;
import java.util.TreeMap;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class Validaciones {
	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	public static TreeMap<String, String> validar(Object objeto) {
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(objeto);
		
		var errores = new TreeMap<String, String>(); 
		
		for(var error: constraintViolations) {
			errores.put(error.getPropertyPath().toString(), error.getMessage());
		}
		
		return errores;
	}
}
