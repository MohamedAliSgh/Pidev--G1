package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.Reacts;
import tn.esprit.spring.repository.ReactsRepository;


@Service
public class ReactsServiceImpl implements ReactsService {
	@Autowired
	ReactsRepository Reactrepository;
	//private static final Logger l =LogManager.addLogger(ReactServiceImpl.class);
	@Override
	  public List<Reacts> retriveAllReacts()
	  {
		  List<Reacts> Reacts =(List<Reacts>) Reactrepository.findAll();
		  
		  for(Reacts React :Reacts)
		  {
			  //l.info("React +++ :" +React);
		  }
		  return Reacts;
			  
	  }
	@Override
	  public void AddReact(Reacts r)
	  {
		  Reactrepository.save(r); 
		  
	  }
	@Override
	  public void DeleteReact(Reacts r)
	  {
		  Reactrepository.deleteById(r.getId()); 
	  }
	@Override
	  public void UpdateReact(long ReactID)
	  {   
		  Reacts r= new Reacts();
		  r=Reactrepository.findById(ReactID).get();
		  Reactrepository.save(r);  
	  }
	@Override
	  public Reacts getReactById(Long id)   
	  {  
	  return Reactrepository.findById(id).get();  
	  }
	@Override
	public List<Reacts> getReactByPost(Post p) {
		return Reactrepository.findReactsByPost(p);
	}

}
