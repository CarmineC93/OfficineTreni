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
import org.lessons.java.bean.Ordine;
import org.lessons.java.bean.Treno;

public class OrdineDaoImp extends BaseDao implements OrdineDao{

	 static {
			 try {
		    factory = new Configuration().configure().buildSessionFactory();
		 } catch (Throwable ex) { 
		    System.err.println("Failed to create sessionFactory object." + ex);
		    throw new ExceptionInInitializerError(ex); 
		 }
	 }
	
	@Override
	public void create(Ordine ordine) {
 		super.create(ordine);
	}

	@Override
	public void update(Ordine ordine) {
 		super.update(ordine);
	}

	@Override
	public void delete(Ordine ordine) {
 		super.delete(ordine);
	}

	@Override
	public Ordine find(Integer id) {
 		return (Ordine) super.find(Ordine.class, id);
	}
	
	@Override
	public List<Ordine> findAll() {
		Session session = factory.openSession();
        Transaction tx = null; 
        List<Ordine> resultList = null;

        try {
            tx = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Ordine> criteriaQuery = criteriaBuilder.createQuery(Ordine.class);
            Root<Ordine> root = criteriaQuery.from(Ordine.class);
            criteriaQuery.select(root);

            resultList = session.createQuery(criteriaQuery).getResultList();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return resultList;
	}

	@Override
	    public List<Ordine> findAllByUserId(int utente) {
	    	  Session session = factory.openSession();
	  	    Transaction tx = null;
	  	    List<Ordine> resultList = null;

	  	    try {
	  	        tx = session.beginTransaction();

	  	        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	  	        CriteriaQuery<Ordine> criteriaQuery = criteriaBuilder.createQuery(Ordine.class);
	  	        Root<Ordine> root = criteriaQuery.from(Ordine.class);

	  	       
	  	        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("utente"), utente));

	  	        resultList = session.createQuery(criteriaQuery).getResultList();

	  	        tx.commit();
	  	    } catch (HibernateException e) {
	  	        if (tx != null) tx.rollback();
	  	        e.printStackTrace();
	  	    } finally {
	  	        session.close();
	  	    }

	  	    return resultList;	
	}



}
