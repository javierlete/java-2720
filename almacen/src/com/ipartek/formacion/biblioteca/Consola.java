package com.ipartek.formacion.biblioteca;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Function;

public class Consola {
	public static final boolean OPCIONAL = true;
	public static final boolean OBLIGATORIO = !OPCIONAL;

	private static final Scanner sc = new Scanner(System.in);

	public static void pl() {
		System.out.println();
	}

	public static void pl(Object mensaje) {
		System.out.println(mensaje);
	}

	public static void p(Object mensaje) {
		System.out.print(mensaje);
	}

	public static void pfl(String formato, Object... args) {
		System.out.printf(formato + "\n", args);
	}

	public static String leerString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine();
	}

	public static String leerString(String mensaje, boolean opcional) {
		return leer(String.format("%s (%s)", mensaje, opcional ? "opcional" : "obligatorio"), texto -> {
			if (texto.isBlank() && !opcional) {
				throw new IllegalArgumentException("Es obligatorio");
			}

			return texto;
		});
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

	public static Integer leerInt(String mensaje, boolean opcional, int minimo) {
		return leer(String.format("%s (%s) (minimo=%s)", mensaje, opcional ? "opcional" : "obligatorio", minimo),
				texto -> {
					if (opcional && texto.isBlank()) {
						return null;
					}

					int i = Integer.parseInt(texto);

					if (i < minimo) {
						throw new IllegalArgumentException("Está por debajo del mínimo");
					}

					return i;
				});
	}
	
	public static Integer leerInt(String mensaje, boolean opcional) {
		return leerInt(mensaje, opcional, Integer.MIN_VALUE);
	}

	public static BigDecimal leerBigDecimal(String mensaje, boolean opcional, BigDecimal minimo) {
		return leer(String.format("%s (%s) (minimo=%s)", mensaje, opcional ? "opcional" : "obligatorio", minimo),
				texto -> {
					if (opcional && texto.isBlank()) {
						return null;
					}

					BigDecimal bd = new BigDecimal(texto);

					if (bd.compareTo(minimo) < 0) {
						throw new IllegalArgumentException("Está por debajo del mínimo");
					}

					return bd;
				});
	}

	public static LocalDate leerLocalDate(String mensaje, boolean opcional, LocalDate minimo) {
		return leer(String.format("%s (opcional) (minimo=%s)", mensaje, minimo), texto -> {
			if (opcional && texto.isBlank()) {
				return null;
			}

			LocalDate ld = LocalDate.parse(texto);

			if (ld.isBefore(minimo)) {
				throw new IllegalArgumentException("Está por debajo del mínimo");
			}

			return ld;
		});
	}

	public static LocalDate leerLocalDate(String mensaje, boolean opcional) {
		return leerLocalDate(mensaje, opcional, LocalDate.MIN);
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

	public static LocalDate leerLocalDate(String mensaje) {
		return leer(mensaje + " (AAAA-MM-DD)", texto -> {
			return LocalDate.parse(texto);
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
