package org.lessons.java.auth.pojo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

//@Data
@Entity
public class Utente{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "l'email non puo essere vuota")
	@Size(min = 5,message = "minimo 5 caratteri")
	private String email;

	@NotBlank(message = "il nome non puo essere vuota")
	@Size(min = 5,message = "minimo 5 caratteri")
	private String nome;

	@NotBlank(message = "il cognome non puo essere vuota")
	@Size(min = 5,message = "minimo 5 caratteri")
	private String cognome;

	@NotBlank(message = "la password non puo essere vuota")
	@Size(min = 8,message = "minimo 8 caratteri")
	private String password;

	@ManyToOne
	private Ruolo ruolo;


	public Utente() {}

	public Utente(int id, String email, String nome, String cognome, String password) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}











}

