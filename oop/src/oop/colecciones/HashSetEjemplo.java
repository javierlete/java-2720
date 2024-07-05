package oop.colecciones;

import java.util.HashSet;

public class HashSetEjemplo {
	public static void main(String[] args) {
		// ArrayList<String> al = new ArrayList<String>();
		var hs = new HashSet<String>();
		
		hs.add("Uno");
		hs.add("Dos");
		hs.add("Tres");
		hs.add("Tres");
		hs.add("Tres");
		
		hs.remove("Uno");
		
		System.out.println(hs);
		
		for(var elemento: hs) {
			System.out.println(elemento);
		}
		
		System.out.println(hs.size());
	}
}
