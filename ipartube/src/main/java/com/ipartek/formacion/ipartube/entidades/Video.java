package com.ipartek.formacion.ipartube.entidades;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "videos")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Builder.Default
	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
	private LocalDateTime fecha = LocalDateTime.now();
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	private String nombre;
	
	@NotBlank
	@Lob
	@Size(max = 2000)
	private String descripcion;
	
	@NotNull
	@Size(max = 256)
	private String url;
}
