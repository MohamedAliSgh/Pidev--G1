package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Reacts;
import com.example.repository.ReactsRepository;
@Service
public class ReactsServiceImpl implements ReactsService {
	@Autowired
	ReactsRepository Reactrepository;
	//private static final Logger l =LogManager.addLogger(ReactServiceImpl.class);
	  public List<Reacts> retriveAllReacts()
	  {
		  List<Reacts> Reacts =(List<Reacts>) Reactrepository.findAll();
		  
		  for(Reacts React :Reacts)
		  {
			  //l.info("React +++ :" +React);
		  }
		  return Reacts;
			  
	  }
	  public void AddReact(Reacts r)
	  {
		  Reactrepository.save(r); 
		  
	  }
	  public void DeleteReact(Reacts r)
	  {
		  Reactrepository.deleteById(r.getId()); 
	  }
	  public void UpdateReact(long ReactID)
	  {   
		  Reacts r= new Reacts();
		  r=Reactrepository.findById(ReactID).get();
		  Reactrepository.save(r);  
	  }
	  public Reacts getReactById(Long id)   
	  {  
	  return Reactrepository.findById(id).get();  
	  }  
}
