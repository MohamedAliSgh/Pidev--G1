package com.example.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Commentaire;
import com.example.app.entity.Post;

public interface CommentaireRepository extends CrudRepository<Commentaire,Long> {
	public List<Commentaire> findCommentaireByPost(Post p);
       
}
