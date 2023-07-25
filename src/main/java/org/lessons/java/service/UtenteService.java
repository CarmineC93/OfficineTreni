package org.lessons.java.service;

import org.lessons.java.bean.Utente;
import org.lessons.java.dao.UtenteDao;
import org.lessons.java.dao.UtenteDaoImp;


public class UtenteService {

	private UtenteDao dao = new UtenteDaoImp();

	public void crea (Utente utente) {
		dao.create(utente); 
//		System.out.println("creato l'utente con id: " + id);
	} 
	
	public void update (Utente utente) {
		dao.update(utente); 
//		System.out.println("modificato l'utente con id: " + utente.getId());
	} 	
	
	public void delete(Utente utente) {
		dao.delete(utente);
//		System.out.println("eliminato l'utente con id: " + utente.getId());
	}
	
	public Utente find(int id) {
		return dao.find(id);
	} 
}
