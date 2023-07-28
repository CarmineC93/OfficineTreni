package org.lessons.java.dao;

import org.lessons.java.bean.Ruolo;

public class RuoloDaoImp extends BaseDao implements RuoloDao{

	@Override
	public Ruolo find(Integer id) {
		// TODO Auto-generated method stub
		return (Ruolo) super.find(Ruolo.class, id);
	}

	@Override
	public void create(Ruolo bean) {
		// TODO Auto-generated method stub
		super.create(bean);
	}

	@Override
	public void update(Ruolo bean) {
		// TODO Auto-generated method stub
		super.update(bean);
	}

}
