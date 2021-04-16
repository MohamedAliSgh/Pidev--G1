package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Reclamation;

public interface ReclamationService {
	 public List<Reclamation> retriveAllreclamations();
	 public Reclamation addReclamation(Reclamation r);
	 public void deleteReclamation(Long idClaim);
	 public Reclamation updateReclamation(Reclamation r);
	 public Optional<Reclamation> retrieveReclamation(Long idClaim);
	 public int nbrReclamation();
	 public int reclamationVeryImportant ();
	 public int reclamationImportant ();
	 public int reclamationNormal ();
	 public int reclamationLessImportant ();

}
