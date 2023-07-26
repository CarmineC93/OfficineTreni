package org.lessons.java.dao;

import java.util.List;

import org.lessons.java.bean.Vagone;

public interface VagoneDao {
	

	public void create(Vagone bean);
	public void update(Vagone bean );
	public void delete(Vagone bean );
	public List<Vagone> findAll();
	public Vagone find(Integer id);
	public List<Vagone> findAllByCompany(String nomeCompagnia);
	
}
