package oop.pruebas;

import java.math.BigDecimal;

import oop.ProductoRecord;

public class ProductoRecordPruebas {
	public static void main(String[] args) {
		ProductoRecord producto1 = new ProductoRecord("Producto1", new BigDecimal("1234.46"));
		ProductoRecord producto2 = new ProductoRecord("Producto1", new BigDecimal("1234.46"));
		
		System.out.println(producto1);
		
		System.out.println(producto1.nombre());
		System.out.println(producto1.precio());
		
		System.out.println(producto1 == producto2);
		System.out.println(producto1.equals(producto2));
		
		System.out.println(producto1.hashCode());
		System.out.println(producto2.hashCode());
	}
}
