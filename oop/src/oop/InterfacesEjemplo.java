package oop;

import java.util.ArrayList;

public class InterfacesEjemplo {
	public static void main(String[] args) {
		ArrayList<Esferico> esfericos = new ArrayList<>();
		
		esfericos.add(new Naranja());
		esfericos.add(new Balon());
		
		for(Esferico esferico: esfericos) {
			if(esferico instanceof Comestible comestible) {
				comestible.comer();
			}
			
			esferico.rodar();
			
			if(esferico instanceof Comestible comestible) {
				comestible.comer();
			}
		}
	}
}

class Fruto {
}

class ObjetoDeporte {
}

class Balon extends ObjetoDeporte implements Esferico {
	@Override
	public void rodar() {
		System.out.println("BALON RODANDO");
	}
}

class Naranja extends Fruto implements Esferico, Comestible {
	private boolean porElSuelo = false;

	@Override
	public void comer() {
		if (porElSuelo) {
			System.out.println("¡SE LA COME TU PADRE!");
		} else {
			System.out.println("¡ÑAM, QUE RICA!");
		}
	}

	@Override
	public void rodar() {
		porElSuelo = true;
		System.out.println("NARANJA RODANDO");
	}
}

interface Esferico {
	void rodar();
}

interface Comestible {
	void comer();
}
