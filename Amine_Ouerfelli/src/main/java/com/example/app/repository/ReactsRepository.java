package com.example.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Post;
import com.example.app.entity.Reacts;

public interface ReactsRepository extends CrudRepository<Reacts,Long> {
    public List<Reacts> findReactsByPost(Post post);

}
