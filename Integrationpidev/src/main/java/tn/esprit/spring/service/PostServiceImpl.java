package tn.esprit.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.repository.CommentaireJpaRepository;
import tn.esprit.spring.repository.MediaJpaRepository;
import tn.esprit.spring.repository.MediaRepository;
import tn.esprit.spring.repository.PostRepository;
import tn.esprit.spring.repository.ReactsJpaRepository;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostRepository Postrepository;
	MediaRepository mrepo;
	@Autowired
	MediaJpaRepository mediarepo;
	@Autowired
	CommentaireJpaRepository comrepo;
	@Autowired
	ReactsJpaRepository reactsrepo;
	
	private static final Logger l =LogManager.getLogger(PostServiceImpl.class);
	@Override
	  public List<Post> retriveAllPosts()
	  {
		  List<Post> Posts =(List<Post>) Postrepository.findAll();
		  
		  for(Post Post :Posts)
		  {
			  l.info("Post +++ :" +Post);
		  }
		  return Posts;
			  
	  }
	@Override
	  public void AddPost(Post p)
	  { 
		  Postrepository.save(p); 
		  
	  }
	@Override
	  public void DeletePost(Post r)
	  {
		  Postrepository.deleteById(r.getId()); 
	  }
	@Override
	  public void UpdatePost(long PostID)
	  {   
		  Post r= new Post();
		  r=Postrepository.findById(PostID).get();
		  Postrepository.save(r);  
	  }
	@Override
	  public Post getPostById(Long id)   
	  {  
	  return Postrepository.findById(id).get();  
	  }
	@Override
	public Post getJson(String post, MultipartFile[] files) {
        Post Postjson=new Post();
        try{
        	ObjectMapper objectMapper =new ObjectMapper();
        	Postjson=objectMapper.readValue(post,Post.class);    	
        }
        catch(IOException err)
        {
        	System.out.printf("Erreur",err.toString());
        }
       
        return Postjson;
	
	}
	
/*	@Override
	public List<Commentaire> Getpostcomments(Long postid) {
		return comrepo.retrivecommentsbypost(postid);
	 
	}
	@Override
	/*public List<Media> getpostmedia(Long postid) {
	    
		return mediarepo.retriveMediasbypost(postid);
	}
	@Override
	public List<Reacts> getpostreacts(Long postid) {
		return reactsrepo.retriveReactsbypost(postid);
	}  */
}
