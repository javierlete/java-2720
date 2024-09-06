package com.ipartek.formacion.iparshop.modelos;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductoForm {
	@Pattern(regexp = "^\\d*$", message = "debe ser numérico")
	private String id;
	
	private String nombre;

	@Pattern(regexp = "^\\d+\\.?\\d*$", message = "debe ser un número con o sin decimales")
	private String precio;
	
	@Pattern(regexp = "^(\\d{4}\\-\\d{2}\\-\\d{2})?$", message = "debe ser una fecha en formato AAAA-MM-DD")
	private String fechaCaducidad;
	
	private String descripcion;
}
