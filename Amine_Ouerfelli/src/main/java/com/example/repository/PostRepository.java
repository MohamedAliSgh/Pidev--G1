package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Post;


public interface PostRepository extends CrudRepository<Post,Long> {

}
