package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Post;


public interface PostRepository extends CrudRepository<Post,Long> {

}
