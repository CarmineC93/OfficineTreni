package org.lessons.java.service;

import java.util.List;

import org.lessons.java.bean.Vagone;
import org.lessons.java.dao.VagoneDao;
import org.lessons.java.dao.VagoneDaoImp;
import org.springframework.stereotype.Service;

@Service
public class VagoneService {

	private VagoneDao dao = new VagoneDaoImp();
	
	public void crea (Vagone vagone){
		dao.create(vagone); 
	} 
	
	public void update (Vagone vagone) {
		dao.update(vagone); 
//		System.out.println("modificato l'utente con id: " + utente.getId());
	} 	
	
	public void delete(Vagone vagone) {
		dao.delete(vagone);
//		System.out.println("eliminato l'utente con id: " + utente.getId());
	}
			
	public Vagone find(int id) {
		return dao.find(id);
	}
	
	public List<Vagone> findAll(){
		return dao.findAll();
	}
	
	public List<Vagone> findAllByCompany(String nomeCompagnia){
		
		return dao.findAllByCompany(nomeCompagnia);
		
	}
	
	
}
