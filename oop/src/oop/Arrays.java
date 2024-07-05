package oop;

public class Arrays {
	public static void main(String[] args) {
		int[] arr = new int[5];

		arr[0] = 5;
		arr[3] = 7;

		int i1 = 0;
		
		while (i1 < arr.length) {
			int dato = arr[i1];

			if (i1 == arr.length - 1) {
				System.out.println(dato);
			} else {
				System.out.print(dato + ",");
			}
			
			i1++;
		}

		for (int i = 0; i < arr.length; i++) {
			int dato = arr[i];

			if (i == arr.length - 1) {
				System.out.println(dato);
			} else {
				System.out.print(dato + ",");
			}
		}

		for (int dato : arr) {
			System.out.print(dato + " ");
		}
	}
}
