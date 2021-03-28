package com.example.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Post;
import com.example.service.PostServiceImpl;
@CrossOrigin(origins = "http://localhost:3306")
@RestController  
@RequestMapping({ "/" })
public class PostController {
	@Autowired  
	PostServiceImpl PostService;
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
	private void deleteBook(@PathVariable("postid") Long postid)   
	{  
    Post p= new Post();
    p=PostService.getPostById(postid);
    if(p!=null)
	PostService.DeletePost(p);
    else
    System.out.println("Entité deja Supprimée/Entity already Deleted");
	}
	@PostMapping("/addPost")  
	private Long savepost(@RequestBody Post post)   
	{  
	PostService.AddPost(post);  
	return post.getId() ;
	}
	@PutMapping("/UpdatePost")  
	private  Post update(@RequestBody Post post)   
	{  
	PostService.UpdatePost(post.getId());  
	return post;  
	}
}

