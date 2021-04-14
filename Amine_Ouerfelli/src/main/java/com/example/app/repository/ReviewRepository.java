package com.example.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Review;

public interface ReviewRepository extends CrudRepository<Review,Long> {
	

}
