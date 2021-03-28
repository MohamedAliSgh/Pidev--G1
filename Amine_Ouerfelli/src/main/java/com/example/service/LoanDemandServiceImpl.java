package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Loandemand;
import com.example.repository.LoanDemandRepository;
import com.example.repository.ProjectDetailRepository;

@Service
public class LoanDemandServiceImpl implements LoanDemandService {
	@Autowired
	LoanDemandRepository LoanDemandrepository;
	//private static final Logger l =LogManager.addLogger(LoanDemandServiceImpl.class);
	  public List<Loandemand> retriveAllLoanDemands()
	  {
		  List<Loandemand> LoanDemands =(List<Loandemand>) LoanDemandrepository.findAll();
		  
		  for(Loandemand LoanDemand :LoanDemands)
		  {
			  //l.info("LoanDemand +++ :" +LoanDemand);
		  }
		  return LoanDemands;
			  
	  }
	  public void AddLoanDemand(Loandemand r)
	  {
		  LoanDemandrepository.save(r); 
		  
	  }
	  public void DeleteLoanDemand(Loandemand r)
	  {
		  LoanDemandrepository.deleteById(r.getId()); 
	  }
	  public void UpdateLoanDemand(long LoanDemandID)
	  {   
		  Loandemand r= new Loandemand();
		  r=LoanDemandrepository.findById(LoanDemandID).get();
		  LoanDemandrepository.save(r);  
	  }
	  public Loandemand getLoanDemandById(Long id)   
	  {  
	  return LoanDemandrepository.findById(id).get();  
	  }  

}
