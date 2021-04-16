package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Long> {
	
@Query("SELECT count(*) FROM Reclamation ")
public int countReclamation();
@Query("SELECT count(*) FROM Reclamation where Priorities='very_important' ")
public int countVeryImportant();
@Query("SELECT count(*) FROM Reclamation where Priorities='important' ")
public int countImportant();
@Query("SELECT count(*) FROM Reclamation where Priorities='normal' ")
public int countNormal();
@Query("SELECT count(*) FROM Reclamation where Priorities='less_important' ")
public int countLessImportant();


	
}
