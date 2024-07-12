package oop.pruebas;

import java.math.BigDecimal;

import oop.pojos.Empleado;
import oop.pojos.EmpleadoIndefinido;
import oop.pojos.EmpleadoPorHoras;
import oop.pojos.Local;
import oop.pojos.Persona;

public class EmpleadoPruebas {
	public static void main(String[] args) {
		Empleado e = new EmpleadoIndefinido(1L, "Javier", "Lete", "12345678Z", "12345123451", new BigDecimal("12345.67"),
				14);

		System.out.println(e);

		e.setNombre("Pepe");
		e.setDni("12345678Z");

		System.out.println(e.getNombre());

		Persona p = e;

		System.out.println(p.getNombre());
		// System.out.println(p.getDni());

		System.out.println(p);

		if (p instanceof Empleado) {
			Empleado e2 = (Empleado) p;

			System.out.println(e2.getDni());
		} else {
			System.out.println("No es un empleado");
		}

		Persona p2 = new Persona();

		if (p2 instanceof Empleado e3) {
			// Empleado e3 = (Empleado) p2;

			System.out.println(e3.getDni());
		} else {
			System.out.println("No es un empleado");
		}

		System.out.println(e instanceof Object);

		Local local = new Local(null, "Ipartek", e, 5);

		local.entrar(new Persona("Pepe"));
		local.entrar(e);
		local.entrar(new EmpleadoPorHoras(2L, "asdf", "asdf", "adsf", "asdf", new BigDecimal("12.34"), 80));

		System.out.println(local);

		BigDecimal total = BigDecimal.ZERO;
		
		for (Persona persona : local.getVisitantes()) {
			if(persona instanceof Empleado empleado) {
				total = total.add(empleado.getSueldoMensual());
			}
			
			System.out.println(persona);
		}
		
		System.out.println(total);

	}
}
