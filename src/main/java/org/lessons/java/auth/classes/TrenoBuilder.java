package org.lessons.java.auth.classes;

import org.lessons.java.utility.*;
import org.lessons.java.exceptions.*;

public class TrenoBuilder {

	public static void proceduraCreazione(String scelta) throws Exception {
		// TODO Auto-generated method stub

		String attesa = "Attendi, sto costruendo il tuo treno... ";
		System.out.println(attesa);

		Tools.caricamento(attesa);
		System.out.println();

		String combotreno = scelta.toUpperCase();

		combotreno = combotreno.replace('H', 'L');
		System.out.println(combotreno);

		controllaStruttura(combotreno);
		Treno treno = new Treno();
		TrenoBuilder.costruzioneTreno(treno, combotreno);
		boolean frattempoportata = false;
		while (frattempoportata == false) {
			try {
				frattempoportata = sceltaLocomotiva(treno);
			} catch (PesoNonSupportato e) {
				System.err.println(e.getMessage());
			}
		}

		 for (Vagone v : treno.carrozze) { System.out.println(v.toString()); }

	}

	private static boolean sceltaLocomotiva(Treno treno) throws Exception {
		// TODO Auto-generated method stub
		double pesototaletreno = 0;
		for (int i = 0; i < treno.carrozze.size(); i++) {
			pesototaletreno = pesototaletreno + treno.carrozze.get(i).peso;
		}

		int xl = Tools.contaCaratteri(treno.sigla, 'L');

		System.out.println("Il tuo treno ha " + treno.sigla.length() + " vagoni, per un peso complessivo di "
				+ pesototaletreno + " kg");

		String portata;
		boolean spportata = false;
		boolean boolportata = false;
		int dgtportata = 0;

		while (boolportata == false) {
			dgtportata = 0;
			spportata = false;
			while (spportata == false) {
				System.out.print(
						"Specifica un valore di portata per le locomotive maggiore di " + pesototaletreno + "\n");

				// può dare problemi
				try {
					portata = Assemblaggio.in.next();
					dgtportata = Integer.parseInt(portata);
					spportata = true;
					boolportata = true;
				} catch (NumberFormatException e) {
					spportata = false;
					System.err.println("Hai inserito lettere o simboli, qui puoi inserire solo numeri.");
				}
			}

			if (dgtportata > pesototaletreno - 1) {
				boolportata = true;
				if (xl == 1) {
					Locomotiva l = (Locomotiva) treno.carrozze.get(0);
					((Locomotiva) l).setPortata(dgtportata);
					treno.carrozze.set(0, l);
					Assemblaggio.tentativi = true;
					Assemblaggio.scelta = "";
					return true;
				}
				if (xl == 2) {
					Locomotiva l = (Locomotiva) treno.carrozze.get(0);
					((Locomotiva) l).setPortata(dgtportata);
					treno.carrozze.set(0, l);
					l = (Locomotiva) treno.carrozze.get(treno.carrozze.size() - 1);
					((Locomotiva) l).setPortata(dgtportata);
					treno.carrozze.set(treno.carrozze.size() - 1, l);
					Assemblaggio.tentativi = true;
					Assemblaggio.scelta = "";
					return true;
				}

			} else if (!(dgtportata == 0)) {
				boolportata = false;
				spportata = false;
				throw new PesoNonSupportato("La tua locomotiva non supporta il peso richiesto!\n");
				// nell'intervallo, riprova!");
				// System.out.println("Il valore da te inserito non rientra nell'intervallo,
				// riprova!");
			}
		}
		return false;

	}

	private static void controllaStruttura(String scelta) throws Exception {
		// TODO Auto-generated method stub
		String apg = controllaLocomotiva(scelta);
		controllaTipologia(apg);

		// altri
	}

	private static void controllaTipologia(String scelta) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int qc = Tools.contaCaratteri(scelta, 'C');
		int qr = Tools.contaCaratteri(scelta, 'R');
		int qp = Tools.contaCaratteri(scelta, 'P');

		if ((qp == 0) && (qr == 0)) {
			// qc almeno 1, perchè lunghezza minima 3 - 2 (loc max) = 1 altro vagone è per
			// forza c
			System.out.println("Il treno è un treno merci.");
		}

		if ((qc > 0) && ((qr > 0) || (qp > 0))) {
			System.err.println("Il treno ha vagoni non compatibili tra loro.");
			if ((qr > 0) && (qp > 0)) {
				throw new MixCPR("Contiene vagoni cargo in combo con carrozze passeggeri e ristorante.");
				// Assemblaggio.elaboraStringa("Ritenta...");
			}
			if ((qr == 0) && (qp > 0)) {
				throw new MixCP("Contiene vagoni cargo mischiati a carrozze passeggeri.");

			}
			if ((qr > 0) && (qp == 0)) {
				throw new MixCR("Contiene vagoni cargo mischiati a carrozze ristorante.");

			}
		}

		if ((qr > 0) && (qc == 0) && (qp == 0)) {
			throw new TuttiRistorante("Il tuo treno contiene solo vagoni ristorante...\n");
		}

		if (qc == 0) {
			System.out.println("Il treno è un treno passeggeri.");
			try {
				controllaRistorante(scelta, qr);
			} catch (RistoranteNonAlCentro e) {
				System.err.println(e.getMessage());
				Assemblaggio.elaboraStringa("Ripartiamo...");
			}
		}

	}

	private static void controllaRistorante(String scelta, int qr) throws Exception {
		// TODO Auto-generated method stub
		int ql = Tools.contaCaratteri(scelta, 'L');

		if (qr == 0) {
			String stampa = "Nel tuo treno non sono presenti vagoni ristorante.";
			System.out.println(stampa);
			Tools.caricamento(stampa);
			System.out.println();
		}
		if (qr > 1) {
			throw new TroppiRistoranti("Hai inserito troppi vagoni ristorante, puoi inserirne solo uno.");

		}

		int posris = -1;

		if (qr == 1) {
			// verifico posizione ristorante
			while (posris == -1) {
				for (int i = 0; i < scelta.length(); i++) {
					if (Character.compare(scelta.charAt(i), 'R') == 0) {
						posris = i;
					}
				}
			}

			int minpos = 0;
			int maxpos = 0;

			int lunghezzatreno = scelta.length() - ql;

			if (lunghezzatreno % 2 == 0) {
				if (ql == 1) {
					minpos = (scelta.length() / 2);
					maxpos = (scelta.length() / 2) + 3;
				}
				if (ql == 2) {
					minpos = (scelta.length() / 2) - 1;
					maxpos = (scelta.length() / 2) + 2;
				}
			} else {
				minpos = scelta.length() / 2;
				maxpos = (scelta.length() / 2) + 2;
			}

			if ((posris >= minpos) && (posris <= maxpos)) {
				System.out.println(scelta);
				String print = "Il vagone ristorante è giustamente al centro del tuo treno passeggeri.";
				System.out.println(print);
				Tools.caricamento(print);
				System.out.println();
			} else {
				System.out.println(scelta);
				throw new RistoranteNonAlCentro(
						"Il tuo vagone ristorante non è stato posizionato fra i vagoni centrali.\n");
			}
		}

	}

	private static String controllaLocomotiva(String scelta2) throws Exception {
		// TODO Auto-generated method stub
		boolean inizio = false, fine = false;
		String rico = "Ricomincia...";

		System.out.println("Controlliamo che sia presente almeno una locomotiva...");
		System.out.println("Ricorda: una L deve essere per forza presente:");
		System.out.println("- all'inizio (L...);");
		System.out.println("- alla fine (...L);");
		String stampa = "- all'inizio ed alla fine (L...L).";
		System.out.println(stampa);
		Tools.caricamento(stampa);
		System.out.println();

		int quantel = Tools.contaCaratteri(scelta2, 'L');

		if (quantel == 0) {
			throw new SenzaLocomotive(
					"Il tuo treno non ha locomotive.\\nReimmetti una sequenza in un formato corretto!\n");
		}

		if (quantel == 1) {
			if (Character.compare('L', scelta2.charAt(0)) == 0) {
				inizio = true;
			}
			if (Character.compare('L', scelta2.charAt(scelta2.length() - 1)) == 0) {
				fine = true;
			}
			if (inizio == fine) {
				inizio = false;
				fine = inizio;
				throw new LocomotivaCentrale(
						"Il tuo treno non ha locomotive.\\nReimmetti una sequenza in un formato corretto!\n");
			}
			if ((inizio == true) && (fine == false)) {
				String stampa3 = "Locomotiva all'inizio (L...).";
				System.out.println(stampa3);
				Tools.caricamento(stampa3);
				System.out.println();
			}
			if ((inizio == false) && (fine == true)) {
				System.out.println("Locomotiva trovata alla fine del tuo treno (...L).");
				System.out.println("Il tuo treno cambia direzione:");
				String stampa2 = "Prima era " + scelta2 + ", ora è ";
				String contrario = "";
				for (int i = scelta2.length() - 1; i >= 0; i--) {
					contrario = contrario + scelta2.charAt(i);
				}
				scelta2 = contrario;
				Assemblaggio.scelta = scelta2;
				stampa2 = stampa2 + scelta2;
				System.out.println(stampa2);
				Tools.caricamento(stampa2);
				System.out.println();

			}
		}

		if (quantel == 2) {
			if (Character.compare('L', scelta2.charAt(0)) == 0) {
				inizio = true;
			}
			if (Character.compare('L', scelta2.charAt(scelta2.length() - 1)) == 0) {
				fine = true;
			}
			if ((inizio == true) && (true == fine)) {
				String stampa4 = "Una locomotiva è presente ad entrambe le estremità (L...L).";
				System.out.println(stampa4);
				System.out.println();
			} else {
				throw new LocomotivaCentrale("Una delle due locomotive ricopre una posizione centrale nel tuo treno.");

			}
		}

		if (quantel > 2) {
			throw new TroppeLocomotive("Hai inserito troppe locomotive.\nImmetti una sequenza nel formato corretto.");

		}
		return scelta2;

		// TODO Auto-generated method stub

	}

	public static void costruzioneTreno(Treno treno, String combotreno) throws Exception {
		// TODO Auto-generated method stub
		treno.sigla = "";
		treno.carrozze.clear();

		String compagnia = "";
		while (compagnia.equals("")) {
			try {
				compagnia = chiediCompagnia();
			} catch (ValoreFuoriRange e) {
				System.err.println(e.getMessage());
			}

		}

		// qui potrei chiedere la compagnia
		// costruzioneLocomotive(?)

		for (int i = 0; i < combotreno.length(); i++) {
			char c = combotreno.charAt(i);
			if ((Character.compare(c, 'L') == 0) || (Character.compare(c, 'H') == 0)) {
				Vagone locomotiva = VagoneFactory.creaVagone(treno, 'L', i, compagnia);
				specificaLocomotiva(locomotiva);
				System.out.println("LOCOMOTIVA: " + locomotiva.toString());
				treno.agganciaVagone('L', locomotiva);
			}

			if ((Character.compare(c, 'P') == 0)) {
				Vagone passeggeri = VagoneFactory.creaVagone(treno, 'P', i, compagnia);
				// specificaPasseggeri(passeggeri);
				System.out.println("PASSEGGERI: " + passeggeri.toString());
				treno.agganciaVagone('P', passeggeri);
			}

			if ((Character.compare(c, 'R') == 0)) {
				Vagone ristorante = VagoneFactory.creaVagone(treno, 'R', i, compagnia);
				// specificaRistorante(ristorante);
				System.out.println("RISTORANTE: " + ristorante.toString());
				treno.agganciaVagone('R', ristorante);
			}

			if ((Character.compare(c, 'C') == 0)) {
				Vagone cargo = VagoneFactory.creaVagone(treno, 'C', i, compagnia);
				// specificaCargo(cargo);
				System.out.println("CARGO: " + cargo.toString());
				treno.agganciaVagone('C', cargo);
			}
		}

		System.out.println("Treno creato: " + treno.sigla);
		Assemblaggio.treno = treno;

	}

	private static void specificaLocomotiva(Vagone locomotiva) {
		// TODO Auto-generated method stub

	}

	private static String chiediCompagnia() throws Exception {
		// TODO Auto-generated method stub
		String compagnia = "";
		boolean boolcompagnia = false;
		boolean boolformato = false;

		// TODO Auto-generated method stub
		while (boolcompagnia == false) {
			int dgtcompagnia = 0;
			String ti = "TrenItalia";
			String i = "Italo";
			while (dgtcompagnia == 0) {
				System.out.print("\nDi che compagnia è il tuo treno?\n");

				System.out.println("1 - " + ti + "\n2 - " + i);
				compagnia = Assemblaggio.in.next();
				try {
					dgtcompagnia = Integer.parseInt(compagnia);
					boolformato = true;
				} catch (NumberFormatException e) {
					boolcompagnia = true;
					boolformato = false;

					System.err.println(
							"Hai digitato: \"" + compagnia + "\". Hai inserito caratteri, non numeri. Riprova!");
					// TODO: handle exception
				}

				if ((boolformato == true) && (dgtcompagnia > 0) && (dgtcompagnia < 3)) {
					boolcompagnia = true;
					System.out.print("Compagnia scelta: ");
					if (dgtcompagnia == 1) {
						System.out.println(ti);
						return ti;
					} else {
						System.out.println(i);
						return i;
					}
				} else {
					boolcompagnia = false;
					if (boolformato)
						throw new ValoreFuoriRange(
								"Hai digitato: \"" + dgtcompagnia + "\".Digita un numero compreso tra 1 e 2.");
				}
			}
		}

		return "";

	}

}
