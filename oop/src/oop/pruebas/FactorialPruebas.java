package oop.pruebas;

import static oop.biblioteca.Consola.pfl;
import static oop.biblioteca.Matematica.factorial;

import java.math.BigInteger;

public class FactorialPruebas {
	public static void main(String[] args) {
		pfl("El factorial de 5 es %s", factorial(50));
		
		BigInteger resultado = factorial(new BigInteger("15000"));
		
		pfl("El factorial de 5 es de %s dígitos: %s", resultado.toString().length(), resultado);
	}
}
