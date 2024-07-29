package com.ipartek.formacion.almacen.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "lineas_pedido")
public class LineaPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	private Pedido pedido;
	
	@NotNull
	@ManyToOne
	private Producto producto;
	
	@NotNull
	@Builder.Default
	private Integer cantidad = 1;
	
	public BigDecimal getTotal() {
		return producto.getPrecio().multiply(new BigDecimal(cantidad));
	}
}
