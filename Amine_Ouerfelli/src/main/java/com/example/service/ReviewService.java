package com.example.service;

import java.util.List;

import com.example.entity.Review;

public interface ReviewService {
	public <T> List<T> retriveAllReviews();
	public void AddReview(Review r);

}
