package org.lessons.java.dao;

import java.util.List;

import org.lessons.java.bean.Bean;
import org.lessons.java.pojo.Treno;

public class TrenoDaoImp extends BaseDao implements TrenoDao{

	@Override
	public void create(Treno bean) {
		// TODO Auto-generated method stub
		super.create(bean);
	}

	@Override
	public void update(Treno bean) {
		// TODO Auto-generated method stub
		super.update(bean);
	}

	@Override
	public void delete(Treno bean) {
		// TODO Auto-generated method stub
		super.delete(bean);
	}
	
	@Override
	public List<Treno> findAllTreni() {
		return super.findAllTreni();
	}
	
	
}
