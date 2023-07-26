package org.lessons.java.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ristorante")
public class Ristorante extends Vagone implements Serializable,Bean{ 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVagone;
	
    @Column 
	private int tavoli;

	public Ristorante() {
		super();
	}

	public Ristorante(int idVagone, int tavoli) {
		super();
		this.idVagone = idVagone;
		this.tavoli = tavoli;
	}

	public int getIdVagone() {
		return idVagone;
	}

	public void setIdVagone(int idVagone) {
		this.idVagone = idVagone;
	}

	public int getTavoli() {
		return tavoli;
	}

	public void setTavoli(int tavoli) {
		this.tavoli = tavoli;
	}
	
    
    
}
