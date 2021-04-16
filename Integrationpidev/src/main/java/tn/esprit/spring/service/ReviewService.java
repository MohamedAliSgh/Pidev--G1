package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Review;



public interface ReviewService {
	  public List<Review> retriveAllReviews();
	  public void AddReview(Review r);
	  public void DeleteReview(Review r);
	  public void UpdateReview(long ReviewID);
	  public Review getReviewById(Long id);

}
