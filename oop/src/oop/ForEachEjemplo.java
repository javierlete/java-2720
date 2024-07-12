package oop;

import java.util.ArrayList;
import java.util.Iterator;

public class ForEachEjemplo {
	public static void main(String[] args) {
		ArrayList<String> textos = new ArrayList<>();
		
		textos.add("Uno");
		textos.add("Dos");
		
		for(String texto: textos) {
			System.out.println(texto);
		}
		
		Iterable<String> iterable = textos;
		Iterator<String> iterator = iterable.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
