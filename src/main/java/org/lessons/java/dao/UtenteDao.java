package org.lessons.java.dao;

import org.lessons.java.bean.Utente;
import org.springframework.stereotype.Component;

 
public interface UtenteDao {
	
	Utente findByEmail(String email);
	
	public void create(Utente bean); //save
	public void update(Utente bean);
	public void delete(Utente bean);
	
}
