package tn.esprit.spring.service;

import java.util.List;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Review;
import tn.esprit.spring.repository.ReviewRepository;



@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewRepository reviewrepository;
	//private static final Logger l =LogManager.getLogger(ReviewServiceImpl.class);
	  public List<Review> retriveAllReviews()
	  {
		  List<Review> reviews =(List<Review>) reviewrepository.findAll();
		  
		  for(Review review :reviews)
		  {
			  //l.info("Review +++ :" +review);
		  }
		  return reviews;
			  
	  }
	  public void AddReview(Review r)
	  {
		  reviewrepository.save(r); 
		  
	  }
	  public void DeleteReview(Review r)
	  {
		  reviewrepository.deleteById(r.getId()); 
	  }
	  public void UpdateReview(long ReviewID)
	  {   
		  Review r= new Review();
		  r=reviewrepository.findById(ReviewID).get();
		  reviewrepository.save(r);  
	  }
	  public Review getReviewById(Long id)   
	  {  
	  return reviewrepository.findById(id).get();  
	  }

	  
	  
	 

}
