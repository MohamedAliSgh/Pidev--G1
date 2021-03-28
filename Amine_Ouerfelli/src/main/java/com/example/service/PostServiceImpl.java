package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Post;
import com.example.repository.PostRepository;
@Service
public class PostServiceImpl {
	@Autowired
	PostRepository Postrepository;
	//private static final Logger l =LogManager.addLogger(PostServiceImpl.class);
	  public List<Post> retriveAllPosts()
	  {
		  List<Post> Posts =(List<Post>) Postrepository.findAll();
		  
		  for(Post Post :Posts)
		  {
			  //l.info("Post +++ :" +Post);
		  }
		  return Posts;
			  
	  }
	  public void AddPost(Post r)
	  {
		  Postrepository.save(r); 
		  
	  }
	  public void DeletePost(Post r)
	  {
		  Postrepository.deleteById(r.getId()); 
	  }
	  public void UpdatePost(long PostID)
	  {   
		  Post r= new Post();
		  r=Postrepository.findById(PostID).get();
		  Postrepository.save(r);  
	  }
	  public Post getPostById(Long id)   
	  {  
	  return Postrepository.findById(id).get();  
	  }  
}
