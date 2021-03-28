package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Commentaire;
import com.example.repository.CommentaireRepository;
@Service
public class CommentaireServiceImpl implements CommentaireService {
	@Autowired
	CommentaireRepository Commentairerepository;
	//private static final Logger l =LogManager.addLogger(CommentaireServiceImpl.class);
	  public List<Commentaire> retriveAllCommentaires()
	  {
		  List<Commentaire> Commentaires =(List<Commentaire>) Commentairerepository.findAll();
		  
		  for(Commentaire Commentaire :Commentaires)
		  {
			  //l.info("Commentaire +++ :" +Commentaire);
		  }
		  return Commentaires;
			  
	  }
	  public void AddCommentaire(Commentaire r)
	  {
		  Commentairerepository.save(r); 
		  
	  }
	  public void DeleteCommentaire(Commentaire r)
	  {
		  Commentairerepository.deleteById(r.getId()); 
	  }
	  public void UpdateCommentaire(long CommentaireID)
	  {   
		  Commentaire r= new Commentaire();
		  r=Commentairerepository.findById(CommentaireID).get();
		  Commentairerepository.save(r);  
	  }
	  public Commentaire getCommentaireById(Long id)   
	  {  
	  return Commentairerepository.findById(id).get();  
	  }  

}
