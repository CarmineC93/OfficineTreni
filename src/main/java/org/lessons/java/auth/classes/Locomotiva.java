package org.lessons.java.auth.classes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Locomotiva extends Vagone {

	/**
	 * @author visco
	 */

	// portata
	public float pesoTrainante; // max kg che può trainare
	public int tecnici; // personale a bordo

	public Locomotiva(int id, float peso, float lunghezza, String colore, String compagnia, float costo, float pesoTrainante, int tecnici) {
		// TODO Auto-generated constructor stub
		super(id, peso, lunghezza, colore, compagnia, costo);
		this.tecnici = tecnici;
		this.pesoTrainante = pesoTrainante;
	}

	@Override
	public String toString() {
		return "Locomotiva [pesoTrainante=" + pesoTrainante + ", tecnici=" + tecnici + ", id=" + id + ", peso=" + peso
				+ ", lunghezza=" + lunghezza + ", costo=" + costo + ", colore=" + colore + ", compagnia=" + compagnia
				+ "]";
	}
	
	
}
