package org.lessons.java.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
public class Ruolo implements Serializable, Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRuolo;

	@NotBlank
	private String nome;

	@OneToMany(mappedBy = "ruolo")
	private List<Utente> utente;

	public Ruolo() {
	}

	public Ruolo(int id, String nome, List<Utente> utente) {
		this.idRuolo = id;
		this.nome = nome;
		this.utente = utente;
	}

	public int getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(int id) {
		this.idRuolo = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
