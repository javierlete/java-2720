package oop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operadores {
	public static void main(String[] args) {
		double d = 0.1 + 0.2;

		System.out.println(d);

		String s1 = "0.1";

		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal("0.2"); // SIEMPRE con COMILLAS DOBLES

		BigDecimal bdResultado = bd1.add(bd2);

		System.out.println(bdResultado);

		bd1 = new BigDecimal(10);
		bd2 = new BigDecimal(3);

		bdResultado = bd1.divide(bd2, 1000, RoundingMode.HALF_UP);

		System.out.println(bdResultado);

		int a = 5 % 2;

		System.out.println(a);

		a = 5 ^ 2;

		System.out.println(a);

		a = ~10;

		System.out.println(a);

		a = 1 + 2 + 3;

		boolean dentroDelRango = 1 <= a && a <= 10;

		System.out.println(dentroDelRango ? "Dentro del rango" : "Fuera del rango");

		System.out.println(!(a < 1 || a > 10));

		int x = 5, y = 20;

		System.out.println(x > y ? x : y);
		
		System.out.println(-5 >> 2);
		System.out.println(-5 >>> 2);
		
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.sqrt(25));
	}
}
