package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.service.*;
import tn.esprit.spring.entity.*;

@RestController
public class ReclamationRestControlImpl {
	@Autowired
	ReclamationServiceImpl ReclamationServiceImpl ;
	
	// URL: http://localhost:8083/SpringMVC/servlet/retrieve-all-reclamation
	@GetMapping("/retrieve-all-reclamation")
	@ResponseBody
	public List<Reclamation> retriveAllreclamations(){
		List<Reclamation> list = ReclamationServiceImpl.retriveAllreclamations();
		return list;
		}
	
	// URL: http://localhost:8083/SpringMVC/servlet/{id-claim}
	@GetMapping("/{id-claim}")
	@ResponseBody
	public Optional<Reclamation> retrieveReclamation(@PathVariable("id-claim") Long idClaim) {
		return ReclamationServiceImpl.retrieveReclamation(idClaim);
	}
	
	// URL: http://localhost:8083/SpringMVC/servlet/delete-Reclamation/{id-claim}
	@DeleteMapping("/delete-Reclamation/{id-claim}")  
	public String deleteReclamation(@PathVariable("id-claim") Long idClaim)   
	{  
		List<Reclamation>reclamations=ReclamationServiceImpl.retriveAllreclamations();
		for(Reclamation r:reclamations)
			if(r.getIdClaim()==idClaim){
		ReclamationServiceImpl.deleteReclamation(idClaim);
		return "Record deleted succesfully";}
		
		return "not existe";
	}
	
	// URL: http://localhost:8083/SpringMVC/servlet/add-Reclamation
	@PostMapping("/add-Reclamation")  
	public Reclamation addReclamation(@RequestBody Reclamation r)   
	{  
		ReclamationServiceImpl.addReclamation(r);
		return r;
	}
	
	// URL: http://localhost:8083/SpringMVC/servlet/Update-Reclamation
	@PutMapping("/Update-Reclamation")  
	public  Reclamation updateReclamation(@RequestBody Reclamation r)   
	{  
	ReclamationServiceImpl.updateReclamation(r);  
	return r;  
	}
	
	// URL :http://localhost:8083/SpringMVC/servlet/nbreReclamation

    @GetMapping(value = "/nbreReclamation")
    @ResponseBody
	public int  nbreReclamation() {
		
		return ReclamationServiceImpl.nbrReclamation();
	}
    
 // URL :http://localhost:8083/SpringMVC/servlet/nbreReclamationImportant

    @GetMapping(value = "/nbreReclamationImportant")
    @ResponseBody
	public int  nbreReclamationimportant() {
		
		return ReclamationServiceImpl.reclamationImportant();
	}
    
 // URL :http://localhost:8083/SpringMVC/servlet/nbreReclamationVeryImportant

    @GetMapping(value = "/nbreReclamationVeryImportant")
    @ResponseBody
	public int  nbreReclamationVeryImportant() {
		
		return ReclamationServiceImpl.reclamationVeryImportant();
	}
    
 // URL :http://localhost:8083/SpringMVC/servlet/nbreReclamationNormal

    @GetMapping(value = "/nbreReclamationNormal")
    @ResponseBody
	public int  nbreReclamationNormal() {
		
		return ReclamationServiceImpl.reclamationNormal();
	}
    
 // URL :http://localhost:8083/SpringMVC/servlet/nbreReclamationLessImportant

    @GetMapping(value = "/nbreReclamationLessImportant")
    @ResponseBody
	public int  nbreReclamationLessImportant() {
		
		return ReclamationServiceImpl.reclamationLessImportant();
	}
}
