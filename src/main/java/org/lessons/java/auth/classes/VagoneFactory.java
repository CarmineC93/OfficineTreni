package org.lessons.java.auth.classes;

public class VagoneFactory {

	/*
	 * treno.compagnia = "TrenItalia"; v = TrenItaliaFactory.chiediDettagliVagone(c,
	 * i); return v;
	 */

	// COSTRUTTORE PER LOCOMOTIVA
	public static Vagone creaVagone(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			float pesoTrainante, int tecnici) {
		// TODO Auto-generated method stub
		if (compagnia.equals("TrenItalia"))
			TrenItaliaFactory.creaLocomotiva(id, peso, lunghezza, colore, compagnia, costo, pesoTrainante, tecnici);
		if (compagnia.equals("Italo"))
			ItaloFactory.creaLocomotiva(id, peso, lunghezza, colore, compagnia, costo, pesoTrainante, tecnici);
		return null;
	}

	// COSTRUTTORE PER CARGO
	public static Cargo creaVagone(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			String scopo, float spazio) {
		// TODO Auto-generated method stub
		if (compagnia.equals("TrenItalia"))
			TrenItaliaFactory.creaCargo(id, peso, lunghezza, colore, compagnia, costo, scopo, spazio);

		if (compagnia.equals("Italo"))
			ItaloFactory.creaCargo(id, peso, lunghezza, colore, compagnia, costo, scopo, spazio);

		return null;
	}

	// COSTRUTTORE PER PASSEGGERI
	public static Vagone creaVagone(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			int postiDisponibili, float prezzoPosto, int cuccetteDisponibili, float prezzoCuccetta) {
		// TODO Auto-generated method stub
		if (compagnia.equals("TrenItalia"))
			TrenItaliaFactory.creaPasseggeri(id, peso, lunghezza, colore, compagnia, costo, postiDisponibili, prezzoPosto, cuccetteDisponibili, prezzoCuccetta);
		if (compagnia.equals("Italo"))
			ItaloFactory.creaPasseggeri(id, peso, lunghezza, colore, compagnia, costo, postiDisponibili, prezzoPosto, cuccetteDisponibili, prezzoCuccetta);
		return null;
	}

	// COSTRUTTORE PER RISTORANTE
	public static Vagone creaVagone(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			int tavoli) {
		// TODO Auto-generated method stub
		if (compagnia.equals("TrenItalia"))
			TrenItaliaFactory.creaRistorante(id, peso, lunghezza, colore, compagnia, costo, tavoli);
		if (compagnia.equals("Italo"))
			ItaloFactory.creaRistorante(id, peso, lunghezza, colore, compagnia, costo, tavoli);
		
		return null;
	}

	/**
	 * @author visco
	 */

}
