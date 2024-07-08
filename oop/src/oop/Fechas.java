package oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Fechas {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date d = new Date(); //new Date(2024-1900, 7-1, 8);
		
		System.out.println(d);
		System.out.printf("%s-%s-%s\n", d.getYear()+1900, d.getMonth()+1, d.getDate());
		
		GregorianCalendar gc = new GregorianCalendar(); //new GregorianCalendar(2024, 7-1, 8);
		
		System.out.println(gc);
		System.out.printf("%s-%s-%s\n", gc.get(Calendar.YEAR), gc.get(Calendar.MONTH)+1, gc.get(Calendar.DATE));
		
		LocalDate ld = LocalDate.now(); // LocalDate.of(2024, 7, 8);
		
		System.out.println(ld);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.printf("%s/%s/%s\n", ld.getDayOfMonth(), ld.getMonthValue(), ld.getYear());
		
		System.out.println(ld.format(dtf));
		
		Scanner sc = new Scanner(System.in);
		
		String sFecha = sc.nextLine();
		
		LocalDate fecha = LocalDate.parse(sFecha, dtf);
		
		System.out.println(fecha.format(dtf));
		
		sc.close();
	}

}
