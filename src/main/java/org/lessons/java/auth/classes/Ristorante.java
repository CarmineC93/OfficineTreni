package org.lessons.java.auth.classes;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ristorante extends Vagone {

	@Override
	public String toString() {
		return "Ristorante [tavoli=" + tavoli + ", id=" + id + ", peso=" + peso + ", lunghezza=" + lunghezza
				+ ", costo=" + costo + ", colore=" + colore + ", compagnia=" + compagnia + "]";
	}


	/**
	 * @author visco
	 */

	public int tavoli; // tavoli disponibili in sala

	public Ristorante(int id, float peso, float lunghezza, String colore, String compagnia, float costo, int tavoli) {
		// TODO Auto-generated constructor stub
		super(peso, lunghezza, costo, colore, compagnia);
		this.tavoli = tavoli;
	}


	// prenota tavolo
	public void prenotaTavolo() {
		if (tavoli > 0)
			tavoli--;
		else
			System.out.println("Non sono più disponibili tavoli");
	}

}
