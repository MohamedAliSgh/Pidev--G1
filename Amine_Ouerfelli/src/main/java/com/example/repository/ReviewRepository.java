package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Review;

public interface ReviewRepository extends CrudRepository<Review,Long> {
	

}
