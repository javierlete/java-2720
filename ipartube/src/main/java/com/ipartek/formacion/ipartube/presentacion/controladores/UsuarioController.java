package com.ipartek.formacion.ipartube.presentacion.controladores;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	private static final String RUTA_VIDEOS_URL = "/videos/";

	private static final String RUTA_VIDEOS_LOCAL = "src/main/resources/static/videos/";

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping({ "", "/subir" })
	public String subir(Video video) {
		return "usuario/subir";
	}

	@PostMapping("/subir")
	public String subirPost(@Valid Video video, BindingResult bindingResult, MultipartFile fichero, Model modelo) {
		try {
			if (bindingResult.hasErrors() || fichero.isEmpty()) {
				if (fichero.isEmpty()) {
					modelo.addAttribute("errorFichero", "Se debe adjuntar fichero");
				}

				return "usuario/subir";
			}

			fichero.transferTo(Path.of(RUTA_VIDEOS_LOCAL, fichero.getOriginalFilename()));
			
			video.setUrl(RUTA_VIDEOS_URL + fichero.getOriginalFilename());
			
			usuarioService.registrarVideo(video);

		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
}
