package com.ipartek.formacion.ipartube.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.VideoRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private VideoRepository videoRepository;
	
	@Override
	public Video registrarVideo(Video video) {
		return videoRepository.save(video);
	}

}
