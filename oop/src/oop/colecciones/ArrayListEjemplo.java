package oop.colecciones;

import java.util.ArrayList;

public class ArrayListEjemplo {
	public static void main(String[] args) {
		// ArrayList<String> al = new ArrayList<String>();
		var al = new ArrayList<String>();
		
		al.add("Uno");
		al.add("Dos");
		al.add("Tres");
		al.add("Tres");
		al.add("Tres");
		
		al.add(2, "Dos y medio");
		
		al.remove("Uno");
		al.remove(2);
		
		al.set(0, "DOS");
		
		System.out.println(al);
		
		for(var elemento: al) {
			System.out.println(elemento);
		}
		
		System.out.println(al.get(1));
		
		System.out.println(al.size());
	}
}
