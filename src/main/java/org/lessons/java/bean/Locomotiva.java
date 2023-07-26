package org.lessons.java.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "locomotiva")
public class Locomotiva implements Serializable,Bean{
	
	@Id
	@JoinColumn(name = "vagone")
	private int idVagone;
	
	@NotNull(message = "Il peso trainante non può essere vuoto")
	private double pesoTrainante;
	
	@NotNull(message = "Il numero di tecnici non può essere vuoto")
	private double numTecnici;
	
	/*@ManyToOne(name = "vagone")
	@JoinColumn
	private Vagone vagone;*/
	
    
    
    public Locomotiva() {}


	public Locomotiva(int id, float pesoTrainante, int lunghezza) {
		
		this.idVagone = id;
		this.pesoTrainante = pesoTrainante;
		this.numTecnici = lunghezza;
	}


	public int getId() {
		return idVagone;
	}


	public void setId(int id) {
		this.idVagone = id;
	}


	public double getPesoTrainante() {
		return pesoTrainante;
	}


	public void setPesoTrainante(double pesoTrainante) {
		this.pesoTrainante = pesoTrainante;
	}


	public double getNumTecnici() {
		return numTecnici;
	}


	public void setNumTecnici(double numTecnici) {
		this.numTecnici = numTecnici;
	}

	
    
	
}
