package org.lessons.java.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;


@Entity
@Table(name = "ruolo")
public class Ruolo implements Serializable,Bean{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(nullable = false, unique = true)
	private String nome;


    // Add the default constructor
    public Ruolo() {
    }
    
	public Ruolo(int id,String nome) {
		this.id = id;
		this.nome = nome;
	}


	public int getIdRuolo() {
		return id;
	}


	public void setIdRuolo(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

}
