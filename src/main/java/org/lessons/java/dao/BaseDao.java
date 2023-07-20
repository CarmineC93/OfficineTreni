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
import org.lessons.java.pojo.Treno;

public abstract class BaseDao {

	private static SessionFactory factory; 
	 
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
	    
	    
	    public List<Treno> findAllTreni() {
	        List<Treno> result = null;
	        Session session = factory.openSession();
	        Transaction tx = null;

	        try {
	            tx = session.beginTransaction();
	            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	            CriteriaQuery<Treno> criteriaQuery = criteriaBuilder.createQuery(Treno.class);
	            Root<Treno> root = criteriaQuery.from(Treno.class);
	            criteriaQuery.select(root);
	            result = session.createQuery(criteriaQuery).getResultList();
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }

	        return result;
	    }
	   
	
	
}
