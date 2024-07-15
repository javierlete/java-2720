package oop.pruebas;

import oop.pojos.Local;
import oop.pojos.Persona;

public class LocalStreamPruebas {
	public static void main(String[] args) {
		Persona propietario = new Persona("Javier");
		Local local = new Local(1L, "Ipartek", propietario, 3);
		
		System.out.println(local);
		
		local.entrar(new Persona("Pepe"));
		local.entrar(new Persona("Juan"));
		local.entrar(new Persona("Pedro"));
		// local.entrar(new Persona("Julio"));
		
		System.out.println(local.getVisitantes());
		
		System.out.println(local.buscarPersona("Pe"));
		
		System.out.println(local.obtenerNombres());
		
		System.out.println(local.obtenerNombresCsv());
	}
}
