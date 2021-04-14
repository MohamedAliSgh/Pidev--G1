package com.example.app.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.app.entity.Media;
import com.example.app.entity.Post;
import com.example.app.service.MediaService;
import com.example.app.service.PostServiceImpl;

@RestController  

public class PostController {
	@Autowired  
	PostServiceImpl PostService;
	@Autowired
	MediaService Mediaser;
	@GetMapping("/Acceuil")  
	private List<Post> getAllBooks()   
	{  
	  return PostService.retriveAllPosts();
	} 
	@GetMapping("/Acceuil/{PostId}")  
	private Post ViewOnePost(@PathVariable("PostId") Long PostId)   
	{  
	return PostService.getPostById(PostId);  
	}
	@DeleteMapping("/Acceuil/{postid}")  
	private void deletePost(@PathVariable("postid") Long postid)   
	{  
    Post p= new Post();
    p=PostService.getPostById(postid);
    if(p!=null)
	PostService.DeletePost(p);
    else
    System.out.println("Entité deja Supprimée/Entity already Deleted");
	}
	@RequestMapping(value="/addPost", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)	
	private Post savepost(@RequestPart("Post") String post,@RequestPart("file") MultipartFile[] files)   
	{      List<Media> medialist= new ArrayList<>();
		    Post p=new Post();
		    p= p=PostService.getJson(post, files);  
		    
			      List<String> fileNames = new ArrayList<>();
			      for(MultipartFile file: files)
			      {Mediaser.save(file);
			      fileNames.add(file.getOriginalFilename());
			      Media m=new Media();
			      m.setName(file.getOriginalFilename());
			      m.setType(file.getOriginalFilename().split("\\.")[1]);			      
			      m.setPost(p);
			      PostService.AddPost(m.getPost());
			      Mediaser.AddMedia(m);
			      medialist.add(m);
			      p.setMedialist(medialist);
			      }
			    
		   
    
	PostService.AddPost(p);  
	return p;
	}
	@PutMapping("/UpdatePost")  
	private  Post update(@RequestBody Post post)   
	{  
	PostService.UpdatePost(post.getId());  
	return post;  
	}
}

