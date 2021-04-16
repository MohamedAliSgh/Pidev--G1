package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.ReclamationRepository;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.service.ReclamationService;
@Service
public class ReclamationServiceImpl implements ReclamationService {
	@Autowired
	ReclamationRepository ReclamationRepository;
    private static final Logger l= LogManager.getLogger(ReclamationServiceImpl.class);
    @Override
	 public List<Reclamation> retriveAllreclamations()
	  {
		  List<Reclamation> reclamations =(List<Reclamation>) ReclamationRepository.findAll();
		  
		  for(Reclamation reclamation :reclamations)
		  {	l.info("Reclamation +++ :"+reclamation);	  }
		  return reclamations;
		  
	  }
    @Override
	 public Reclamation addReclamation(Reclamation r){

    	return ReclamationRepository.save(r);
		 
		}
    
    @Override
	 public void deleteReclamation(Long idClaim)
	  {
		ReclamationRepository.deleteById(idClaim); 
	  }
    
    @Override
    public Reclamation updateReclamation(Reclamation r)
	  {   
		 
		ReclamationRepository.save(r); 
		return r;
	  }
    

    @Override
    public Optional<Reclamation> retrieveReclamation(Long idClaim) {
		return ReclamationRepository.findById(idClaim);

	}
	@Override
	public int nbrReclamation() {
		
		return ReclamationRepository.countReclamation();
	}
	@Override
	public int reclamationVeryImportant() {

		return ReclamationRepository.countVeryImportant();
	}
	@Override
	public int reclamationImportant() {
	
		return ReclamationRepository.countImportant();
	}
	@Override
	public int reclamationNormal() {
		
		return ReclamationRepository.countNormal();
	}
	@Override
	public int reclamationLessImportant() {
		
		return ReclamationRepository.countLessImportant();
	}
    
    
   

}