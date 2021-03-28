package com.example.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Post;
import com.example.repository.PostRepository;
@RunWith(SpringRunner.class)
public class PostServiceImplTest {
	@Autowired
	PostRepository Postrepository;
	//private static final Logger l =LogManager.addLogger(PostServiceImpl.class);
	 @Test
	  public List<Post> TestretriveAllPosts()
	  {
		  List<Post> Posts =(List<Post>) Postrepository.findAll();
		  
		  for(Post Post :Posts)
		  {
			  //l.info("Post +++ :" +Post);
		  }
		  return Posts;
			  
	  }
	  @Test
	  public void testAddPost(Post r)
	  {
		  Postrepository.save(r); 
		  
	  }
	  @Test
	  public void testDeletePost(Post r)
	  {
		  Postrepository.deleteById(r.getId()); 
	  }
	  @Test
	  public void testUpdatePost(long PostID)
	  {   
		  Post r= new Post();
		  r=Postrepository.findById(PostID).get();
		  Postrepository.save(r);  
	  }
	  @Test
	  public Post testgetPostById(Long id)   
	  {  
	  return Postrepository.findById(id).get();  
	  } 
}
