package com.ipartek.formacion.almacen.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Producto implements Serializable {

	private static final long serialVersionUID = -5259817006588696574L;

	@Min(0)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nombre;
	
	@NotNull
	@Min(0)
	private BigDecimal precio;
	
	@Min(0)
	private Integer stock;
	
	@FutureOrPresent(message = "debe ser posterior o igual a la actual")
	private LocalDate fechaCaducidad;
	
	private Categoria categoria;
	
	public Producto(Long id, String nombre, BigDecimal precio, Integer stock, LocalDate fechaCaducidad) {
		this(id, nombre, precio, stock, fechaCaducidad, null);
	}
}
