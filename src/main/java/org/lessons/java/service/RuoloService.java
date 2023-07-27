package org.lessons.java.service;

import org.lessons.java.bean.Ruolo;
import org.lessons.java.dao.RuoloDao;
import org.lessons.java.dao.RuoloDaoImp;
import org.springframework.stereotype.Service;

@Service
public class RuoloService {

	private RuoloDao dao = new RuoloDaoImp();
	
	
	public Ruolo find(int id) {
		return dao.find(id);
	}
	
	
}
