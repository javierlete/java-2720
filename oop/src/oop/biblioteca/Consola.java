package oop.biblioteca;

import java.util.Scanner;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);

	public static void pl() {
		System.out.println();
	}

	public static void pl(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static void p(String mensaje) {
		System.out.print(mensaje);
	}

	public static void pfl(String formato, Object... args) {
		System.out.printf(formato + "\n", args);
	}
	
	public static String leerString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine();
	}

	public static int leerInt(String mensaje) {
		boolean hayError = true;
		int numero = 0;
		
		do {
			try {
				numero = Integer.parseInt(leerString(mensaje));

				hayError = false;
			} catch (NumberFormatException e) {
				System.out.println("No me has introducido un número");
			}
		} while (hayError);

		return numero;
	}
}
