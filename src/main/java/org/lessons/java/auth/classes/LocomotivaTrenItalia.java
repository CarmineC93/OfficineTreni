package org.lessons.java.auth.classes;
public class LocomotivaTrenItalia extends Locomotiva {

	public LocomotivaTrenItalia(int id, float peso, float lunghezza, String colore, String compagnia, float costo,
			float pesoTrainante, int tecnici) {
		// TODO Auto-generated constructor stub
		super(id, peso, lunghezza, colore, compagnia, costo, pesoTrainante, tecnici);
	}

	@Override
	public String toString() {
		return "LocomotivaTrenItalia [pesoTrainante=" + pesoTrainante + ", tecnici=" + tecnici + ", id=" + id
				+ ", peso=" + peso + ", lunghezza=" + lunghezza + ", costo=" + costo + ", colore=" + colore
				+ ", compagnia=" + compagnia + "]";
	}

}
