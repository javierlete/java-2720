package oop.pruebas;

import static oop.biblioteca.Consola.*;

public class ConsolaPruebas {
	public static void main(String[] args) {
		pl("Hola");
		pl();
		pfl("%s,%s", 1, 2);
		
		int numero = leerInt("Dime un número");
		
		pfl("numero = %s", numero);
		
		String nombre = leerString("Dime tu nombre");
		
		pl(nombre);
	}
}
