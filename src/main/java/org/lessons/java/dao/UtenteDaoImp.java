package org.lessons.java.dao;

import org.lessons.java.bean.Utente;

public class UtenteDaoImp extends BaseDao implements UtenteDao{

	@Override
	public void create(Utente bean) {
		// TODO Auto-generated method stub
		super.create(bean);
	}

	@Override
	public void update(Utente bean) {
		// TODO Auto-generated method stub
		super.update(bean);
	}

	@Override
	public void delete(Utente bean) {
		// TODO Auto-generated method stub
		super.delete(bean);
	}

	@Override 
	public Utente find(Integer id) {
		return (Utente) super.find(Utente.class, id);
	}
	
}
