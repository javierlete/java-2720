package com.ipartek.formacion.iparshop.negocio;

import java.util.HashSet;
import java.util.Set;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Cliente;
import com.ipartek.formacion.iparshop.entidades.Factura;
import com.ipartek.formacion.iparshop.entidades.Factura.LineaFactura;
import com.ipartek.formacion.iparshop.entidades.Producto;
import com.ipartek.formacion.iparshop.modelos.Carrito;

import lombok.extern.java.Log;

@Log
public class UsuarioNegocioImplJpa implements UsuarioNegocio {

	@Override
	public Iterable<Producto> listarProductos() {
		log.info("Se ha pedido un listado de productos");

		return Fabrica.getDaoProducto().obtenerTodos();
	}

	@Override
	public Producto detalleProducto(Long id) {
		log.info("Se ha pedido el producto " + id);

		return Fabrica.getDaoProducto().obtenerPorId(id);
	}

	@Override
	public Factura pedirFactura(Cliente cliente, Carrito carrito) {
		Factura.FacturaBuilder fb = Factura.builder();

		fb.cliente(cliente);

		fb.nombreCliente(cliente.getNombre());
		fb.direccionCliente(cliente.getDireccion());
		fb.codigoPostalCliente(cliente.getCodigoPostal());
		fb.ciudadCliente(cliente.getCiudad());
		fb.nifCliente(cliente.getNif());

		Factura.LineaFactura.LineaFacturaBuilder lfb;
		
		Set<LineaFactura> lineasFactura = new HashSet<>();
		
		for (var linea : carrito.getLineas()) {
			lfb = Factura.LineaFactura.builder();
			
			lfb.producto(linea.getProducto());
			lfb.nombre(linea.getProducto().getNombre());
			lfb.precio(linea.getProducto().getPrecio());
			lfb.cantidad(linea.getCantidad());
			
			lineasFactura.add(lfb.build());
		}
		
		fb.lineas(lineasFactura);
		
		fb.numero("2024-1234");
		
		return fb.build();
	}
}
