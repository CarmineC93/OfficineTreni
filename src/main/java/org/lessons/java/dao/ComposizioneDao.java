package org.lessons.java.dao;

import java.util.List;

import org.lessons.java.bean.Composizione;

public interface ComposizioneDao {

	
	public void create(Composizione bean);
	public void update(Composizione bean );
	public void delete(Composizione bean );

	public List<Composizione> findAll();
	
	
}
