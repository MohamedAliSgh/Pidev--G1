package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Commentaire;
import tn.esprit.spring.entities.Post;

public interface CommentaireService {
	public List<Commentaire> retriveAllCommentaires();
	public Commentaire getCommentaireById(Long id);
	public void UpdateCommentaire(long CommentaireID);
	public void AddCommentaire(Commentaire r);
	public void DeleteCommentaire(Commentaire r);
    public List<Commentaire> getCommentaireByPost(Post p);

}
