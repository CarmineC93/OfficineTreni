package org.lessons.java.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class Composizione {

	@OneToOne
	@JoinColumn(name = "treno")
	private Treno treno;

	@NotNull
	private int vagone;

	@OneToOne
	@JoinColumn(name = "utente")
	private int posizione;

	@NotNull(message = "La data non può essere vuoto")
	private String tipologia;

	public Composizione() {

	}

	public Composizione(Treno treno, int vagone, int posizione, String tipologia) {
		this.treno = treno;
		this.vagone = vagone;
		this.posizione = posizione;
		this.tipologia = tipologia;
	}
}
