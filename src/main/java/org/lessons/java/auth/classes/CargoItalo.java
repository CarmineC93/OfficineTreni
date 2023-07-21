package org.lessons.java.auth.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CargoItalo extends Cargo {

	

	public CargoItalo(int id, float peso, float lunghezza, String colore, String compagnia, float costo, float spazio, String scopo) {
		// TODO Auto-generated constructor stub
		super(id, peso, lunghezza, colore, compagnia, costo, spazio, scopo);
	}

	@Override
	public String toString() {
		return "CargoItalo [scopo=" + scopo + ", spazio=" + spazio + ", id=" + id + ", peso=" + peso + ", lunghezza="
				+ lunghezza + ", costo=" + costo + ", colore=" + colore + ", compagnia=" + compagnia + "]";
	}

	

	/*
	 * TEST CREAZIONE BEAN CON ANNOTATION JAVA public CargoItalo () {
	 * System.out.println("CIAO, STO CREANDO UN CARGO ITALO!"); this.scopo =
	 * "FRIGO"; this.spazio = 2000; this.lunghezza = 120; this.peso = 50000; }
	 */

}
