package org.lessons.java.dao;

import org.lessons.java.bean.Ruolo;

public class RuoloDaoImp extends BaseDao implements RuoloDao{

	@Override
	public Ruolo find(Integer id) {
		// TODO Auto-generated method stub
		return (Ruolo) super.find(Ruolo.class, id);
	}

}
