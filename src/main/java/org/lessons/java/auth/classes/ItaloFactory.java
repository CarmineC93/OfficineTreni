package org.lessons.java.auth.classes;
public class ItaloFactory extends VagoneFactory {

	public static Locomotiva creaLocomotiva(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			float pesoTrainante, int tecnici) {
				return new LocomotivaItalo(id, peso, lunghezza, colore, compagnia, costo, pesoTrainante, tecnici);
		
	}

	public static Cargo creaCargo(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			String scopo, float spazio) {
				return new CargoItalo(id, peso, lunghezza, colore, compagnia, costo, scopo, spazio);
		// TODO Auto-generated method stub
		
	}

	public static Passeggeri creaPasseggeri(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			int postiDisponibili, float prezzoPosto, int cuccetteDisponibili, float prezzoCuccetta) {
				return new PasseggeriItalo(id, peso, lunghezza, colore, compagnia, costo, postiDisponibili, prezzoPosto, cuccetteDisponibili, prezzoCuccetta);return null;
		// TODO Auto-generated method stub
		
	}

	public static Ristorante creaRistorante(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			int tavoli) {
				return new RistoranteItalo(id, peso, lunghezza, colore, compagnia, costo, tavoli);return null;
		// TODO Auto-generated method stub
		
	}

	

	

}
