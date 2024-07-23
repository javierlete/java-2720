package com.ipartek.formacion.almacen.entidades;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Categoria {
	private Long id;
	private String nombre;
	private String descripcion;

	private final ArrayList<Producto> productos = new ArrayList<>();
}
