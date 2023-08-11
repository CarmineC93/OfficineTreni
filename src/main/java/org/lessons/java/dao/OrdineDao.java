package org.lessons.java.dao;

import java.util.List;
import org.lessons.java.bean.Ordine;

public interface OrdineDao {

	public void create(Ordine ordine);
	public void update(Ordine ordine);
	public void delete(Ordine ordine);
	public List<Ordine> findAll();
	public Ordine find(Integer id);
	public List<Ordine> findAllByUserId(int utente);
	
	
}
