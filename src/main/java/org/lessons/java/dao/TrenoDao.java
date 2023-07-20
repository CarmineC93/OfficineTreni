package org.lessons.java.dao;

import java.util.List;

import org.lessons.java.pojo.Treno;

public interface TrenoDao {

	
	public void create(Treno bean);
	public void update(Treno bean );
	public void delete(Treno bean );
	public List<Treno> findAllTreni();
	
	
}
