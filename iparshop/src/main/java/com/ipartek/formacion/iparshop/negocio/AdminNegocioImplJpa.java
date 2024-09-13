package com.ipartek.formacion.iparshop.negocio;

import static com.ipartek.formacion.biblioteca.Validaciones.*
;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.TreeMap;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Producto;
import com.ipartek.formacion.iparshop.modelos.ProductoForm;

public class AdminNegocioImplJpa implements AdminNegocio {
	
	@Override
	public void agregarProducto(Producto producto) {
		Fabrica.getDaoProducto().insertar(producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
		Fabrica.getDaoProducto().modificar(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		Fabrica.getDaoProducto().borrar(id);
	}
	
	@Override
	public TreeMap<String, String> validarProducto(Producto producto) {
		return validar(producto);
	}

	@Override
	public TreeMap<String, String> guardarProducto(Producto producto) {
		var errores = validarProducto(producto);
		
		if(errores.size() == 0) {
			if (producto.getId() == null) {
				agregarProducto(producto);
			} else {
				modificarProducto(producto);
			}
		}
		
		return errores;
	}

	@Override
	public TreeMap<String, String> guardarProducto(ProductoForm productoForm) {
		var errores = validarProducto(productoForm);
		
		if(errores.size() > 0) {
			return errores;
		}
		
		var producto = productoFormAProducto(productoForm);
		
		return guardarProducto(producto);
	}

	@Override
	public TreeMap<String, String> validarProducto(ProductoForm productoForm) {
		
		var errores = validar(productoForm);
		
		if(errores.size() > 0) {
			return errores;
		}
		
		var producto = productoFormAProducto(productoForm);
		
		return validarProducto(producto);
	}

	private Producto productoFormAProducto(ProductoForm productoForm) {
		Long id = !productoForm.getId().isBlank() ? Long.parseLong(productoForm.getId()) : null;
		BigDecimal precio = !productoForm.getPrecio().isBlank() ? new BigDecimal(productoForm.getPrecio()) : null;
		LocalDate fechaCaducidad = !productoForm.getFechaCaducidad().isBlank() ? LocalDate.parse(productoForm.getFechaCaducidad()) : null;
		
		var producto = Producto.builder().id(id).nombre(productoForm.getNombre()).precio(precio).fechaCaducidad(fechaCaducidad)
				.descripcion(productoForm.getDescripcion()).build();
		return producto;
	}

}
