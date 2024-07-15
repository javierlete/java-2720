package com.ipartek.formacion.almacen.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Producto {
	// VARIABLES DE INSTANCIA PRIVADAS
	private Long id;
	private String nombre;
	private Integer stock;
	private BigDecimal precio;
	private LocalDate fechaCaducidad;

	// Generate constructor using fields...
	public Producto(Long id, String nombre, Integer stock, BigDecimal precio, LocalDate fechaCaducidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.fechaCaducidad = fechaCaducidad;
	}
	
	// Generate getters and setters...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	// Generate hashCode and equals...
	@Override
	public int hashCode() {
		return Objects.hash(fechaCaducidad, id, nombre, precio, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(fechaCaducidad, other.fechaCaducidad) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio)
				&& Objects.equals(stock, other.stock);
	}

	// Generate toString...
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio
				+ ", fechaCaducidad=" + fechaCaducidad + "]";
	}

}
