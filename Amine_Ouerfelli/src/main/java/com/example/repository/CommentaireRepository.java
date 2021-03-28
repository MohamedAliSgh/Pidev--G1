package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Commentaire;

public interface CommentaireRepository extends CrudRepository<Commentaire,Long> {

}
