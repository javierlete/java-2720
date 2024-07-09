package oop;

public class Enumeraciones {
	
	// private static enum Colores { ROJO, VERDE, AZUL };
	
	public static void main(String[] args) {
		Colores color = Colores.VERDE;
		
		switch(color) {
		case ROJO-> System.out.println("Rojillo");
		case VERDE -> System.out.println("Como la hierba");
		case AZUL -> System.out.println("Como el cielo");
		default -> System.out.println("¿¿De dónde narices has sacado ese color??");
		}
	}
}
