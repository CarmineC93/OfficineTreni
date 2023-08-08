package security;

import java.util.Optional;

import org.lessons.java.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Utente, Integer>{
    public Optional<Utente> findByEmail(String email);
}
