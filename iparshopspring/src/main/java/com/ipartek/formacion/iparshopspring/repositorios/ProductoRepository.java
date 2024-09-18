package com.ipartek.formacion.iparshopspring.repositorios;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.iparshopspring.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	Iterable<Producto> findByNombreContaining(String nombre);
	
	Iterable<Producto> findByPrecioBetween(BigDecimal minimo, BigDecimal maximo);
}
