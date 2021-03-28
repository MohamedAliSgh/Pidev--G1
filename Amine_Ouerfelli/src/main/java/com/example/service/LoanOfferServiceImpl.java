package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Loanoffer;
import com.example.repository.LoanOfferRepository;

public class LoanOfferServiceImpl {
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
}
