package oop;

import java.math.BigInteger;

public class CompareToEjemplo {
	public static void main(String[] args) {
		int i1 = 5, i2 = 6;
		
		System.out.println(i1 > i2);
		
		BigInteger bi1 = new BigInteger("5");
		BigInteger bi2 = new BigInteger("6");
		
		System.out.println(bi1.compareTo(bi2) > 0); // SIEMPRE 0
	}
}
