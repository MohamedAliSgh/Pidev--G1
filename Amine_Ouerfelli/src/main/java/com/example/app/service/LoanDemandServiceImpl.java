package com.example.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.entity.Loandemand;
import com.example.app.entity.Media;
import com.example.app.entity.Profile;
import com.example.app.entity.ProjectDetail;
import com.example.app.entity.User;
import com.example.app.repository.LoanDemandRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class LoanDemandServiceImpl implements LoanDemandService {
	@Autowired
	LoanDemandRepository LoanDemandrepository;
	//private static final Logger l =LogManager.addLogger(LoanDemandServiceImpl.class);
	 @Override 
	  public List<Loandemand> retriveAllLoanDemands()
	  {
		  List<Loandemand> LoanDemands =(List<Loandemand>) LoanDemandrepository.findAll();
		  
		  for(Loandemand LoanDemand :LoanDemands)
		  {
			  //l.info("LoanDemand +++ :" +LoanDemand);
		  }
		  return LoanDemands;
			  
	  }
	  @Override 
	  public void AddLoanDemand(Loandemand r)
	  {
		  LoanDemandrepository.save(r); 
		  
	  }
	  @Override 
	  public void DeleteLoanDemand(Loandemand r)
	  {
		  LoanDemandrepository.deleteById(r.getId()); 
	  }
	  @Override 
	  public void UpdateLoanDemand(long LoanDemandID)
	  {   
		  Loandemand r= new Loandemand();
		  r=LoanDemandrepository.findById(LoanDemandID).get();
		  LoanDemandrepository.save(r);  
	  }
	  @Override 
	  public Loandemand getLoanDemandById(Long id)   
	  {  
	  return LoanDemandrepository.findById(id).get();  
	  }
	  @Override
	  public List<Loandemand> getLoanDemandByuser(User r) {
		List<Loandemand> ld=new ArrayList<Loandemand>();
		if (r.getprofile().equals(Profile.Borrower))
			   ld=LoanDemandrepository.findLoanddemandByEmprunteur(r);
		else
		{
			if(r.getprofile().equals(Profile.Lender))
				ld=LoanDemandrepository.findLoandemandByPreteur(r);
			else
				ld=this.retriveAllLoanDemands();
		}
		return ld;
	}
	@Override
	public Loandemand getJson(String loandemand, MultipartFile[] files) {
	        Loandemand LDjson=new Loandemand();
	        try{
	        	ObjectMapper objectMapper =new ObjectMapper();
	        	LDjson=objectMapper.readValue(loandemand,Loandemand.class);    	
	        }
	        catch(IOException err)
	        {
	        	System.out.printf("Erreur",err.toString());
	        }
	       
	        return LDjson;
		} 

}
