package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Commentaire;

public interface CommentaireRepository extends CrudRepository<Commentaire,Long> {

}
