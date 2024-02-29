package org.lessons.java.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.lessons.java.DTO.TrenoDTO;
import org.lessons.java.DTO.VagoneDTO;
import org.lessons.java.bean.Treno;
import org.lessons.java.bean.Utente;
import org.lessons.java.bean.Vagone;
import org.lessons.java.dao.BaseDao;
import org.lessons.java.dao.TrenoDao;
import org.lessons.java.dao.TrenoDaoImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;

@Service
public class TrenoService {

private TrenoDao dao = new TrenoDaoImp();

	
	public void crea (Treno treno) {
		dao.create(treno); 
//		System.out.println("creato treno con id: " + id);
	} 
	
	public void update (Treno treno) {
		dao.update(treno); 
//		System.out.println("modificato treno con id: " + utente.getId());
	} 	
	
	public void delete(Treno treno) {
		dao.delete(treno);
//		System.out.println("eliminato treno con id: " + utente.getId());
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
            trenoDTO.setPesoTotale(treno.getPesoTotale());
            trenoDTO.setPrezzoTotale(treno.getPrezzoTotale());
            trenoDTO.setLunghezzaTotale(treno.getLunghezzaTotale());
            trenoDTO.setDataCreaz(treno.getDataCreaz());
            trenoDTO.setNumVagoni(treno.getNumVagoni());


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
	
	
	
	@Transactional(readOnly = true)
	public List<Treno> ricercaTreniAvanzata(String nome, String compagnia, String creatore, Integer pesoTotale, Double lunghezzaTotale, Double prezzoTotale, String ordData) {
		
		//uso la sessione aperta nei dao
	    Session session = BaseDao.factory.openSession();

	    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	    CriteriaQuery<Treno> criteriaQuery = criteriaBuilder.createQuery(Treno.class);
	    Root<Treno> root = criteriaQuery.from(Treno.class);

	    // Qui le condizioni di ricerca in base ai parametri forniti

	    List<Predicate> predicates = new ArrayList<>();

	    if (nome != null && !nome.isEmpty()) {
	        predicates.add(criteriaBuilder.like(root.get("nome"), "%" + nome + "%"));
	    }

	    if (compagnia != null && !compagnia.isEmpty()) {
	        predicates.add(criteriaBuilder.like(root.get("compagnia"), "%" + compagnia + "%"));
	    }
	    
	    if (creatore != null && !creatore.isEmpty()) {
	        Join<Treno, Utente> utenteJoin = root.join("utente", JoinType.INNER);
	        predicates.add(criteriaBuilder.like(utenteJoin.get("nome"), "%" + creatore + "%"));   //criteriaBuilder.equal se voglio corrispondenza esatta, altrimenti .like se parziale (con i % + q + %)
	    }
	    
	    if (pesoTotale != null) {
	        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("pesoTotale"), pesoTotale));
	    }
	    
	    if (lunghezzaTotale != null) {
	        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("lunghezzaTotale"), lunghezzaTotale));
	    }

	    if (prezzoTotale != null) {
	        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("prezzoTotale"), prezzoTotale));
	    }
	    
	    if ("asc".equalsIgnoreCase(ordData)) {
	        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("dataCreaz")));
	    } else if ("desc".equalsIgnoreCase(ordData)) {
	        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("dataCreaz")));
	    }
	    
	    
	    criteriaQuery.where(predicates.toArray(new Predicate[0]));

	    List<Treno> risultatiRicerca = session.unwrap(Session.class).createQuery(criteriaQuery).getResultList();

	    //session.close();

	    return risultatiRicerca;
	}
	
}
