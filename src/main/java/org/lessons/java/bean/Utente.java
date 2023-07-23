package org.lessons.java.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Utente implements Serializable,Bean{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUtente;
	
	@ManyToOne
	@JoinColumn(name = "ruolo")
	private Ruolo ruolo;
	
	@NotBlank(message = "il nome non puo essere vuota")
	@Size(min = 5,message = "minimo 5 caratteri")
	private String nome;

	@NotBlank(message = "il cognome non puo essere vuota")
	@Size(min = 5,message = "minimo 5 caratteri")
	private String cognome;

	@NotBlank(message = "l'email non puo essere vuota")
	@Size(min = 5,message = "minimo 5 caratteri")
	private String email;

	@NotBlank(message = "la password non puo essere vuota")
	@Size(min = 8,message = "minimo 8 caratteri")
	private String password;

	@OneToMany(mappedBy = "utente")
	private List<Treno> treni;
	
	@OneToMany(mappedBy = "utente")
	private List<Ordine> ordini;
	


	public Utente() {}

	public Utente(int id, String email, String nome, String cognome, String password, Ruolo ruolo) {
		this.idUtente = id;
		this.ruolo = ruolo;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Treno> getTreni() {
		return treni;
	}

	public void setTreni(List<Treno> treni) {
		this.treni = treni;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}











}

