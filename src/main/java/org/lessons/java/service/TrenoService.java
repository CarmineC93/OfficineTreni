package org.lessons.java.service;

import java.util.List;

import org.lessons.java.bean.Treno;
import org.lessons.java.dao.TrenoDao;
import org.lessons.java.dao.TrenoDaoImp;


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
	
}
