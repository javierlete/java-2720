package com.ipartek.formacion.iparshop.negocio;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.ipartek.formacion.iparshop.entidades.Producto;

import lombok.extern.java.Log;

@Log
public class UsuarioNegocioImpl implements UsuarioNegocio {

	// private static Logger log = Logger.getLogger(UsuarioNegocioImpl.class.getName());
	private TreeMap<Long, Producto> tm = new TreeMap<Long, Producto>();

	public UsuarioNegocioImpl() {
		var producto1 = Producto.builder().id(1L).nombre("Portátil").precio(new BigDecimal("1234.56")).build();
		var producto2 = Producto.builder().id(2L).nombre("Monitor").precio(new BigDecimal("234.56")).build();
		
		tm.put(producto1.getId(), producto1);
		tm.put(producto2.getId(), producto2);
	}
	
	@Override
	public Iterable<Producto> listarProductos() {
		log.info("Se ha pedido un listado de productos");
		
		return tm.values();
	}

	@Override
	public Producto detalleProducto(Long id) {
		log.info("Se ha pedido el producto " + id);
		
		return tm.get(id);
	}

}
