package com.ipartek.formacion.almacen.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private LocalDate fecha;

//	@ManyToMany
//	private Set<Producto> productos;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "pedido")
	private Set<LineaPedido> lineas;

	public BigDecimal getTotal() {
//		BigDecimal total = BigDecimal.ZERO;
//
//		for (LineaPedido linea : lineas) {
//			total = total.add(linea.getTotal());
//		}
//
//		return total;

		return lineas.stream().map(linea -> linea.getTotal()).reduce(BigDecimal.ZERO,
				(total, subtotal) -> total.add(subtotal));
	}
}
