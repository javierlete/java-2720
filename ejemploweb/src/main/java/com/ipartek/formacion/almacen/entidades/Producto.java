package com.ipartek.formacion.almacen.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	private static final long serialVersionUID = -5259817006588696574L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(max = 50)
	private String nombre;
	
	@NotNull
	@Min(0)
	private BigDecimal precio;
	
	@Min(0)
	private Integer stock;
	
	@FutureOrPresent(message = "debe ser posterior o igual a la actual")
	@Column(name = "fecha_caducidad")
	private LocalDate fechaCaducidad;
	
	@ManyToOne
	private Categoria categoria;
	
	public Producto(Long id, String nombre, BigDecimal precio, Integer stock, LocalDate fechaCaducidad) {
		this(id, nombre, precio, stock, fechaCaducidad, null);
	}
}
