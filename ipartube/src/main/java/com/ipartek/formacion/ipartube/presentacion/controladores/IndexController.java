package com.ipartek.formacion.ipartube.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.AnonimoService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;
	
	@GetMapping
	public String index(Model modelo, String nombre) {
		Iterable<Video> videos;
		
		if(nombre == null) {
			videos = anonimoService.videosPrincipal();
		} else {
			videos = anonimoService.buscarVideo(nombre);
		}
		
		modelo.addAttribute("videos", videos);
		return "index";
	}
}
