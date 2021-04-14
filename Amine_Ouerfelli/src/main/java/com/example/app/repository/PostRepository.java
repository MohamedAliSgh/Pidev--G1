package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Commentaire;
import com.example.app.entity.Post;


public interface PostRepository extends CrudRepository<Post,Long> {

}
