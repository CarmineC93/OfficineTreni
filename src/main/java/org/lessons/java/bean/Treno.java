package org.lessons.java.bean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
	
	private double pesoTotale;
	
	private double prezzoTotale;
	
	private double lunghezzaTotale;
	
	private int numVagoni;
	
	private LocalDate dataCreaz;
	
	@Transient
	@OneToMany(mappedBy = "treno")
    private List<Ordine> ordini = new ArrayList<>();
	
	
    //RELATIONS
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "composizione",
            	joinColumns = @JoinColumn(name = "treno"),
            	inverseJoinColumns = @JoinColumn(name = "vagone") 
            	)
	private List<Vagone> vagone;
		
	//CONSTRUCTORS 
	public Treno() {}
	

	//GETTERS & SETTERS
    
	public int getIdTreno() {
		return idTreno;
	}


	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
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
	
	public double getPesoTotale() {
		return pesoTotale;
	}
	
	public void setPesoTotale(double pesoTotale) {
		this.pesoTotale = pesoTotale;
	}

	public double getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	public double getLunghezzaTotale() {
		return lunghezzaTotale;
	}


	public void setLunghezzaTotale(double lunghezzaTotale) {
		this.lunghezzaTotale = lunghezzaTotale;
	}


	public LocalDate getDataCreaz() {
		return dataCreaz;
	}


	public void setDataCreaz(LocalDate dataCreaz) {
		this.dataCreaz = dataCreaz;
	}
	
	public int getNumVagoni() {
		return numVagoni;
	}

	public void setNumVagoni(int numVagoni) {
		this.numVagoni = numVagoni;
	}
	
	public List<Ordine> getOrdini() {
		return ordini;
	}

//metodi per il calcolo di prezzo totale, peso totale, lunghezza totale, numero vagoni totale da sostituire tramite setter
	
    public void calcolaEAggiornaPesoTotale() {
        double pesoTotale = 0.0;

        for (Vagone vagone : this.getVagone()) {
            pesoTotale += vagone.getPeso();
        }

        this.setPesoTotale(pesoTotale);
    }


	public void calcolaEAggiornaPrezzoTotale() {
        double prezzoTotale = 0.0;

        for (Vagone vagone : this.getVagone()) {
            prezzoTotale += vagone.getCosto();
        }

        this.setPrezzoTotale(prezzoTotale);
    }
	
	public void calcolaEAggiornaLunghezza() {
		int lunghezza = 0;
		
		for (Vagone vagone : this.getVagone()) {
			lunghezza += vagone.getLunghezza();
		}
		
		this.setLunghezzaTotale(lunghezza);
	}
	
	public void calcolaEAggiornaNumVagoni() {
		int numVagoni = 0;
		for (Vagone vagone : this.getVagone()) {
			numVagoni += 1;
		}
		this.setNumVagoni(numVagoni);
	}
	
//metodi di formattazione per le view 
	  public String getFormattedDate(){
		  if (this.dataCreaz != null) {
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        return this.dataCreaz.format(formatter);
		    } else {
		        return "N/A";
		    }
	    }
		    
	  public String getFormattedPrezzoTotale() {
		  Locale locale = new Locale("it", "IT");
		  NumberFormat currencyFormatter = DecimalFormat.getCurrencyInstance(locale);
		  return currencyFormatter.format(prezzoTotale);
	  }
	  
	  public String getFormattedPesoTotale() {
		  DecimalFormat pesoFormatter = new DecimalFormat("0.00");
		  return pesoFormatter.format(pesoTotale) + " t";
	  }
	  
	  public String getFormattedLunghezza() {
		  DecimalFormat lunghezzaFormatter = new DecimalFormat("0.00");
		  return lunghezzaFormatter.format(lunghezzaTotale) + " m";
	  }
	  

	  
}