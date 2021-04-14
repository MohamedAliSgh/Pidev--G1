package com.example.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.app.entity.Media;
import com.example.app.entity.Post;

public interface MediaRepository extends CrudRepository<Media,Long> {
	public List<Media> findMediaByPost(Post post);
}
