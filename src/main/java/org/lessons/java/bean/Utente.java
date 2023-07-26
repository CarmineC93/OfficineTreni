package org.lessons.java.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name= "utente")
public class Utente implements Serializable, Bean{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "l'email non puo essere vuota")
	@Size(min = 5,message = "minimo 5 caratteri")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "il nome non puo essere vuota")
	@Size(min = 5,message = "minimo 5 caratteri")
	private String nome;

	@NotBlank(message = "il cognome non puo essere vuota")
	@Size(min = 5,message = "minimo 5 caratteri")
	private String cognome;

	@NotBlank(message = "la password non puo essere vuota")
	@Size(min = 8,message = "minimo 8 caratteri")
	private String password;

	//RELATIONS
	
	@ManyToMany
	@JoinTable(name = "utente_ruolo",
			joinColumns = @JoinColumn(name = "id_utente"),
			inverseJoinColumns = @JoinColumn(name = "id_ruolo")
	)
    private Set<Ruolo> ruolo;

	
	//CONSTRUCTORS
	


    //GETTER & SETTER

	
	public int getIdUtente() {
		return id;
	}

	public void setIdUtente(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Ruolo> getRuolo() {
		return ruolo;
	}

	public void setRuolo(Set<Ruolo> ruolo) {
		this.ruolo = ruolo;
	}
}

