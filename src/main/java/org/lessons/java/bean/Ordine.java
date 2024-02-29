package org.lessons.java.bean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ordine")
public class Ordine implements Serializable, Bean {

	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

 	private String stato;
    
    private LocalDateTime data;
    
    private double importo;

    @Transient
    private String formattedDateTime; 
    
	//RELATIONS
    
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "treno_id")
    private Treno treno;
    
    //CONSTRUCTORS
    public Ordine () {}
    
	public Ordine(String stato, Utente utente, Treno treno, LocalDateTime data, double importo) {
		super();
		this.stato = stato;
		this.utente = utente;
		this.treno = treno;
		this.data = data;
		this.importo = importo;
	}

	
	//GETTER & SETTER
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getStato() {
		return stato;
	}


	public void setStato(String stato) {
		this.stato = stato;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Treno getTreno() {
		return treno;
	}

	public void setTreno(Treno treno) {
		this.treno = treno;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public String getFormattedDateTime() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	    return data.format(formatter);
	}

	public void setFormattedDateTime(String formattedDateTime) {
		this.formattedDateTime = formattedDateTime;
	}
    
    public String getFormattedImporto() {
        Locale locale = new Locale("it", "IT");
        NumberFormat currencyFormatter = DecimalFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(importo);
    }
	
}
