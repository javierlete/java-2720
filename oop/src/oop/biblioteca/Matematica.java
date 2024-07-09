package oop.biblioteca;

import java.math.BigInteger;

public class Matematica {
	// 5! = 5 * 4 * 3 * 2 * 1
	// 5! = 5 * 4!
	// 4! = 4 * 3!
	// 3! = 3 * 2!
	// 2! = 2 * 1!
	// 1! = 1

	public static BigInteger factorial(BigInteger numero) {
		if(numero.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		
		return numero.multiply(factorial(numero.subtract(BigInteger.ONE)));
	}
	
	public static long factorial(long numero) {
		if(numero == 1) {
			return 1;
		}
		
		return numero * factorial(numero - 1);
	}
}
