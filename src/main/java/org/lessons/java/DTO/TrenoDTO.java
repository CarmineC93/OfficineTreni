package org.lessons.java.DTO;

import java.time.LocalDate;
import java.util.List;

public class TrenoDTO {
	    private int idTreno;
	    private String nome;
	    private String sigla;
	    private String compagnia;
	    private List<VagoneDTO> vagoneDTOs;
	    private double pesoTotale;
	    private double prezzoTotale;
	    private double lunghezzaTotale;
	    private int numVagoni; 
	    private LocalDate dataCreaz;

	    // Costruttori, getter e setter
	    public TrenoDTO( ) {}


		public int getIdTreno() {
			return idTreno;
		}

		public void setIdTreno(int idTreno) {
			this.idTreno = idTreno;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
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

		public List<VagoneDTO> getVagoneDTOs() {
			return vagoneDTOs;
		}

		public void setVagoneDTOs(List<VagoneDTO> vagoneDTOs) {
			this.vagoneDTOs = vagoneDTOs;
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

		public int getNumVagoni() {
			return numVagoni;
		}

		public void setNumVagoni(int numVagoni) {
			this.numVagoni = numVagoni;
		}

		public LocalDate getDataCreaz() {
			return dataCreaz;
		}

		public void setDataCreaz(LocalDate dataCreaz) {
			this.dataCreaz = dataCreaz;
		}
	    
	    
}
