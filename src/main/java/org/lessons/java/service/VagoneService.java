package org.lessons.java.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.pojo.Vagone;
import org.lessons.java.repo.VagoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagoneService {

	
	@Autowired
	private VagoneRepo vagoneRepo;
	
	
	
	public List<Vagone> findAll() {
		
		return vagoneRepo.findAll();
	}
	public Vagone save(Vagone vagone) {
		
		return vagoneRepo.save(vagone);
	}
	public Optional<Vagone> findById(int id) {
		
		return vagoneRepo.findById(id);
	}
	

	public void delete(Vagone vagone){
		
		vagoneRepo.delete(vagone);
		
	}
	
	
}
