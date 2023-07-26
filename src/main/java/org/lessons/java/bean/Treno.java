package org.lessons.java.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Treno implements Serializable,Bean{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTreno;
	
	@NotNull(message = "Il nome non può essere vuoto")
	@Size(min = 5,message = "minimo 5 caratteri")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "utente")
	private Utente utente;
	
	@NotNull(message = "La sigla non può essere vuoto")
	@Size(min = 2,message = "minimo 2 vagoni")
	private String sigla;
	
	@NotNull(message = "La compagnia non può essere vuoto")
	private String compagnia;
	
	
	/*
	@NotNull(message = "Il peso non può essere vuoto")
	private double peso;
	
	@NotNull(message = "La lunghezza non può essere vuota")
	private double lunghezza;
	
	@NotNull(message = "Il prezzo non può essere vuoto")
	private double prezzo;
	*/
	
    //RELATIONS
	@ManyToMany
    @JoinTable(name = "composizione",
            	joinColumns = @JoinColumn(name = "treno"),
            	inverseJoinColumns = @JoinColumn(name = "vagone") 
            	)
    private List<Vagone> composizione;
   
	
	
	public Treno() {}
	




//GETTER & SETTER
    
	public Treno(int idTreno,
			@NotNull(message = "Il nome non può essere vuoto") @Size(min = 5, message = "minimo 5 caratteri") String nome,
			Utente utente, String sigla, String compagnia, List<Vagone> composizione) {
		super();
		this.idTreno = idTreno;
		this.nome = nome;
		this.utente = utente;
		this.sigla = sigla;
		this.compagnia = compagnia;
		this.composizione = composizione;
	}


	public int getIdTreno() {
		return idTreno;
	}


	public void setIdTreno(int id) {
		this.idTreno = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}



	public Utente getUtente() {
		return utente;
	}



	public void setUtente(Utente utente) {
		this.utente = utente;
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
	
	public List<Vagone> getComposizione() {
		return composizione;
	}


	public void setComposizione(List<Vagone> composizione) {
		this.composizione = composizione;
	}

	/*
	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getLunghezza() {
		return lunghezza;
	}


	public void setLunghezza(double lunghezza) {
		this.lunghezza = lunghezza;
	}


	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	*/

	


	
	

	
}