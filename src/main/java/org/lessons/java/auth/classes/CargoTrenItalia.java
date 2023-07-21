package org.lessons.java.auth.classes;
public class CargoTrenItalia extends Cargo{

	public CargoTrenItalia(int id, float peso, float lunghezza, float costo, String colore, String compagnia, float spazio,
			String scopo, float spazio2) {
		super(id, peso, lunghezza, colore, compagnia, costo, spazio, scopo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CargoTrenItalia [scopo=" + scopo + ", spazio=" + spazio + ", id=" + id + ", peso=" + peso
				+ ", lunghezza=" + lunghezza + ", costo=" + costo + ", colore=" + colore + ", compagnia=" + compagnia
				+ "]";
	}

}
