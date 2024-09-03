package com.ipartek.formacion.iparshop.negocio;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ipartek.formacion.iparshop.entidades.Producto;

import lombok.extern.java.Log;

@Log
public class UsuarioNegocioAnteriorImpl implements UsuarioNegocio {

	// private static Logger log = Logger.getLogger(UsuarioNegocioImpl.class.getName());
	private ArrayList<Producto> al = new ArrayList<Producto>();

	public UsuarioNegocioAnteriorImpl() {
		var producto1 = Producto.builder().id(1L).nombre("Portátil").precio(new BigDecimal("1234.56")).build();
		var producto2 = Producto.builder().id(2L).nombre("Monitor").precio(new BigDecimal("234.56")).build();
		
		al.add(producto1);
		al.add(producto2);
	}
	
	@Override
	public Iterable<Producto> listarProductos() {
		log.info("Se ha pedido un listado de productos");
		
		return al;
	}

	@Override
	public Producto detalleProducto(Long id) {
		log.info("Se ha pedido el producto " + id);
		
		return al.stream().filter(p -> p.getId() == id).iterator().next();
	}

}
