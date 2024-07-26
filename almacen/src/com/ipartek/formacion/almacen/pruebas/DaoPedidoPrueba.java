package com.ipartek.formacion.almacen.pruebas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.ipartek.formacion.almacen.accesodatos.DaoPedido;
import com.ipartek.formacion.almacen.accesodatos.FabricaGenerica;
import com.ipartek.formacion.almacen.entidades.LineaPedido;
import com.ipartek.formacion.almacen.entidades.Pedido;
import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoPedidoPrueba {
	private static final DaoPedido daoPedido = FabricaGenerica.getDaoPedido();

	public static void main(String[] args) {
//		nuevoPedido();

		Pedido pedido = daoPedido.obtenerPorId(4L);
		
		System.out.println(pedido);
		
		pedido.getLineas().forEach(System.out::println);
		
		System.out.println(pedido.getTotal());
	}

	@SuppressWarnings("unused")
	private static void nuevoPedido() {
		Set<LineaPedido> lineas = new HashSet<>();

		Producto producto1 = Producto.builder().id(1L).build();
		Producto producto2 = FabricaGenerica.getDaoProducto().obtenerPorId(2L);

		lineas.add(LineaPedido.builder().producto(producto1).build());
		lineas.add(LineaPedido.builder().producto(producto2).build());

		Pedido pedido = Pedido.builder().fecha(LocalDate.now()).lineas(lineas).build();

		daoPedido.insertar(pedido);
	}
}
