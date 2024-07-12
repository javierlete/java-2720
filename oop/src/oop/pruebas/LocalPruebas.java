package oop.pruebas;

import oop.pojos.Local;
import oop.pojos.Persona;

public class LocalPruebas {
	public static void main(String[] args) {
		Persona propietario = new Persona("Javier");
		Local local = new Local(1L, "Ipartek", propietario, 3);
		
		System.out.println(local);
		
		local.entrar(new Persona("Pepe"));
		local.entrar(new Persona("Juan"));
		local.entrar(new Persona("Pedro"));
		// local.entrar(new Persona("Julio"));
		
		System.out.println(local.getVisitantes());
		
		// local.getVisitantes().add(null);
		
		local.getVisitantes().get(1).setNombre("Juanito");
		
		for(Persona visitante: local.getVisitantes()) {
			System.out.println(visitante);
		}
		
		System.out.println(Local.getCapacidadPorDefecto());
	}
}
