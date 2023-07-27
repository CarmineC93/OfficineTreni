package org.lessons.java.dao;

import org.lessons.java.bean.Ruolo;

public interface RuoloDao {
	
	public Ruolo find(Integer id);
	public void create(Ruolo bean);
	public void update(Ruolo bean);
}
