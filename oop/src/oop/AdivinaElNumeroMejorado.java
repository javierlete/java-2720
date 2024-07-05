package oop;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumeroMejorado {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int pensado = new Random().nextInt(1, 100);

		int numero;

		do {
			System.out.print("Dime un número: ");
			numero = sc.nextInt();

			if (pensado > numero) {
				System.out.println("¡Es mayor!");
			} else {
				System.out.println("¡Es menor!");
			}
		} while (pensado != numero);

		System.out.println("¡Has acertado!");
		
		sc.close();
	}
}
