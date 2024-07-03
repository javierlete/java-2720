package oop;

public class HolaMundo {
	public static void main(String[] args) {
		System.out.println("Hola");
		
		System.out.println(args.length);
		
		for(String arg: args) {
			System.out.println(arg);
		}
		
		String texto = """
				Javier
				Lete
				
				Profesor de Java
				""";
		
		System.out.println(texto);
		
		System.out.println(texto.toUpperCase());
	}
}
