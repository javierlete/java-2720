package com.ipartek.formacion.iparshop.negocio;

import java.util.TreeMap;

import com.ipartek.formacion.iparshop.entidades.Cliente;
import com.ipartek.formacion.iparshop.entidades.Factura;
import com.ipartek.formacion.iparshop.entidades.Producto;
import com.ipartek.formacion.iparshop.modelos.Carrito;

public interface UsuarioNegocio {
	Iterable<Producto> listarProductos();

	Producto detalleProducto(Long id);

	default Factura pedirFactura(Cliente cliente, Carrito carrito) {
		throw new NegocioException("NO IMPLEMENTADO");
	}

	default Factura guardarFactura(Factura facturaProvisional) {
		throw new NegocioException("NO IMPLEMENTADO");
	}

	default TreeMap<String, String> guardarCliente(Cliente cliente) {
		throw new NegocioException("NO IMPLEMENTADO");
	}

	default Factura pedirFactura(long id) {
		throw new NegocioException("NO IMPLEMENTADO");
	}

	default Cliente autenticarCliente(String email, String password) {
		throw new NegocioException("NO IMPLEMENTADO");
	}
}
