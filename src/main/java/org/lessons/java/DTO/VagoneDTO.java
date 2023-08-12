package org.lessons.java.DTO;

public class VagoneDTO {
    private int id;
    private double peso;
    private double lunghezza;
    private char tipologia;
    private String colore;
    private String compagnia;
    private double costo;
    private int capienza;
    private double pesoTrainante;
    private byte[] imgBytes;
    
    
    
	public VagoneDTO() {
		super();
	}


	public VagoneDTO(int id, double peso, double lunghezza, char tipologia, String colore, String compagnia,
			double costo, int capienza, double pesoTrainante, byte[] imgBytes) {
		super();
		this.id = id;
		this.peso = peso;
		this.lunghezza = lunghezza;
		this.tipologia = tipologia;
		this.colore = colore;
		this.compagnia = compagnia;
		this.costo = costo;
		this.capienza = capienza;
		this.pesoTrainante = pesoTrainante;
		this.imgBytes = imgBytes;
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

 

    
    
}
