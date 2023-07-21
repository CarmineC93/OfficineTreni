package org.lessons.java.auth.classes;
public class PasseggeriTrenItalia extends Passeggeri {

	public PasseggeriTrenItalia(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			int postiDisponibili, float prezzoPosto, int cuccetteDisponibili, float prezzoCuccetta) {
		// TODO Auto-generated constructor stub
		super(id, peso, lunghezza, colore, compagnia, costo, postiDisponibili, prezzoPosto, cuccetteDisponibili, prezzoCuccetta);
	}

	@Override
	public String toString() {
		return "PasseggeriTrenItalia [postiDisponibili=" + postiDisponibili + ", prezzoPosto=" + prezzoPosto
				+ ", cuccetteDisponibili=" + cuccetteDisponibili + ", prezzoCuccetta=" + prezzoCuccetta + ", id=" + id
				+ ", peso=" + peso + ", lunghezza=" + lunghezza + ", costo=" + costo + ", colore=" + colore
				+ ", compagnia=" + compagnia + "]";
	}

}
