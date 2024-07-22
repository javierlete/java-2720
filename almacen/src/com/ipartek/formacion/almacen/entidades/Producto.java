package com.ipartek.formacion.almacen.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Producto implements Serializable {

	private static final long serialVersionUID = -5259817006588696574L;

	// VARIABLES DE INSTANCIA PRIVADAS
	private Long id;
	private String nombre;
	private Integer stock;
	private BigDecimal precio;
	private LocalDate fechaCaducidad;
	
	private Categoria categoria;

	// Generate constructor using fields...
	public Producto(Long id, String nombre, BigDecimal precio, Integer stock, LocalDate fechaCaducidad, Categoria categoria) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setStock(stock);
		setFechaCaducidad(fechaCaducidad);
		setCategoria(categoria);
	}
	
	public Producto(Long id, String nombre, BigDecimal precio, Integer stock, LocalDate fechaCaducidad) {
		this(id, nombre, precio, stock, fechaCaducidad, null);
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
		if(nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío");
		}
		
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		if(stock != null && stock < 0) {
			throw new IllegalArgumentException("No se admiten stocks negativos");
		}
		
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		if(precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("No se admiten precios menores que cero o inexistentes");
		}
		
		this.precio = precio;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		if(fechaCaducidad != null && fechaCaducidad.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La fecha de caducidad no puede ser anterior a la fecha actual");
		}

		this.fechaCaducidad = fechaCaducidad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
