package org.lessons.java.service;

import java.util.List;

import org.lessons.java.bean.Composizione;
import org.lessons.java.dao.ComposizioneDao;
import org.lessons.java.dao.ComposizioneDaoImp;

public class ComposizioneService {

	private ComposizioneDao dao = new ComposizioneDaoImp();

	public void crea(Composizione composizione) {
		dao.create(composizione);
//		System.out.println("creato l'utente con id: " + id);
	}

	public void update(Composizione composizione) {
		dao.update(composizione);
//		System.out.println("modificato l'utente con id: " + utente.getId());
	}

	public void delete(Composizione composizione) {
		dao.delete(composizione);
//		System.out.println("eliminato l'utente con id: " + utente.getId());
	}

	public List<Composizione> findAll() {
		return dao.findAll();
	}

}
