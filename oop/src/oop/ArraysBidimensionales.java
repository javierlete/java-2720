package oop;

public class ArraysBidimensionales {
	public static void main(String[] args) {
		char[][] tablero = new char[8][8];

		tablero[0][0] = 'T';
		tablero[0][1] = 'C';
		tablero[1][0] = 'P';
		
		tablero[7][7] = 't';
		tablero[7][6] = 'c';
		tablero[6][7] = 'p';
		
		for(int fila = 0; fila < tablero.length; fila++) {
			for(int columna = 0; columna < tablero[fila].length; columna++) {
				if(tablero[fila][columna] != 0) {
					System.out.print(tablero[fila][columna] + " ");
				} else {
					System.out.print(". ");
				}
			}
			
			System.out.println();
		}
	}
}
