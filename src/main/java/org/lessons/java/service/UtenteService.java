package org.lessons.java.service;


import org.lessons.java.bean.Utente;
import org.lessons.java.dao.UtenteDao;
import org.lessons.java.dao.UtenteDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

	
//	@Autowired
//    private UtenteDao dao;
	
	private UtenteDao dao = new UtenteDaoImp();

	public Utente findByEmail(String email) {
		return dao.findByEmail(email);
	  }
	
	
    public void registraUtente(Utente utente) throws Exception {
        // Verifica se l'utente con la stessa email è già presente nel database
        if (findByEmail(utente.getEmail()) != null) {
            throw new Exception("Utente con questa email già registrato.");
        }
        
        dao.create(utente);    }
	

    public boolean verificaCredenziali(String email, String password) {
    	
    	
    	   Utente utente = dao.findByEmail(email);
    	    if (utente == null) {
    	        return false; // Utente non trovato
    	    }
    	 
    	
    	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	    return passwordEncoder.matches(password, utente.getPassword());
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
