package oop.pojos;

import java.math.BigDecimal;
import java.util.Objects;

public class EmpleadoPorHoras extends Empleado {
	private Integer numeroHorasMensuales;
	private BigDecimal sueldoPorHora;

	public EmpleadoPorHoras(Long id, String nombre, String apellidos, String dni, String nss,
			BigDecimal sueldoPorHora, Integer numeroHorasMensuales) {
		super(id, nombre, apellidos, dni, nss);
		
		setNumeroHorasMensuales(numeroHorasMensuales);
		setSueldoPorHora(sueldoPorHora);
	}

	public Integer getNumeroHorasMensuales() {
		return numeroHorasMensuales;
	}

	public void setNumeroHorasMensuales(Integer numeroHorasMensuales) {
		this.numeroHorasMensuales = numeroHorasMensuales;
	}

	public BigDecimal getSueldoPorHora() {
		return sueldoPorHora;
	}

	public void setSueldoPorHora(BigDecimal sueldoPorHora) {
		this.sueldoPorHora = sueldoPorHora;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoPorHora.multiply(new BigDecimal(numeroHorasMensuales));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroHorasMensuales, sueldoPorHora);
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
		EmpleadoPorHoras other = (EmpleadoPorHoras) obj;
		return Objects.equals(numeroHorasMensuales, other.numeroHorasMensuales)
				&& Objects.equals(sueldoPorHora, other.sueldoPorHora);
	}

	@Override
	public String toString() {
		return "EmpleadoPorHoras [numeroHorasMensuales=" + numeroHorasMensuales + ", sueldoPorHora=" + sueldoPorHora
				+ "]";
	}

}
