package org.lessons.java.auth.classes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cargo extends Vagone {

	@Override
	public String toString() {
		return "Cargo [scopo=" + scopo + ", spazio=" + spazio + ", id=" + id + ", peso=" + peso + ", lunghezza="
				+ lunghezza + ", costo=" + costo + ", colore=" + colore + ", compagnia=" + compagnia + "]";
	}

	/**
	 * @author visco
	 */

	public String scopo; // tipo merci (animale, farmaci, cibo, posta...)
	public float spazio; // quanti m2 ci sono da riempire


	public Cargo(int id, float peso, float lunghezza, String colore, String compagnia, float costo, float spazio,
			String scopo) {
		// TODO Auto-generated constructor stub
		super(id, peso, lunghezza, colore, compagnia, costo);
		this.scopo = scopo;
		this.spazio = spazio;
	}

	// carica merce e calcola pagamento per trasporto
	public void caricaMerce(float capienza, float kg) {
		if ((spazio >= capienza) && (peso >= kg)) {
			spazio = spazio - capienza;
			peso = peso - kg;
		} else
			System.out.println("Non possiamo caricare la tua merce");

	}

}
