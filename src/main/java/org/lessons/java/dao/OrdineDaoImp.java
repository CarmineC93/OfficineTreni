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

public class OrdineDaoImp extends BaseDao implements OrdineDao {

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
	public void create(Ordine bean) {
		// TODO Auto-generated method stub
		super.create(bean);
	}

	@Override
	public void update(Ordine bean) {
		// TODO Auto-generated method stub
		super.update(bean);
	}

	@Override
	public void delete(Ordine bean) {
		// TODO Auto-generated method stub
		super.delete(bean);
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
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return resultList;
	}

}
