package org.lessons.java.dao;

import java.util.List;

import org.lessons.java.bean.Ordine;

public interface OrdineDao {

	public void create(Ordine bean);

	public void update(Ordine bean);

	public void delete(Ordine bean);

	public List<Ordine> findAll();

}
