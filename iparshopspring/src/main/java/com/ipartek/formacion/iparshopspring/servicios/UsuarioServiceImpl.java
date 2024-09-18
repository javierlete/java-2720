package com.ipartek.formacion.iparshopspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.iparshopspring.entidades.Producto;
import com.ipartek.formacion.iparshopspring.repositorios.ProductoRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private ProductoRepository productoRepo;
	
	@Override
	public Iterable<Producto> listarProductos() {
		return productoRepo.findAll();
	}
}
