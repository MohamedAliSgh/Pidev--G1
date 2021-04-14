package com.example.app.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Commentaire;
import com.example.app.entity.Post;
import com.example.app.repository.CommentaireRepository;
@Service
public class CommentaireServiceImpl implements CommentaireService {
	@Autowired
	CommentaireRepository Commentairerepository;
	private static final Logger l =LogManager.getLogger(CommentaireServiceImpl.class);
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
	@Override
	public List<Commentaire> getCommentaireByPost(Post p) {
		return Commentairerepository.findCommentaireByPost(p);
	}
      

}
