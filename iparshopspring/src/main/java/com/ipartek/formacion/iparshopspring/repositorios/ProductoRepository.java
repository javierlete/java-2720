package com.ipartek.formacion.iparshopspring.repositorios;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.iparshopspring.entidades.Producto;

@RepositoryRestResource(path = "productos", collectionResourceRel = "productos")
public interface ProductoRepository extends CrudRepository<Producto, Long>, PagingAndSortingRepository<Producto, Long> {
	Iterable<Producto> findByNombreContaining(String nombre);
	
	Iterable<Producto> findByPrecioBetween(BigDecimal minimo, BigDecimal maximo);
}
