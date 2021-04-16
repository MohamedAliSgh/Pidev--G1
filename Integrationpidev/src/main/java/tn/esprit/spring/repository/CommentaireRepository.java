package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Commentaire;


public interface CommentaireRepository extends CrudRepository<Commentaire,Long> {
	public List<Commentaire> findCommentaireByPost(Post p);
       
}
