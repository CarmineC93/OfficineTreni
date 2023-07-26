package org.lessons.java.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cargo")
public class Cargo extends Vagone implements Serializable,Bean{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVagone;
	
    @Column(nullable = false )
	private String scopo;

    @Column(nullable = false )
	private float spazio;

    public Cargo() {};

	public Cargo(int idVagone, String scopo, float spazio) {
		super();
		this.idVagone = idVagone;
		this.scopo = scopo;
		this.spazio = spazio;
	}


	public int getIdVagone() {
		return idVagone;
	}


	public void setIdVagone(int idVagone) {
		this.idVagone = idVagone;
	}


	public String getScopo() {
		return scopo;
	}


	public void setScopo(String scopo) {
		this.scopo = scopo;
	}


	public float getSpazio() {
		return spazio;
	}


	public void setSpazio(float spazio) {
		this.spazio = spazio;
	}

    
    
    
    
}
