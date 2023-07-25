package org.lessons.java.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.lessons.java.bean.Bean;
import org.lessons.java.bean.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

	
	@Repository
	public class UtenteDaoImp extends BaseDao implements UtenteDao {

	    @Override
	    public void create(Utente bean) {
	        super.create(bean);
	    }

	    @Override
	    public void update(Utente bean) {
	        super.update(bean);
	    }

	    @Override
	    public void delete(Utente bean) {
	        super.delete(bean);
	    }

	@Override 
	public Utente find(Integer id) {
		return (Utente) super.find(Utente.class, id);
	}
	
	
	/*
	@Override
	public Utente findByEmail(String email) {
		
		 Session session = factory.openSession();
	      Transaction tx = null;
	      Bean bean = null;
	      
	      try {
	         tx = session.beginTransaction();
	         
	         bean = (Bean) session.get(Utente.class, email);
	         
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return session.createQuery("FROM Utente WHERE email = :email", Utente.class)
                  .setParameter("email", email)
                  .uniqueResult();}*/

	
	
}
