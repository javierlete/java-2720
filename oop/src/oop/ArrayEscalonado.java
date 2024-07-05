package oop;

public class ArrayEscalonado {
	public static void main(String[] args) {
		double[][] temperaturasAnuales = new double[12][];
		
		temperaturasAnuales[0] = new double[31];
		temperaturasAnuales[1] = new double[28];
		temperaturasAnuales[2] = new double[31];
		temperaturasAnuales[3] = new double[30];
		temperaturasAnuales[4] = new double[31];
		temperaturasAnuales[5] = new double[30];
		temperaturasAnuales[6] = new double[31];
		temperaturasAnuales[7] = new double[31];
		temperaturasAnuales[8] = new double[30];
		temperaturasAnuales[9] = new double[31];
		temperaturasAnuales[10] = new double[30];
		temperaturasAnuales[11] = new double[31];
		
		temperaturasAnuales[7-1][5-1] = 22.0;
		
		for(int fila = 0; fila < temperaturasAnuales.length; fila++) {
			for(int columna = 0; columna < temperaturasAnuales[fila].length; columna++) {
				System.out.print(temperaturasAnuales[fila][columna] + " ");
			}
			
			System.out.println();
		}
	}
}
