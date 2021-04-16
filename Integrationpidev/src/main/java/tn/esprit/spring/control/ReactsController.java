package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.PostService;
import tn.esprit.spring.service.ReactsService;


@RestController
public class ReactsController {
	@Autowired  
	ReactsService reactsService;
	@Autowired
	PostService postService;
	/*@GetMapping("/getallReacts")  
	private List<Reacts> getAllBooks()   
	{  
	  return reactsService.getReactByPost(p);
	} */
	@GetMapping("/Acceuil/post/{post}")  
	private Reacts ViewOnePost(@PathVariable("post") Long post)   
	{  
	return reactsService.getReactById(post);  
	}
	@DeleteMapping("/Acceuil/post/{reactid}")  
	private void deletereacts(@PathVariable("post") Long postid,@PathVariable("reactid")  Long idreacts)   
	{  
     Reacts r= reactsService.getReactById(idreacts);
     r.getPost().getReacts().remove(r);
	 reactsService.DeleteReact(r);

	}
	@PostMapping("/addreact/{post}/{value}")  
	private Reacts savereacts(@PathVariable("post") Long postid,@PathVariable("value")  int valeur)   
	{ 

	Reacts r=new Reacts();
	r.setType(valeur);
	Post p=new Post();
	p=postService.getPostById(postid);
	r.setPost(p);
	postService.getPostById(postid).getReacts().add(r);
	reactsService.AddReact(r);
	return r;
	}
	@PutMapping("/Updatereact")  
	private  Reacts update(@RequestBody Reacts r)   
	{  
	reactsService.UpdateReact(r.getId());  	
	return r;  
	}
 

}
