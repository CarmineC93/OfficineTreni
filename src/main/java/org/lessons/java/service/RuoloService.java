package org.lessons.java.service;

import java.util.List;

import org.lessons.java.bean.Ruolo;
import org.lessons.java.dao.RuoloDao;
import org.lessons.java.dao.RuoloDaoImp;

public class RuoloService {

	private RuoloDao dao = new RuoloDaoImp();

	public void crea(Ruolo ruolo) {
		dao.create(ruolo);
//		System.out.println("creato l'utente con id: " + id);
	}

	public void update(Ruolo ruolo) {
		dao.update(ruolo);
//		System.out.println("modificato l'utente con id: " + utente.getId());
	}

	public void delete(Ruolo ruolo) {
		dao.delete(ruolo);
//		System.out.println("eliminato l'utente con id: " + utente.getId());
	}

	public List<Ruolo> findAll() {
		return dao.findAll();
	}

}
