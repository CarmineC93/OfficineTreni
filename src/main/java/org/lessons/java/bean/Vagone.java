package org.lessons.java.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.web.multipart.MultipartFile;

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
	
	private double costo;
	
	private int capienza;
	
	private double pesoTrainante;
	 
    private byte[] imgBytes;
    
	@Transient
    private MultipartFile img;
    
	@Transient
    private String base64Image;
    
	//RELAZIONE



	@ManyToMany(mappedBy = "vagone")
    private List<Treno> treno;
    


	public Vagone() {}





	
	public Vagone(@NotNull(message = "Il peso non può essere vuoto") double peso,
			@NotNull(message = "La lunghezza non può essere vuota") double lunghezza, char tipologia, String colore,
			String compagnia, double costo, int capienza, double pesoTrainante) {
		super();
		this.peso = peso;
		this.lunghezza = lunghezza;
		this.tipologia = tipologia;
		this.colore = colore;
		this.compagnia = compagnia;
		this.costo = costo;
		this.capienza = capienza;
		this.pesoTrainante = pesoTrainante;
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

    public void setImg(MultipartFile img) {
		this.img = img;
	}
    
	   
    public MultipartFile getImg() {
		return img;
	}


	

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

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public double getPesoTrainante() {
		return pesoTrainante;
	}

	public void setPesoTrainante(double pesoTrainante) {
		this.pesoTrainante = pesoTrainante;
	}

	public byte[] getImgBytes() {
		return imgBytes;
	}

	public void setImgBytes(byte[] imgBytes) {
		this.imgBytes = imgBytes;
	}

	
	
	public String getBase64Image() {
		return base64Image;
	}



	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
    
    
    
    
    
    
	
}