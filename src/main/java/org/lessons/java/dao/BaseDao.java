package org.lessons.java.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.lessons.java.bean.Bean;
import org.lessons.java.bean.Treno;
import org.lessons.java.bean.Utente;

public abstract class BaseDao {

	public static SessionFactory factory; 
	 
	 static {
		 
	 try {
       factory = new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) { 
       System.err.println("Failed to create sessionFactory object." + ex);
       throw new ExceptionInInitializerError(ex); 
    }
	 }
	

	 
	   protected void create(Bean bean){
	      Session session = factory.openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         
	        session.save(bean);
	         
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      
	   }
	   
	   
	   /* Method to UPDATE salary for an employee */
	   protected void update(Bean bean){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.update(bean); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	    protected void delete(Bean bean){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.delete(bean); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	    
	    
	    protected Bean find(Class classe, Integer id){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      Bean bean = null;
		      
		      try {
		         tx = session.beginTransaction();
		         
		         bean = (Bean) session.get(classe, id);
		         
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return bean;
		   } 
	
	
	    public Utente findByEmail(String email) {
		     Session session = factory.openSession();

	
	        Transaction tx = null;
	        Utente utente = null;

	        try {
	            tx = session.beginTransaction();
	            utente = session.createQuery("FROM Utente WHERE email = :email", Utente.class)
	                           .setParameter("email", email)
	                           .uniqueResult();
	            tx.commit();
	        } catch (HibernateException e) {
	            if (tx != null) tx.rollback();
	            e.printStackTrace();
	        } finally {
	            // Don't close the session here, let the BaseDao handle it
	        }

	        return utente;
	    }
	    
}
