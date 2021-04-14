package com.example.app.service;

import java.util.List;

import com.example.app.entity.Commentaire;
import com.example.app.entity.Post;

public interface CommentaireService {
	public List<Commentaire> retriveAllCommentaires();
	public Commentaire getCommentaireById(Long id);
	public void UpdateCommentaire(long CommentaireID);
	public void AddCommentaire(Commentaire r);
	public void DeleteCommentaire(Commentaire r);
    public List<Commentaire> getCommentaireByPost(Post p);

}
