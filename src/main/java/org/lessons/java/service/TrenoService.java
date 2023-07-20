package org.lessons.java.service;

import java.util.List;

import org.lessons.java.dao.TrenoDao;
import org.lessons.java.dao.TrenoDaoImp;
import org.lessons.java.pojo.Treno;
import org.springframework.stereotype.Service;

@Service
public class TrenoService {

	
	private TrenoDao dao = new TrenoDaoImp();
	
	
	public void crea (Treno treno) {
		dao.create(treno); 
		System.out.println("creato l'utente con id: " + treno);
	} 
	
	public void update (Treno treno) {
		dao.update(treno); 
		System.out.println("modificato l'utente con id: " + treno.getIdTreno());
	} 	
	
	public void delete(Treno treno) {
		dao.delete(treno);
		System.out.println("eliminato l'utente con id: " + treno.getIdTreno());
	}
	
	public List<Treno> findAllTreni() {
		return dao.findAllTreni();
	}
	
}
