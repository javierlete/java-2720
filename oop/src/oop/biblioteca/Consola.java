package oop.biblioteca;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Function;

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
	
	

	public static <T> T leer(String mensaje, Function<String, T> funcion) {
		boolean hayError = true;
		T dato = null;
		
		do {
			try {
				String texto = leerString(mensaje);
				dato = funcion.apply(texto);

				hayError = false;
			} catch (Exception e) {
				System.out.println("El texto proporcionado no se puede convertir");
			}
		} while (hayError);

		return dato;
	}
	
	public static BigDecimal leerBigDecimal(String mensaje) {
		return leer(mensaje, texto -> {
			return new BigDecimal(texto); 
		});
	}
	
	public static Long leerLong(String mensaje) {
		return leer(mensaje, texto -> Long.parseLong(texto));
		
		// INTERFACE FUNCIONAL
//		public interface Function<T, R> {
//			R apply(T t);
//		}
		
		// USO DE CLASE ANÓNIMA
//		return leer(mensaje, new Convertible<Long>() {
//			@Override
//			public Long convertir(String texto) {
//				return Long.parseLong(texto);
//			}
//		});
	}
	
	// CLASE INTERNA
//	private static class ConversionLong implements Convertible<Long> {
//
//		@Override
//		public Long convertir(String texto) {
//			return Long.parseLong(texto);
//		}
//
//	}

}
