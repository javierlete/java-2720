package com.ipartek.formacion.iparshop.negocio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Cliente;
import com.ipartek.formacion.iparshop.entidades.Factura;
import com.ipartek.formacion.iparshop.entidades.Factura.LineaFactura;
import com.ipartek.formacion.iparshop.entidades.Producto;
import com.ipartek.formacion.iparshop.modelos.Carrito;

import lombok.extern.java.Log;
import static com.ipartek.formacion.biblioteca.Validaciones.*;

@Log
public class UsuarioNegocioImplJpa implements UsuarioNegocio {

	@Override
	public TreeMap<String, String> guardarCliente(Cliente cliente) {
		var errores = validar(cliente);
		
		if(errores.size() > 0) {
			return errores;
		}
		
		if(cliente.getId() == null) {
			Fabrica.getDaoCliente().insertar(cliente);
		} else {
			Fabrica.getDaoCliente().modificar(cliente);
		}
		
		return errores;
	}

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
		
		fb.numero("FACTURA PRO FORMA");
		
		return fb.build();
	}

	@Override
	public Factura pedirFactura(long id) {
		return Fabrica.getDaoFactura().obtenerPorId(id);
	}

	@Override
	public synchronized Factura guardarFactura(Factura facturaProvisional) {
		
		var factura = facturaProvisional;
		
		var numero = siguienteNumero();

		factura.setNumero(numero);
		
		return Fabrica.getDaoFactura().insertar(factura);
	}
	
	@Override
	public Cliente autenticarCliente(String email, String password) {
		Cliente cliente = Fabrica.getDaoCliente().buscarPorEmail(email);
		
		if(cliente != null && cliente.getPassword().equals(password)) {
			return cliente;
		}
		
		return null;
	}

	private String siguienteNumero() {
		String numero = null;

		var anyoActual = LocalDate.now().getYear();
		
		String ultimoNumero = Fabrica.getDaoFactura().obtenerUltimoNumero();

		// No facturas todavía
		if(ultimoNumero == null) {
			numero = formatearNumero(anyoActual, 1);
			return numero;
		}
		
		// Sí hay facturas
		var partes = ultimoNumero.split("-");
		
		var anyo = Integer.parseInt(partes[0]);
		var serie = Integer.parseInt(partes[1]);
		
		// El año de la última factura no es el actual
		if(anyoActual != anyo) {
			numero = formatearNumero(anyoActual, 1);
			return numero;
		}
		
		// El año de la última factura es el actual
		numero = formatearNumero(anyo, ++serie);
		
		return numero;
	}

	private String formatearNumero(int anyo, int serie) {
		return String.format("%d-%08d", anyo, serie);
	}
}
