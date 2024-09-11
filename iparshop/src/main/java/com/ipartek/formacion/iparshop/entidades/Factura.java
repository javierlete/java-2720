package com.ipartek.formacion.iparshop.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

@Entity
@Table(name = "facturas")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Pattern(regexp = "\\d{4}\\-\\d{8}")
	private String numero;

	@NotNull
	@Builder.Default
	private LocalDate fecha = LocalDate.now();

	@ManyToOne(optional = true)
	private Cliente cliente;

	@NotNull
	@NotBlank
	@Size(max = 100)
	private String nombreCliente;

	@NotNull
	@NotBlank
	@Size(max = 200)
	private String direccionCliente;

	@NotNull
	@NotBlank
	@Pattern(regexp = "\\d{5}")
	@Column(name = "codigo-postal", columnDefinition = "CHAR(5)")
	private String codigoPostalCliente;

	@NotNull
	@NotBlank
	@Size(max = 100)
	private String ciudadCliente;

	@NotNull
	@NotBlank
	@Pattern(regexp = "[XYZ\\d]\\d{7}[A-Z]")
	@Column(columnDefinition = "CHAR(9)")
	private String nifCliente;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<LineaFactura> lineas;

	@Entity
	@Table(name = "lineas-factura")
	public static class LineaFactura {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@ManyToOne
		private Producto producto;

		@NotNull
		@NotBlank
		@Size(max = 200)
		private String nombre;

		@NotNull(message = "es obligatorio rellenarlo")
		@Min(0)
		private BigDecimal precio;
		
		@NotNull
		@Min(0)
		private Integer cantidad;

		public BigDecimal getTotal() {
			return precio.multiply(new BigDecimal(cantidad));
		}
	}
}
