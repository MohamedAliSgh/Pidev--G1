package tn.esprit.service;
import java.util.List;
import tn.esprit.entities.reclamation;
import tn.esprit.Repository.ReclamationRepository;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationServiceIml implements ReclamationService {
	@Autowired
	ReclamationRepository ReclamationRepository;
    private static final Logger l=(Logger) LogManager.getLogger(ReclamationServiceIml.class);
	 public List<reclamation> retriveAllReclamations()
	  {
		  List<reclamation> reclamations =(List<reclamation>) ReclamationRepository.findAll();
		  
		  for(reclamation reclamation :reclamations)
		  {	l.info("reclamation +++ :"+reclamation);	  }
		  return reclamations;
		  
	  }
	
	
	public reclamation AddReclamation(reclamation r){

		return ReclamationRepository.save(r);
	}
	
	public void DeleteReclamation(reclamation r)
	  {
		ReclamationRepository.deleteById(r.getIdClaim()); 
	  }
	public void UpdateReclamation(int IdClaim)
	  {   
		  reclamation r= new reclamation();
		  r=ReclamationRepository.findById(IdClaim).get();
		  ReclamationRepository.save(r);  
	  }
	
	public List<reclamation> listReclamations() {
		return ReclamationRepository.list<reclamations>();
	}

	public reclamation getReclamationById( int IdClaim) {
		return ReclamationRepository.findByIdClaim(IdClaim).get();

	}

}
	
	
	


