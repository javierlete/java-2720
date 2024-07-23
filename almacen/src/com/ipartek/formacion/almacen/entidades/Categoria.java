package com.ipartek.formacion.almacen.entidades;

import java.util.ArrayList;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Categoria {
	@Min(0)
	private Long id;

	@NotNull
	@NotBlank
	private String nombre;

	@NotBlank
	private String descripcion;

	private final ArrayList<Producto> productos = new ArrayList<>();
}
