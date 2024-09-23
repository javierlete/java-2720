package com.ipartek.formacion.iparshopspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.iparshopspring.entidades.Producto;
import com.ipartek.formacion.iparshopspring.repositorios.ProductoRepository;

@Service
public class AdminServiceImpl extends UsuarioServiceImpl implements AdminService {

	@Autowired
	private ProductoRepository productoRepo;

	@Override
	public Producto agregarProducto(Producto producto) {
		if(producto.getId() != null) {
			throw new ServicioException("No se puede agregar un producto con id");
		}
		
		return productoRepo.save(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		if(producto.getId() == null) {
			throw new ServicioException("No se puede modificar un producto sin saber su id");
		}
		
		return productoRepo.save(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		if(id == null) {
			throw new ServicioException("No se puede borrar un producto sin saber su id");
		}
		
		productoRepo.deleteById(id);
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		if(producto.getId() != null) {
			return modificarProducto(producto);
		} else {
			return agregarProducto(producto);
		}
	}

}
