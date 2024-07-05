package oop.colecciones;

import java.util.TreeMap;

public class TreeMapEjemplo {
	public static void main(String[] args) {
		// ArrayList<String> al = new ArrayList<String>();
		var tm = new TreeMap<String, String>();
		
		tm.put("Uno", "One");
		tm.put("Dos", "Tow");
		tm.put("Tres", "Three");
		tm.put("Tres", "Three");
		tm.put("Tres", "Three");
		
		tm.put("Dos y medio", "Two and a half");
		
		tm.remove("Uno");
		
		tm.put("Dos", "Two");
		
		System.out.println(tm);
		
		System.out.println("ENTRYSET");
		
		for(var par: tm.entrySet()) {
			System.out.printf("%s = %s\n", par.getKey(), par.getValue());
		}
		
		System.out.println("KEYSET");
		
		for(var clave: tm.keySet()) {
			System.out.printf("%s = %s\n", clave, tm.get(clave));
		}
		
		System.out.println("VALUES");
		
		for(var valor: tm.values()) {
			System.out.println(valor);
		}
		
		System.out.println(tm.get("Dos"));
		
		System.out.println(tm.size());
	}
}
