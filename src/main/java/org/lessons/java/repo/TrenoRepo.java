package org.lessons.java.repo;

import org.lessons.java.pojo.Treno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrenoRepo extends JpaRepository<Treno, Integer>{

	
	
	
}
