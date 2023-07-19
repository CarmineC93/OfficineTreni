package org.lessons.java.auth.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.auth.pojo.Utente;
import org.lessons.java.auth.repo.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepo utenteRepo;


	public List<Utente> findAll() {

		return utenteRepo.findAll();
	}
	public Optional<Utente> findById(int id) {

		return utenteRepo.findById(id);
	}
	public Utente save(Utente utente) {

		return utenteRepo.save(utente);
	}

}
