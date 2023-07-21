package org.lessons.java.auth.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passeggeri extends Vagone {

	@Override
	public String toString() {
		return "Passeggeri [postiDisponibili=" + postiDisponibili + ", prezzoPosto=" + prezzoPosto
				+ ", cuccetteDisponibili=" + cuccetteDisponibili + ", prezzoCuccetta=" + prezzoCuccetta + ", id=" + id
				+ ", peso=" + peso + ", lunghezza=" + lunghezza + ", costo=" + costo + ", colore=" + colore
				+ ", compagnia=" + compagnia + "]";
	}

	/**
	 * @author visco
	 */

	public int postiDisponibili; // prezzo del biglietto
	public float prezzoPosto; // posti a sedere
	public int cuccetteDisponibili; // prezzo del biglietto
	public float prezzoCuccetta; // posti-letto

	public Passeggeri(float peso, float lunghezza, float costo, String colore, String compagnia, float costo2, int postiDisponibili, float prezzoPosto, int cuccetteDisponibili, float prezzoCuccetta) {
		// TODO Auto-generated constructor stub
		super(peso, lunghezza, costo, colore, compagnia);
		this.postiDisponibili = postiDisponibili;
		if (postiDisponibili == 0) {
			this.prezzoPosto = 0;
		}
		else this.prezzoPosto = prezzoPosto;
		this.cuccetteDisponibili = cuccetteDisponibili;
		if (cuccetteDisponibili == 0) {
			this.prezzoCuccetta = 0;
		}
		else this.prezzoCuccetta = prezzoCuccetta;
	}

	// aggiorna prezzo per cuccia
	public void setPrezzoCuccia(int prezzo) {
		if (cuccetteDisponibili == 0) {
			System.out.println("Cuccette non disponibili");
		} else
			prezzoCuccetta = prezzo;
	}

	// aggiorna prezzo per posto
	public void setPrezzoPosto(int prezzo) {
		if (postiDisponibili == 0) {
			System.out.println("Posti non disponibili");
		} else
			prezzoPosto = prezzo;
	}

	// prenota posto
	public void prenotaPosti(int posti) {
		if (this.postiDisponibili > posti) {
			this.postiDisponibili = this.postiDisponibili - posti;
		} else
			System.out.println("Non sono disponibili " + posti + " posti a sedere in questa carrozza.\nNe sono rimasti " + postiDisponibili + ".");
	}

	// prenota cuccia
	public void prenotaCuccette(int posti) {
		if (this.cuccetteDisponibili > posti) {
			this.cuccetteDisponibili = this.cuccetteDisponibili - posti;
		} else
			System.out.println("Non sono disponibili " + posti + "posti letto in questa carrozza notte\nNe sono rimasti " + cuccetteDisponibili + ".");
		
	}

}
