package oop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicheroTexto {
	private static final boolean APPEND = true;

	public static void main(String[] args) {
		try (FileWriter fw = new FileWriter("fichero.txt", APPEND);
				// "C:"
				// "uevos rabajos.txt"
				PrintWriter pw = new PrintWriter(fw)) {
			pw.println("Una línea");
			pw.println("Otra línea");
		} catch (IOException e) {
			System.out.println("Ha habido un error al escribir el fichero");
		}
		// Cierre implícito de fw y pw por parte de la estructura try-with-resources

		try (FileReader fr = new FileReader("fichero.txt"); Scanner sc = new Scanner(fr)) {

			String linea;

			while (sc.hasNext()) {
				linea = sc.nextLine();
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el fichero");
		} catch (IOException e) {
			System.out.println("No se ha podido leer del fichero");
		}

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader("fichero.txt");
			br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			System.out.println("No se ha podido leer del fichero");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// No podemos hacer nada para resolver un cierre que no ha funcionado
				}
			}

			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// No podemos hacer nada para resolver un cierre que no ha funcionado
				}
			}
		}
	}
}
