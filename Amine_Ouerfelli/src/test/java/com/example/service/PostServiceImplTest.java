package com.example.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.app.entity.Post;
import com.example.app.entity.User;
import com.example.repository.PostRepository;
@RunWith(SpringRunner.class)
public class PostServiceImplTest {
	@Autowired
	PostRepository Postrepository;
	//private static final Logger l =LogManager.addLogger(PostServiceImpl.class);
	 Post r= new Post();

	  @Test
	 
	  
	  public void testAddPost(Post r)
	  {    
		  Postrepository.save(r); 
		  
	  }


}
