package org.lessons.java.auth.classes;
import java.util.ArrayList;
import utility.*;
import eccezioni.*;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Treno {

	@Override
	public String toString() {
		return "Treno [sigla=" + sigla + ", ambito=" + ambito + ", carrozze=" + carrozze + ", provenienza="
				+ provenienza + ", destinazione=" + destinazione + ", partenza=" + partenza + ", arrivo=" + arrivo
				+ ", binario=" + binario + ", ritardo=" + ritardo + ", getSigla()=" + getSigla() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	/**
	 * @author visco
	 */

	public String sigla; // codice identificativo treno
	public String ambito; // nazionale, regionale...
	public String compagnia; //TrenItalia o Italo
	public ArrayList<Vagone> carrozze = new ArrayList<>(); // numero vagoni
	public String provenienza, destinazione; // stazioni
	public GregorianCalendar partenza, arrivo; // orari
	public int binario; // binario di partenza
	public int ritardo; // tempo di ritardo

	public Treno(Vagone... vagone) {
		String codice = "";
		for (Vagone v : vagone) {
			this.carrozze.add(v);
			codice = codice + v.getClass().getName().substring(0, 1);
		}
		sigla = codice;
	}

	public String getSigla() {
		return sigla;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public void setPartenza(GregorianCalendar partenza) {
		this.partenza = partenza;
	}

	public void setArrivo(GregorianCalendar arrivo) {
		this.arrivo = arrivo;
	}

	public void setBinario(int binario) {
		this.binario = binario;
	}

	public void setRitardo(int ritardo) {
		this.ritardo = ritardo;
	}

	public void agganciaVagone(char c, Vagone v) {
		this.carrozze.add((Vagone) v);
		this.sigla = this.sigla + c;
	}

	// passato un vagone, lo aggiunge in coda
	public boolean accodaVagone(VagoneBase vagone) throws Exception {
		String aggiunta = vagone.getClass().getName().substring(0, 1);
		aggiunta.toUpperCase();

		System.out.println("Vuoi aggiungere questo vagone: " + aggiunta);
		System.out.println("In quale posizione?");
		System.out.println(this.sigla);

		Assemblaggio.scelta = sigla;
		int xl = Tools.contaCaratteri(this.sigla, 'L');
		Assemblaggio.scelta = "";
		
		//pesototale

		int minpos = 1;
		int maxpos = 0;

		System.out.print("x");
		if (xl == 1) {
			for (int i = 0; i < sigla.length(); i++) {
				System.out.print((i + 1));
			}
			maxpos = sigla.length();
		}
		if (xl == 2) {
			for (int i = 0; i < sigla.length() - 1; i++) {
				System.out.print((i + 1));
			}
			System.out.print("x");
			maxpos = sigla.length() - 1;
		}

		boolean pos = false;
		String posizione = "";

		while (pos == false) {
			System.out.print("\nValori accettati nell'intervallo " + minpos + " - " + maxpos + "\n");
			try {
			posizione = Assemblaggio.in.next();
			}
			catch (NumberFormatException e) {
				System.err.println("Ma che ti piace?");
			}
			int dgtpos = 0;
				dgtpos = Integer.parseInt(posizione);
				if ((dgtpos >= minpos) && (dgtpos <= maxpos)) {
					pos = true;
					System.out.println("Posizione scelta: " + dgtpos);
					String appoggio1 = "";
					for (int i = 0; i < dgtpos; i++) {
						appoggio1 = appoggio1 + sigla.charAt(i);
					}

					String appoggio = appoggio1.toLowerCase() + aggiunta.toUpperCase();

					String appoggio2 = "";
					for (int i = dgtpos; i < sigla.length(); i++) {
						appoggio2 = appoggio2 + sigla.charAt(i);
					}

					appoggio = appoggio + appoggio2.toLowerCase();

					System.out.println("Il nuovo treno sarà così composto:");
					System.out.println(appoggio);
					Assemblaggio.scelta = appoggio;
					System.out.println("Proviamo ad aggiungerlo...\n");
					TrenoBuilder.proceduraCreazione(Assemblaggio.scelta);
					return true;
				} else
					throw new ValoreFuoriRange("Il valore immesso è fuori range.");

		}
		return false;
	}

	public void sganciaVagone() throws Exception {
		System.out.println("Quale vagone vuoi sganciare?\n");
		boolean sgancia = false;
		while (sgancia == false) {
			System.out.println("Quale vagone vuoi sganciare?");
			System.out.println(this.sigla);

			Assemblaggio.scelta = sigla;
			int xl = Tools.contaCaratteri(Assemblaggio.scelta, 'L');
			Assemblaggio.scelta = "";

			int minpos = 1;
			int maxpos = 0;

			if (xl == 1) {
				System.out.print("x");
				for (int i = 0; i < sigla.length() - 1; i++) {
					System.out.print((i + 1));
				}
				maxpos = sigla.length();
			}
			if (xl == 2) {
				for (int i = 0; i < sigla.length(); i++) {
					System.out.print((i + 1));
				}
				maxpos = sigla.length() - 1;
			}

			System.out.println("");
			String posizione = Assemblaggio.in.next();
			int dgtpeso = 0;
			
				dgtpeso = Integer.parseInt(posizione);
				if ((dgtpeso >= minpos) && (dgtpeso <= maxpos)) {
					sgancia = true;
					String appoggio1 = "";
					for (int i = 0; i < dgtpeso; i++) {
						appoggio1 = appoggio1 + sigla.charAt(i);
					}

					String appoggio2 = "";
					for (int i = dgtpeso + 1; i < sigla.length(); i++) {
						appoggio2 = appoggio2 + sigla.charAt(i);
					}

					appoggio1 = appoggio1 + appoggio2.toLowerCase();

					System.out.println("Il nuovo treno sarà così composto:");
					System.out.println(appoggio1);
					Assemblaggio.scelta = appoggio1;
					TrenoBuilder.proceduraCreazione(Assemblaggio.scelta);
				} else
					System.out.println("Il valore da te inserito non rientra nell'intervallo, riprova!");

		}
	}

	// annuncio del treno nelle stazioni
	public void annunciaFermata() {
		System.out.print("Il treno " + ambito + " " + sigla + " diretto a " + destinazione);
		System.out.print(" partirà alle " + partenza.HOUR + ":" + partenza.MINUTE + " dal binario " + binario);
		arrivo.add(arrivo.MINUTE, ritardo);
		if (ritardo == 0) {
			System.out.println(" arriverà alle " + arrivo.HOUR + ":" + arrivo.MINUTE);
		} else {
			System.out.println(
					" arriverà, con " + ritardo + " minuti di ritardo, alle " + arrivo.HOUR + ":" + arrivo.MINUTE);
		}
	}

	

}
