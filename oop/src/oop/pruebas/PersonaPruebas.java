package oop.pruebas;

import oop.pojos.Persona;

public class PersonaPruebas {
	public static void main(String[] args) {
		Persona p;
		p = new Persona();
		
		System.out.println(p.getId());
		System.out.println(p.getNombre());
		System.out.println(p.getApellidos());
		
		p.setId(1L);
		p.setNombre("Javier");
		p.setApellidos("Lete");
		
		System.out.println(p.toString());
		
		Persona p2 = new Persona(2L, "Pepe", "Pérez");
		
		System.out.println(p2);
		
		Persona p3 = new Persona(3L, "Juan");
		
		System.out.println(p3);

		Persona p4 = new Persona("Juan");

		System.out.println(p4);
		
		Persona a1 = new Persona();
		Persona a2 = new Persona(a1);
		
		// a2.setNombre("Pedro");
		
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println(a1 == a2);
		System.out.println(a1.equals(a2));
	}
}
