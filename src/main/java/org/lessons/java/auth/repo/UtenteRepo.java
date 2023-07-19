package org.lessons.java.auth.repo;

import org.lessons.java.auth.pojo.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepo extends JpaRepository<Utente,Integer>{

}
