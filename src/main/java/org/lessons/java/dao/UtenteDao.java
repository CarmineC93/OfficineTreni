package org.lessons.java.dao;

import java.util.List;

import org.lessons.java.bean.Utente;

public interface UtenteDao {

	public void create(Utente bean);

	public void update(Utente bean);

	public void delete(Utente bean);

	public List<Utente> findAll();

}
