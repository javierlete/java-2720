package oop.pojos;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Empleado extends Persona {
	private String dni;
	private String nss;

	public Empleado(Long id, String nombre, String apellidos, String dni, String nss) {
		super(id, nombre, apellidos);
		setDni(dni);
		setNss(nss);
	}

	public Empleado(String nombre, String apellidos, String dni, String nss) {
		this(null, nombre, apellidos, dni, nss);
	}
	
	@Override
	public void setApellidos(String apellidos) {
		if(apellidos == null) {
			throw new IllegalArgumentException("Los apellidos son obligatorios para un empleado");
		}

		super.setApellidos(apellidos);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if(dni == null) {
			throw new IllegalArgumentException("No se admiten DNIs nulos");
		}
		
		this.dni = dni;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		if(nss == null) {
			throw new IllegalArgumentException("No se admiten nss nulos");
		}
		
		this.nss = nss;
	}
	
	public abstract BigDecimal getSueldoMensual();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dni, nss);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nss, other.nss);
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nss=" + nss + "] " + super.toString();
	}

		
}