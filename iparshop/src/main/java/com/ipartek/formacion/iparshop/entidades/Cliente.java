package com.ipartek.formacion.iparshop.entidades;

import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	private String nombre;

	@NotNull
	@NotBlank
	@Size(max = 200)
	private String direccion;

	@NotNull
	@NotBlank
	@Pattern(regexp = "\\d{5}")
	@Column(name = "codigo-postal", columnDefinition = "CHAR(5)")
	private String codigoPostal;

	@NotNull
	@NotBlank
	@Size(max = 100)
	private String ciudad;

	@NotNull
	@NotBlank
	@Pattern(regexp = "[XYZ\\d]\\d{7}[A-Z]")
	@Column(columnDefinition = "CHAR(9)")
	private String nif;
	
	@OneToMany(mappedBy = "cliente")
	// TODO: BUSCAR ALTERNATIVA Usamos @OnDelete ESPECÍFICO DE HIBERNATE porque es la mejor solución. NO HAY ALTERNATIVA EN EL ESTÁNDAR
	@OnDelete(action = OnDeleteAction.SET_NULL)
	private Set<Factura> facturas;
}
