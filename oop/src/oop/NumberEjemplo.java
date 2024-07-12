package oop;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class NumberEjemplo {
	public static void main(String[] args) {
		ArrayList<Number> numeros = new ArrayList<>();
		
		numeros.add(5); // new Integer(5));
		numeros.add(6.7); // new Double(6.7));
		numeros.add(new BigInteger("24"));
		numeros.add(new BigDecimal("1234.56"));
		
		for(Number numero: numeros) {
			System.out.println(numero.intValue());
		}
	}
}
