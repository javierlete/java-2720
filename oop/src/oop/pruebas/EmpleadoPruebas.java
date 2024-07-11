package oop.pruebas;

import oop.pojos.Empleado;
import oop.pojos.Local;
import oop.pojos.Persona;

public class EmpleadoPruebas {
	public static void main(String[] args) {
		Empleado e = new Empleado("Javier", "Lete", "12345678Z", "12345123451");

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
		local.entrar(new Empleado("asdf", "asdf", "adsf", "asdf"));
		
		System.out.println(local);
		
		for(Persona persona: local.getVisitantes()) {
			System.out.println(persona);
		}
		
	}
}
