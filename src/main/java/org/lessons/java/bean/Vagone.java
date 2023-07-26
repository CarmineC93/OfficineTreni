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
@Table(name = "vagone")
public class Vagone implements Serializable,Bean{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Il peso non può essere vuoto")
	private double peso;
	
	@NotNull(message = "La lunghezza non può essere vuota")
	private double lunghezza;
	
	private char tipologia;
	
	private String colore;
	
	private String compagnia;
	
	private int costo;
	
	private int capienza;
	
	private int pesoTrainante;
	
//	@NotNull(message = "Il prezzo non può essere vuoto")
//	private double prezzo;
	
	//RELAZIONE
	
    
    
    
    //RELATIONS
//    @OneToMany(mappedBy = "vagone")
//	private List<Vagone> vagone;
    
    @ManyToMany(mappedBy = "vagone")
    private List<Treno> treno;
    
    
   
    public Vagone() {}

	public Vagone(int id, double peso,
			 double lunghezza, double prezzo
			 ) {
		//, List<Vagone> vagoni
		this.id = id;
		this.peso = peso;
		this.lunghezza = lunghezza;
//		this.prezzo = prezzo;
		//this.vagoni = vagoni;
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


//	public double getPrezzo() {
//		return prezzo;
//	}
//
//
//	public void setPrezzo(double prezzo) {
//		this.prezzo = prezzo;
//	}

	

	public List<Treno> getTreno() {
		return treno;
	}

	public void setTreno(List<Treno> treno) {
		this.treno = treno;
	}

	public char getTipologia() {
		return tipologia;
	}

	public void setTipologia(char tipologia) {
		this.tipologia = tipologia;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public int getPesoTrainante() {
		return pesoTrainante;
	}

	public void setPesoTrainante(int pesoTrainante) {
		this.pesoTrainante = pesoTrainante;
	}

	
	
	
//
//	public List<Vagone> getVagoni() {
//		return vagone;
//	}
//
//
//	public void setVagoni(List<Vagone> vagone) {
//		this.vagone = vagone;
//	}
    

    
    
    
    
    
    
	
}