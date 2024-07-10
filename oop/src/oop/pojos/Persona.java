package oop.pojos;

import java.util.Objects;

public class Persona {
	// VARIABLES DE INSTANCIA
	private Long id;
	private String nombre;
	private String apellidos;

	// CONSTRUCTORES
	public Persona(Long id, String nombre, String apellidos) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
	}
	
	// Constructor de copia
	public Persona(Persona persona) {
		this(persona.getId(), persona.getNombre(), persona.getApellidos());
	}
	
	public Persona(Long id, String nombre) {
		this(id, nombre, null);
	}

	public Persona(String nombre) {
		this(null, nombre, null);
	}
	
	public Persona() {
		this(null, "Anónimo", null);
	}

	// GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id != null && id < 0) {
			throw new IllegalArgumentException("El id no puede ser negativo");
		}
		
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null) {
			throw new IllegalArgumentException("No se admiten nombres null");
		}
		
		if(nombre.trim().length() == 0) {
			throw new IllegalArgumentException("No se admiten nombres vacíos");
		}
		
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if(apellidos != null && apellidos.isBlank()) {
			throw new IllegalArgumentException("No se admiten apellidos en blanco");
		}
		
		this.apellidos = apellidos;
	}

	// HASHCODE Y EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

}
