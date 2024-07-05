package oop;

public class Condicionales {
	public static void main(String[] args) {
		double nota = 2;

		if (nota >= 9) {
			System.out.println("Sobresaliente");
		} else if (nota >= 7) {
			System.out.println("Notable");
		} else if (nota >= 6) {
			System.out.println("Bien");
		} else if (nota >= 5) {
			System.out.println("Suficiente");
		} else if (nota >= 4) {
			System.out.println("Insuficiente");
		} else {
			System.out.println("Muy deficiente");
		}

		int mensajes = 1;

		switch (mensajes) {
		case 0:
			System.out.println("No tienes mensajes");
			break;
		case 1:
			System.out.println("Tienes un mensaje");
			break;
		default:
			System.out.println("Tienes " + mensajes + " mensajes");
		}

		int dias, mes = 3;

		switch (mes) {
		case 2:
			dias = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		default:
			dias = 31;
		}

		System.out.println(dias);

		// break implícito (no hay que ponerlo)
		// Java 14
		switch (mensajes) {
		case 0 -> System.out.println("No tienes mensajes");
		case 1 -> System.out.println("Tienes un mensaje");
		default -> System.out.println("Tienes " + mensajes + " mensajes");
		}
		
		dias = switch(mes) {
		case 2 -> 28;
		case 4, 6, 9, 11 -> 30;
		default -> 31;
		};
	}
}
