package org.lessons.java.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lessons.java.bean.Ordine;
import org.lessons.java.bean.Vagone;
import org.lessons.java.dao.OrdineDao;
import org.lessons.java.dao.OrdineDaoImp;
import org.springframework.stereotype.Service;

@Service
public class OrdineService {


	private OrdineDao dao = new OrdineDaoImp();
	
	public void crea (Ordine ordine){
		dao.create(ordine); 
	} 
	
	public void update (Ordine ordine) {
		dao.update(ordine); 
//		System.out.println("modificato l'utente con id: " + utente.getId());
	} 	
	
	public void delete(Ordine ordine) {
		dao.delete(ordine);
//		System.out.println("eliminato l'utente con id: " + utente.getId());
	}
			
	public Ordine find(int id) {
		return dao.find(id);
	}
	
	public List<Ordine> findAll(){
		return dao.findAll();
	}

        
    public List<Ordine> findAllByUserId(int utente) {
		return dao.findAllByUserId(utente);
	}
    
}
