package org.lessons.java.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	private String sigla;
	
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
	/*
	@ManyToMany
    @JoinTable(
            name = "composizione",
            joinColumns = @JoinColumn(name = "treno_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "vagone_id", referencedColumnName="id") 
            )
    private List<Vagone> composizione;
    */
	public Treno() {}
	
	
	
	
	

  public Treno(int id,
			String nome) {
		
		this.idTreno = id;
		this.nome = nome;
		
		
	}






//GETTER & SETTER
    
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

	/*

	public List<Vagone> getComposizione() {
		return composizione;
	}


	public void setComposizione(List<Vagone> composizione) {
		this.composizione = composizione;
	}
	
	*/

	
}