package org.lessons.java.auth.classes;
public class RistoranteItalo extends Ristorante {

	public RistoranteItalo(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			int tavoli) {
		// TODO Auto-generated constructor stub
		super(id, peso, lunghezza, colore, compagnia, costo, tavoli);
	}


	@Override
	public String toString() {
		return "RistoranteItalo [tavoli=" + tavoli + ", id=" + id + ", peso=" + peso + ", lunghezza=" + lunghezza
				+ ", costo=" + costo + ", colore=" + colore + ", compagnia=" + compagnia + "]";
	}

}
