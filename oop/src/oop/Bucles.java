package oop;

import java.util.Scanner;

public class Bucles {
	public static void main(String[] args) {
		int i = 1;

		while (i <= 5) {
			System.out.print(i++);
		}

		Scanner sc = new Scanner(System.in);

		boolean repetir = false;

		do {
			System.out.print("¿Quieres repetir? (s/N) ");
			String texto = sc.nextLine();

			repetir = texto.equals("s");
		} while (repetir);
		
		System.out.println("Se acabó");
		
		sc.close();
	}
}
