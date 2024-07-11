package oop;

import java.time.LocalDateTime;

public class StringBuilderEjemplo {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		
		String texto = "Hola";
		
		sb.append(LocalDateTime.now()).append(" ").append(texto).append("\n");
		
		texto = "Adios";
		
		sb.append(LocalDateTime.now()).append(" ").append(texto).append("\n");
		
		System.out.println(sb);
		
		String log = "";

		texto = "Hola";

		log += LocalDateTime.now() + " " + texto + "\n";

		texto = "Adios";

		log = new StringBuffer(log).append(LocalDateTime.now()).append(" ").append(texto).append("\n").toString();

		System.out.println(log);
	}
}
