package org.lessons.java.auth.classes;
public class RistoranteTrenItalia extends Ristorante {

	public RistoranteTrenItalia(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			int tavoli) {
		// TODO Auto-generated constructor stub
		super(id, peso, lunghezza, colore, compagnia, costo, tavoli);
	}

	@Override
	public String toString() {
		return "RistoranteTrenItalia [tavoli=" + tavoli + ", id=" + id + ", peso=" + peso + ", lunghezza=" + lunghezza
				+ ", costo=" + costo + ", colore=" + colore + ", compagnia=" + compagnia + "]";
	}

}
