package org.lessons.java.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passeggeri")
public class Passeggeri {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVagone;
	
    @Column(nullable = false, unique = true)
	private int postiDisponibili;

    @Column(nullable = false, unique = true)
	private double prezzoPosto;
    
    @Column(nullable = false, unique = true)
	private int cuccettaDisponibili;

    @Column(nullable = false, unique = true)
	private double prezzoCuccetta;

	public Passeggeri() {
		super();
	}

	public Passeggeri(int idVagone, int postiDisponibili, double prezzoPosto, int cuccettaDisponibili,
			double prezzoCuccetta) {
		super();
		this.idVagone = idVagone;
		this.postiDisponibili = postiDisponibili;
		this.prezzoPosto = prezzoPosto;
		this.cuccettaDisponibili = cuccettaDisponibili;
		this.prezzoCuccetta = prezzoCuccetta;
	}

	public int getIdVagone() {
		return idVagone;
	}

	public void setIdVagone(int idVagone) {
		this.idVagone = idVagone;
	}

	public int getPostiDisponibili() {
		return postiDisponibili;
	}

	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	public double getPrezzoPosto() {
		return prezzoPosto;
	}

	public void setPrezzoPosto(double prezzoPosto) {
		this.prezzoPosto = prezzoPosto;
	}

	public int getCuccettaDisponibili() {
		return cuccettaDisponibili;
	}

	public void setCuccettaDisponibili(int cuccettaDisponibili) {
		this.cuccettaDisponibili = cuccettaDisponibili;
	}

	public double getPrezzoCuccetta() {
		return prezzoCuccetta;
	}

	public void setPrezzoCuccetta(double prezzoCuccetta) {
		this.prezzoCuccetta = prezzoCuccetta;
	}
    
    
}
