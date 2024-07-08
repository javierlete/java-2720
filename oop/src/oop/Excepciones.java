package oop;

import java.util.Scanner;

public class Excepciones {
	public static void main(String[] args) {
		Scanner sc = null;

		try {
			sc = new Scanner(System.in);

			boolean hayError = true;

			do {
				try {
					System.out.print("Dame un número entero: ");
					int numero = Integer.parseInt(sc.nextLine());

					System.out.println(numero);

					System.out.printf("10/%s = %s\n", numero, 10 / numero);

					int[] arr = new int[2];

					arr[2] = numero;

					hayError = false;
				} catch (NumberFormatException e) {
					System.out.println("No me has introducido un número");
				} catch (ArithmeticException e) {
					System.out.println("No se ha podido dividir");
				}

			} while (hayError);

			System.out.println("Fin del programa");

		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
