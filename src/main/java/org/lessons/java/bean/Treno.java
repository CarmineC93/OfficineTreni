package org.lessons.java.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Treno implements Serializable, Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTreno;

	@ManyToOne
	@JoinColumn(name = "utente")
	private Utente utente;

	@NotNull(message = "La sigla non può essere vuoto")
	private String sigla;

	@NotNull(message = "Il nome non può essere vuoto")
	@Size(min = 5, message = "minimo 5 caratteri")
	private String nome;

	@NotNull(message = "Il nome della compagnia non può essere vuoto")
	private String compagnia;

	@OneToMany
	@JoinColumn(name = "ordine")
	private Ordine ordine;

	public Treno() {
	}

	public Treno(int id, String nome, String sigla, String compagnia, Utente utente) {

		this.idTreno = id;
		this.nome = nome;
		this.sigla = sigla;
		this.compagnia = compagnia;
		this.utente = utente;

	}

	public int getIdTreno() {
		return idTreno;
	}

	public void setIdTreno(int idTreno) {
		this.idTreno = idTreno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

//GETTER & SETTER

}