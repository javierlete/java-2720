package com.ipartek.formacion.ipartube.servicios;

import com.ipartek.formacion.ipartube.entidades.Video;

public interface AnonimoService {
	Iterable<Video> videosPrincipal();
	Iterable<Video> buscarVideo(String nombre);
}
