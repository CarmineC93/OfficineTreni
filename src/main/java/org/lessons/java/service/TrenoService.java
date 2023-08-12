package org.lessons.java.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.lessons.java.DTO.TrenoDTO;
import org.lessons.java.DTO.VagoneDTO;
import org.lessons.java.bean.Treno;
import org.lessons.java.bean.Vagone;
import org.lessons.java.dao.TrenoDao;
import org.lessons.java.dao.TrenoDaoImp;
import org.springframework.stereotype.Service;

@Service
public class TrenoService {


private TrenoDao dao = new TrenoDaoImp();
	
	
	public void crea (Treno treno) {
		dao.create(treno); 
//		System.out.println("creato l'utente con id: " + id);
	} 
	
	public void update (Treno treno) {
		dao.update(treno); 
//		System.out.println("modificato l'utente con id: " + utente.getId());
	} 	
	
	public void delete(Treno treno) {
		dao.delete(treno);
//		System.out.println("eliminato l'utente con id: " + utente.getId());
	}
			
	public Treno find(int id) {
		return dao.find(id);
	}
	
	public List<Treno> findAll(){
		return dao.findAll();
	}
	
	//metodo per impacchettare dati che voglio mandare tramite json (così anche quando la sessione Hibernate è chiusa, posso averli)
	public List<TrenoDTO> findAllWithVagoni() {
        List<Treno> treni = dao.findAll();
        List<TrenoDTO> trenoDTOs = new ArrayList<>();

        for (Treno treno : treni) {
            TrenoDTO trenoDTO = new TrenoDTO();
            trenoDTO.setIdTreno(treno.getIdTreno());
            trenoDTO.setNome(treno.getNome());
            trenoDTO.setSigla(treno.getSigla());
            trenoDTO.setCompagnia(treno.getCompagnia());

            List<VagoneDTO> vagoneDTOs = new ArrayList<>();
            for (Vagone vagone : treno.getVagone()) {
                VagoneDTO vagoneDTO = new VagoneDTO();
                vagoneDTO.setId(vagone.getId());
                vagoneDTO.setPeso(vagone.getPeso());
                vagoneDTO.setLunghezza(vagone.getLunghezza());
                vagoneDTO.setTipologia(vagone.getTipologia());
                vagoneDTO.setColore(vagone.getColore());
                vagoneDTO.setCompagnia(vagone.getCompagnia());
                vagoneDTO.setCosto(vagone.getCosto());
                vagoneDTO.setCapienza(vagone.getCapienza());
                vagoneDTO.setPesoTrainante(vagone.getPesoTrainante());
                vagoneDTO.setImgBytes(vagone.getImgBytes());

                vagoneDTOs.add(vagoneDTO);
            }

            trenoDTO.setVagoneDTOs(vagoneDTOs);
            trenoDTOs.add(trenoDTO);
        }

        return trenoDTOs;
    }
	
}
