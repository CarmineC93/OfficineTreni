package org.lessons.java.auth.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vagone implements VagoneBase{

	@Override
	public String toString() {
		return "Vagone [id=" + id + ", peso=" + peso + ", lunghezza=" + lunghezza + ", costo=" + costo + ", colore="
				+ colore + ", compagnia=" + compagnia + "]";
	}

	/**
	 * @author visco
	 */
	public int id; //id specifico per il vagone
	public float peso; // quanti kg può sopportare
	public float lunghezza; // quanti m è lungo
	public float costo; // quanto costa agganciarlo
	public String colore;  //Azzurro, Rosso, Verde...
	public String compagnia; // Trenitalia o Itaalo

	
	public Vagone(int id, float peso, float lunghezza, String colore, String compagnia, float costo) {
		this.id = id;
		this.peso = peso;
		this.lunghezza = lunghezza;
		this.colore = colore;
		this.compagnia = compagnia;
		this.costo = costo;
	}
	
}
