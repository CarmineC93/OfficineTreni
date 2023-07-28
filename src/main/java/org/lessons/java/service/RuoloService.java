package org.lessons.java.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.lessons.java.bean.Ruolo;
import org.lessons.java.dao.RuoloDao;
import org.lessons.java.dao.RuoloDaoImp;
import org.springframework.stereotype.Service;

@Service
public class RuoloService {

	private RuoloDao dao = new RuoloDaoImp();
	
	
	public Ruolo find(int id) {
		return dao.find(id);
	}
	
//	 @PersistenceUnit
//	    private EntityManagerFactory entityManagerFactory;

//	 public Ruolo find(int id) {
//	        EntityManager entityManager = entityManagerFactory.createEntityManager();
//	        String queryString = "SELECT r FROM Ruolo r JOIN FETCH r.utente WHERE r.id = :id";
//	        TypedQuery<Ruolo> query = entityManager.createQuery(queryString, Ruolo.class);
//	        query.setParameter("id", id);
//	        Ruolo ruolo = query.getSingleResult();
//	        entityManager.close();
//	        return ruolo;
//	    }	

	
	public void create(Ruolo ruolo) {
		
		dao.create(ruolo);
		
	}
	
	public void update(Ruolo ruolo) {
		dao.update(ruolo);
	}
	
}
