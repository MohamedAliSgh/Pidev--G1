package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Domaine;
import tn.esprit.spring.entities.Loanoffer;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.LoanOfferRepository;
@Service
public class LoanOfferServiceImpl implements LoanOfferService {
	@Autowired
	LoanOfferRepository Loanofferrepository;
	//private static final Logger l =LogManager.addLogger(LoanofferServiceImpl.class);
	  public List<Loanoffer> retriveAllLoanoffers()
	  {
		  List<Loanoffer> Loanoffers =(List<Loanoffer>) Loanofferrepository.findAll();
		  
		  for(Loanoffer Loanoffer :Loanoffers)
		  {
			  //l.info("Loanoffer +++ :" +Loanoffer);
		  }
		  return Loanoffers;
			  
	  }
	  public void AddLoanoffer(Loanoffer r)
	  {
		  Loanofferrepository.save(r); 
		  
	  }
	  public void DeleteLoanoffer(Loanoffer r)
	  {
		  Loanofferrepository.deleteById(r.getId()); 
	  }
	  public void UpdateLoanoffer(long LoanofferID)
	  {   
		  Loanoffer r= new Loanoffer();
		  r=Loanofferrepository.findById(LoanofferID).get();
		  Loanofferrepository.save(r);  
	  }
	  public Loanoffer getLoanofferById(Long id)   
	  {  
	  return Loanofferrepository.findById(id).get();  
	  }
	@Override
	public List<Loanoffer> getLoanofferByUser(User u) {
		return Loanofferrepository.findLoanofferByEditor(u);
	}
	@Override
	public List<Loanoffer> getloanofferByDomaine(Domaine d) {
		return Loanofferrepository.findLoanofferByDomaine(d);
	} 
	
}
