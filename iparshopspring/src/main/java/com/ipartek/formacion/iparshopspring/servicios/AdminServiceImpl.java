package com.ipartek.formacion.iparshopspring.servicios;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.iparshopspring.entidades.Producto;
import com.ipartek.formacion.iparshopspring.repositorios.ProductoRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ProductoRepository productoRepo;
	
	@Override
	public TreeMap<String, String> guardarProducto(Producto producto) {
		productoRepo.save(producto);
		
		return null;
	}
	
}
