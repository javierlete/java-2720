package com.ipartek.formacion.iparshopspring.servicios;

import java.util.TreeMap;

import com.ipartek.formacion.iparshopspring.entidades.Cliente;
import com.ipartek.formacion.iparshopspring.entidades.Factura;
import com.ipartek.formacion.iparshopspring.entidades.Producto;
import com.ipartek.formacion.iparshopspring.modelos.Carrito;

public interface UsuarioService {
	default Iterable<Producto> listarProductos() {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default Producto detalleProducto(Long id) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default Factura pedirFactura(Cliente cliente, Carrito carrito) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default Factura guardarFactura(Factura facturaProvisional) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default TreeMap<String, String> guardarCliente(Cliente cliente) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default Factura pedirFactura(long id) {
		throw new ServicioException("NO IMPLEMENTADO");
	}

	default Cliente autenticarCliente(String email, String password) {
		throw new ServicioException("NO IMPLEMENTADO");
	}
}
