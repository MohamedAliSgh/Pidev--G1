package tn.esprit.spring.control;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Loandemand;
import tn.esprit.spring.entities.Media;
import tn.esprit.spring.entities.ProjectDetail;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.LoanDemandService;
import tn.esprit.spring.service.MediaService;
import tn.esprit.spring.service.ProjectDetailService;

@RestController
public class LoanDemandController {
	@Autowired  
	LoanDemandService loandemandservice;
	@Autowired
	MediaService mediaser;
	@Autowired
	ProjectDetailService pjserv;
	@GetMapping("/Demandlistforadmin")  
	private List<Loandemand> getAllloandemands()   
	{  
	  return loandemandservice.retriveAllLoanDemands();
	} 
	@GetMapping("/MyDemandlist")
	public List<Loandemand>getAlldemandsByUser(@RequestBody User u)
	{    
		return loandemandservice.getLoanDemandByuser(u);
	}
	
	@GetMapping("/MyDemandlist/demand/{Demandid}")  
	private Loandemand ViewOneDemand(@PathVariable("Demandid") Long Id)   
	{  
	return loandemandservice.getLoanDemandById(Id);  
	}
	@DeleteMapping("/MyDemandlist/delete/{Demandid}")  
	private void deleteLoanDemand(@PathVariable("Demandid") Long offerid)   
	{  
    Loandemand o= new Loandemand();
    o=loandemandservice.getLoanDemandById(offerid);
    if(o!=null)
	loandemandservice.DeleteLoanDemand(o);
    else
    System.out.println("Entité deja Supprimée/Entity already Deleted");
	}
	@RequestMapping(value="/addLoanDemand",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
    public Loandemand saveloandemand(@RequestPart("details") String Projet,@RequestPart("LoanDemand") String loandemand,@RequestParam("files") MultipartFile[] files)   
	{             ProjectDetail pj  =new ProjectDetail();
	              pj=pjserv.getJson(Projet, files);
		          List<Media> medialist= new ArrayList<>();
			      List<String> fileNames = new ArrayList<>();
			      Arrays.asList(files).stream().forEach(file -> { mediaser.save(file);
			      fileNames.add(file.getOriginalFilename());
			      Media m=new Media();
			      m.setName(file.getOriginalFilename());
			      m.setType(file.getOriginalFilename().split("\\.")[1]);
			      m.setPost(null);
			      medialist.add(m);
			      mediaser.AddMedia(m);
			      });			     
                  pj.setFinancialplan(medialist);
	              Loandemand ld=new Loandemand();
                  ld=loandemandservice.getJson(loandemand, files);                 
                  LocalDate localDate = LocalDate.now();
                  Date date = new Date(localDate.atStartOfDay(ZoneId.of("America/New_York")).toEpochSecond() * 1000);
                  ld.setDate(date);
                  ld.setDetails( pj);
                  System.out.println(ld.getDetails().toString());
	              loandemandservice.AddLoanDemand(ld);  
	              return ld;
	       }
	@PutMapping("/MyDemandlist/edit")  
	private  Loandemand update(@RequestBody Loandemand c)   
	{  
	loandemandservice.UpdateLoanDemand(c.getId());  
	return c ;  
	}
	

}
