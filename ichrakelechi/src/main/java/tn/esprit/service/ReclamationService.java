package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.reclamation;

public interface ReclamationService {
	public List<reclamation> retriveAllreclamations();
	public reclamation AddReclamation( reclamation r);
	public void UpdateReclamation(int IdClaim);
	public void DeleteReclamation(reclamation r);
	public reclamation getReclamationById( int IdClaim);

}
