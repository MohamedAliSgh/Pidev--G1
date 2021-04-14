package com.example.app.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.LoanDetails;
import com.example.app.entity.Loanoffer;
import com.example.app.service.LoanOfferService;




@RestController
public class LoanOfferController {
	@Autowired
	LoanOfferService loanofferservice;

	@GetMapping("/offerlist")  
	private List<Loanoffer> getAllLoanOffers()   
	{  
	  return loanofferservice.retriveAllLoanoffers();
	} 
	@GetMapping("/offerlist/offer/{offerid}")  
	private Loanoffer ViewOneoffer(@PathVariable("offerid") Long offerId)   
	{  
	return loanofferservice.getLoanofferById(offerId);  
	}
	@DeleteMapping("/myofferlist/offer/{offerid}")  
	private void deletePost(@PathVariable("offerid") Long offerid)   
	{  
    Loanoffer o= new Loanoffer();
    o=loanofferservice.getLoanofferById(offerid);
    if(o!=null)
	loanofferservice.DeleteLoanoffer(o);
    else
    System.out.println("Entité deja Supprimée/Entity already Deleted");
	}
	@PostMapping("/createloanoffer")  
	private Long saveLoanoffer(@RequestBody Loanoffer loanoffer)   
	{  
    LoanDetails loandetail=new LoanDetails();
	loanofferservice.AddLoanoffer(loanoffer);  
	return loanoffer.getId() ;
	}
	@PutMapping("/myofferslist/edit")  
	private  Loanoffer update(@RequestBody Loanoffer c)   
	{ 
	loanofferservice.UpdateLoanoffer(c.getId());  
	return c;  
	}
	

}
