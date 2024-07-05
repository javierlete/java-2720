package oop;

import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Pensar el número a adivinar
		int pensado = new Random().nextInt(1, 100);

		bucle: while (true) {
			System.out.print("Dime un número: ");
			int numero = sc.nextInt();

// ¿Es igual?
			if (pensado == numero) {
				System.out.println("¡Has acertado!");
				break bucle;
// ¿Es mayor?
			} else if (pensado > numero) {
				System.out.println("¡Es mayor!");
			} else {
				System.out.println("¡Es menor!");
			}
		}
		
		sc.close();
	}
}
