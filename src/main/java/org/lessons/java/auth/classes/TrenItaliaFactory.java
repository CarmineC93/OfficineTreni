package org.lessons.java.auth.classes;
public class TrenItaliaFactory extends VagoneFactory {

	public static Locomotiva creaLocomotiva(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			float pesoTrainante, int tecnici) {
				return new LocomotivaTrenItalia(id, peso, lunghezza, colore, compagnia, costo, pesoTrainante, tecnici);
		// TODO Auto-generated method stub
		
	}

	public static Cargo creaCargo(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			float spazio, String scopo) {
				return new CargoTrenItalia(id, peso, lunghezza, colore, compagnia, costo, spazio, scopo);
		// TODO Auto-generated method stub
		
	}

	public static Passeggeri creaPasseggeri(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			int postiDisponibili, float prezzoPosto, int cuccetteDisponibili, float prezzoCuccetta) {
				return new PasseggeriTrenItalia(id, peso, lunghezza, colore, compagnia, costo, postiDisponibili, prezzoPosto, cuccetteDisponibili, prezzoCuccetta);
		// TODO Auto-generated method stub
		
	}

	public static Ristorante creaRistorante(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			int tavoli) {
				return new RistoranteTrenItalia(id, peso, lunghezza, colore, compagnia, costo, tavoli);
		// TODO Auto-generated method stub
		
	}




}
