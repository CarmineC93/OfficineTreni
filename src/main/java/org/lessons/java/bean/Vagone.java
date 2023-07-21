package org.lessons.java.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Vagone implements Serializable,Bean{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Il peso non può essere vuoto")
	private double peso;
	
	@NotNull(message = "La lunghezza non può essere vuota")
	private double lunghezza;
	
	@NotNull(message = "Il prezzo non può essere vuoto")
	private double prezzo;
	
    //RELATIONS
    @ManyToMany(mappedBy = "composizione")
    private List<Vagone> vagoni;
    
    
    public Vagone() {}


	public Vagone(int id, double peso,
			 double lunghezza,
			 double prezzo, List<Vagone> vagoni) {
		
		this.id = id;
		this.peso = peso;
		this.lunghezza = lunghezza;
		this.prezzo = prezzo;
		this.vagoni = vagoni;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public List<Vagone> getVagoni() {
		return vagoni;
	}


	public void setVagoni(List<Vagone> vagoni) {
		this.vagoni = vagoni;
	}
    
	
    
    
    
    
    
    
    
	
}