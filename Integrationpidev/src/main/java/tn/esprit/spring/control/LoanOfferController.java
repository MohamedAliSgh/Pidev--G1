package tn.esprit.spring.control;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.LoanDetails;
import tn.esprit.spring.entities.Loanoffer;
import tn.esprit.spring.service.LoanOfferService;




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
    LocalDate localDate = LocalDate.now();
    Date date = new Date(localDate.atStartOfDay(ZoneId.of("America/New_York")).toEpochSecond() * 1000);
    loanoffer.setDate(date);
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
