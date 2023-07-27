package org.lessons.java.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.lessons.java.eccezioni.IncompatibleWagonTypologyException;
import org.lessons.java.eccezioni.LocomotiveNotFoundException;
import org.lessons.java.eccezioni.MaxWeightReachedException;
import org.lessons.java.eccezioni.RestaurantAlreadyPresentException;
import org.lessons.java.eccezioni.TrainAlreadyCompletedException;
import org.lessons.java.eccezioni.WagonNeededException;


@Entity
@Table(name = "treno")
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
	
	@NotNull(message = "La sigla non può essere vuota")
	private String sigla;
	
	@NotNull(message = "La compagnia non può essere vuota")
	private String compagnia;
	

	
    //RELATIONS
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "composizione",
            	joinColumns = @JoinColumn(name = "treno"),
            	inverseJoinColumns = @JoinColumn(name = "vagone") 
            	)
	private List<Vagone> vagone;
		

	public Treno() {}
	
//GETTER & SETTER
    
	public Treno(int idTreno,
			String nome,
			Utente utente, String sigla, String compagnia) {
		super();
		this.idTreno = idTreno;
		this.nome = nome;
		this.utente = utente;
		this.sigla = sigla;
		this.compagnia = compagnia;

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

	public List<Vagone> getVagone() {
		return vagone;
	}


	public void setVagone(List<Vagone> vagone) {
		this.vagone = vagone;
	}
	

}