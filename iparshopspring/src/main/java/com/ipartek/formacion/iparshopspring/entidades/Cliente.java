package com.ipartek.formacion.iparshopspring.entidades;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	@Email
	@Size(max = 100)
	@Column(unique = true)
	private String email;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	@Pattern(regexp = "^(?=.*\\d)(?=.*\\p{Ll})(?=.*\\p{Lu})(?=.*[\\+\\-_\\$]).{8,100}$")
	private String password;
	
	@NotNull
	@NotBlank
	@Size(max = 20)
	@Pattern(regexp = "^[A-Z]+$")
	@Builder.Default
	private String rol = "USER";
	
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
	@Column(columnDefinition = "CHAR(5)")
	private String codigoPostal;

	@NotNull
	@NotBlank
	@Size(max = 100)
	private String ciudad;

	@NotNull
	@NotBlank
	@Pattern(regexp = "[XYZ\\d]\\d{7}[TRWAGMYFPDXBNJZSQVHLCKE]")
	@Column(columnDefinition = "CHAR(9)")
	private String nif;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "cliente")
	// TODO: BUSCAR ALTERNATIVA Usamos @OnDelete ESPECÍFICO DE HIBERNATE porque es la mejor solución. NO HAY ALTERNATIVA EN EL ESTÁNDAR
	@OnDelete(action = OnDeleteAction.SET_NULL)
	private Set<Factura> facturas;
}
