package oop.pojos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Local {
	private Long id;
	private String nombre;
	private Persona propietario;
	private Integer capacidad;
	
	private ArrayList<Persona> visitantes = new ArrayList<>();

	public Local(Long id, String nombre, Persona propietario, Integer capacidad) {
		setId(id);
		setNombre(nombre);
		setPropietario(propietario);
		setCapacidad(capacidad);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public List<Persona> getVisitantes() {
		return Collections.unmodifiableList(visitantes);
	}
	
	// MÉTODOS DE INSTANCIA
	public void entrar(Persona persona) {
		if(persona == null) {
			throw new IllegalArgumentException("No se admiten visitantes nulos");
		}
		
		if(visitantes.size() >= capacidad) {
			throw new RuntimeException("No cabe nadie más");
		}
		
		visitantes.add(persona);
	}
	
	public void salir(Persona persona) {
		visitantes.remove(persona);
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacidad, id, nombre, propietario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Local other = (Local) obj;
		return Objects.equals(capacidad, other.capacidad) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(propietario, other.propietario);
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", nombre=" + nombre + ", propietario=" + propietario + ", capacidad=" + capacidad
				+ "]";
	}
}