package com.ipartek.formacion.iparshop.negocio;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ipartek.formacion.iparshop.entidades.Producto;

import lombok.extern.java.Log;

@Log
public class UsuarioNegocioImpl implements UsuarioNegocio {

	@Override
	public Iterable<Producto> listarProductos() {
		log.info("Se ha pedido un listado de productos");
		
		var producto1 = Producto.builder().nombre("Portátil").precio(new BigDecimal("1234.56")).build();
		var producto2 = Producto.builder().nombre("Monitor").precio(new BigDecimal("234.56")).build();
		
		var al = new ArrayList<Producto>();
		al.add(producto1);
		al.add(producto2);
		
		return al;
	}

}
