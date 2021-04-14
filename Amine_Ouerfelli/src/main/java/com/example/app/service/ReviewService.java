package com.example.app.service;

import java.util.List;

import com.example.app.entity.Review;

public interface ReviewService {
	  public List<Review> retriveAllReviews();
	  public void AddReview(Review r);
	  public void DeleteReview(Review r);
	  public void UpdateReview(long ReviewID);
	  public Review getReviewById(Long id);

}
