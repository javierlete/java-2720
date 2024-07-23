package com.ipartek.formacion.almacen.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.ipartek.formacion.almacen.entidades.Producto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidacionesPrueba {
	public static void main(String[] args) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Producto producto = new Producto(null, "adsf", new BigDecimal(1234), 6, LocalDate.of(2015, 1, 1));
        
        Set<ConstraintViolation<Producto>> constraintViolations = validator.validate(producto);
        
        if(constraintViolations.size() > 0) {
        	System.out.println("Hay errores");
        } else {
        	System.out.println("Limpia");
        }
        
        System.out.println(constraintViolations);
        
        for(ConstraintViolation<Producto> violation: constraintViolations) {
        	System.out.printf("%-10s: %s\n", violation.getPropertyPath(), violation.getMessage());
        }
        
        constraintViolations = validator.validateValue(Producto.class, "nombre", null);
        
        for(ConstraintViolation<Producto> violation: constraintViolations) {
        	System.out.printf("%-10s: %s\n", violation.getPropertyPath(), violation.getMessage());
        }

	}
}
