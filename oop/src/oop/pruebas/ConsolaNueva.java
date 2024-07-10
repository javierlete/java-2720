package oop.pruebas;

public class ConsolaNueva {
	public static void main(String[] args) {
		// Sólo funciona en la consola real y no en la de Eclipse
		String texto = System.console().readLine();
		System.out.println(texto);
	}
}
