package com.ipartek.formacion.iparshop.modelos;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.ipartek.formacion.iparshop.entidades.Producto;

import lombok.Builder;
import lombok.Data;

public class Carrito {

	private TreeMap<Long, Linea> lineas = new TreeMap<>();

	public Iterable<Linea> getLineas() {
		return lineas.values();
	}
	
	public BigDecimal getTotal() {
//		BigDecimal total = BigDecimal.ZERO;
//		
//		for(Linea linea: lineas) {
//			BigDecimal totalParcial = linea.getTotal();
//			total = total.add(totalParcial);
//		}
//		
//		return total;
		
		return lineas.values().stream()
				.map(linea -> linea.getTotal())
				.reduce((totalParcial, total) -> total.add(totalParcial)).orElse(BigDecimal.ZERO);
	}

	public Linea agregarProducto(Producto producto, int cantidad) {
		Linea linea = null;
		
		if(lineas.containsKey(producto.getId())) {
			linea = lineas.get(producto.getId());
			linea.setCantidad(linea.getCantidad() + cantidad);
		} else {
			linea = Linea.builder().producto(producto).cantidad(cantidad).build();
			lineas.put(producto.getId(), linea);
		}
		
		return linea;
	}

	public Linea agregarProducto(Producto producto) {
		return agregarProducto(producto, 1);
	}

	@Data
	@Builder
	public static class Linea {
		private Producto producto;
		private Integer cantidad;
		
		public BigDecimal getTotal() {
			return producto.getPrecio().multiply(new BigDecimal(cantidad));
		}
	}
}
