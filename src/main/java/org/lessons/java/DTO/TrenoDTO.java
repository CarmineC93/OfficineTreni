package org.lessons.java.DTO;

import java.util.List;

public class TrenoDTO {
	    private int idTreno;
	    private String nome;
	    private String sigla;
	    private String compagnia;
	    private List<VagoneDTO> vagoneDTOs;

	    // Costruttori, getter e setter
	    public TrenoDTO( ) {}

	    public TrenoDTO(int idTreno, String nome, String sigla, String compagnia, List<VagoneDTO> vagoneDTOs) {
	    	super();
	    	this.idTreno = idTreno;
	    	this.nome = nome;
	    	this.sigla = sigla;
	    	this.compagnia = compagnia;
	    	this.vagoneDTOs = vagoneDTOs;
	    }

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
	    
	    
}
