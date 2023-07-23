package org.lessons.java.service;

import java.util.List;

import org.lessons.java.bean.Ordine;
import org.lessons.java.dao.OrdineDao;
import org.lessons.java.dao.OrdineDaoImp;

public class OrdineService {

	private OrdineDao dao = new OrdineDaoImp();

	public void crea(Ordine ordine) {
		dao.create(ordine);
//		System.out.println("creato l'utente con id: " + id);
	}

	public void update(Ordine ordine) {
		dao.update(ordine);
//		System.out.println("modificato l'utente con id: " + utente.getId());
	}

	public void delete(Ordine ordine) {
		dao.delete(ordine);
//		System.out.println("eliminato l'utente con id: " + utente.getId());
	}

	public List<Ordine> findAll() {
		return dao.findAll();
	}

}
