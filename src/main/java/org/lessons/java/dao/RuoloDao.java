package org.lessons.java.dao;

import java.util.List;

import org.lessons.java.bean.Ruolo;

public interface RuoloDao {

	public void create(Ruolo bean);

	public void update(Ruolo bean);

	public void delete(Ruolo bean);

	public List<Ruolo> findAll();

}
