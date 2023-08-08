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
import org.lessons.java.bean.Treno;
import org.lessons.java.bean.Vagone;

public class VagoneDaoImp extends BaseDao implements VagoneDao{
	
	private static SessionFactory factory; 
	 
	 static {
	 try {
    factory = new Configuration().configure().buildSessionFactory();
 } catch (Throwable ex) { 
    System.err.println("Failed to create sessionFactory object." + ex);
    throw new ExceptionInInitializerError(ex); 
 }
	 }

	@Override
	public void create(Vagone bean) {
		// TODO Auto-generated method stub
		super.create(bean);
	}

	@Override
	public void update(Vagone bean) {
		// TODO Auto-generated method stub
		super.update(bean);
	}

	@Override
	public void delete(Vagone bean) {
		// TODO Auto-generated method stub
		super.delete(bean);
	}

	@Override
	public List<Vagone> findAll() {
		 Session session = factory.openSession();
	        Transaction tx = null; 
	        List<Vagone> resultList = null;

	        try {
	            tx = session.beginTransaction();

	            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	            CriteriaQuery<Vagone> criteriaQuery = criteriaBuilder.createQuery(Vagone.class);
	            Root<Vagone> root = criteriaQuery.from(Vagone.class);
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
	public List<Vagone> findAllByCompany(String nomeCompagnia) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    List<Vagone> resultList = null;

	    try {
	        tx = session.beginTransaction();

	        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Vagone> criteriaQuery = criteriaBuilder.createQuery(Vagone.class);
	        Root<Vagone> root = criteriaQuery.from(Vagone.class);

	       
	        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("compagnia"), nomeCompagnia));

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
	public Vagone find(Integer id) {
		// TODO Auto-generated method stub
		return (Vagone) super.find(Vagone.class, id);
	}
	
	

}
