package com.ipartek.formacion.ipartube.repositorios;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.ipartube.entidades.Video;

@RepositoryRestResource(path = "videos", collectionResourceRel = "videos")
public interface VideoRepository extends CrudRepository<Video, Long>, PagingAndSortingRepository<Video, Long>{
	Set<Video> findByNombreContaining(String nombre);
}
