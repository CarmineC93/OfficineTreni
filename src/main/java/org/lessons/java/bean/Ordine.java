package org.lessons.java.bean;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ordine implements Serializable, Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrdine;

	@OneToOne
	@JoinColumn(name = "treno")
	private Treno treno;

	@OneToOne
	@JoinColumn(name = "utente")
	private Utente utente;

	@NotNull(message = "La data non può essere vuoto")
	private String data;

	@NotNull(message = "Lo stato non può essere vuoto")
	private String stato;

	@NotNull(message = "Lo stato del pagamento non può essere vuoto")
	private String pagamento;

	@NotNull(message = "L'importo dell'ordine non può essere vuoto")
	private float importo;

	public Ordine() {
	}

	public Ordine(int id, Treno treno, Utente utente, String stato, String pagamento, float importo) {

		this.idOrdine = id;
		this.treno = treno;
		this.utente = utente;
		GregorianCalendar now = new GregorianCalendar();
		this.data = now.YEAR + "-" + now.MONTH + "-" + now.DAY_OF_MONTH;
		this.stato = stato;
		this.pagamento = pagamento;
		this.importo = importo;

	}

}