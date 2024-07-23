package com.ipartek.formacion.almacen.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Producto implements Serializable {

	private static final long serialVersionUID = -5259817006588696574L;

	// VARIABLES DE INSTANCIA PRIVADAS
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Integer stock;
	private LocalDate fechaCaducidad;
	
	private Categoria categoria;
	
	public Producto(Long id, String nombre, BigDecimal precio, Integer stock, LocalDate fechaCaducidad) {
		this(id, nombre, precio, stock, fechaCaducidad, null);
	}
}
