package tn.esprit.spring.control;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Commentaire;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.service.CommentaireService;
import tn.esprit.spring.service.PostService;


@RestController  
public class CommentaireController {
	@Autowired  
	CommentaireService ComService;
	@Autowired
	PostService postService;
	@GetMapping("/getallcomments")  
	private List<Commentaire> getAllComments()   
	{  
	  return ComService.retriveAllCommentaires();
	} 
	@GetMapping("/getallcomments/{post}")  
	private List<Commentaire> getAllcommbypost(@PathVariable("post") Long post)   
	{  
	  Post p=new Post();
	  p=postService.getPostById(post);
	  return p.getComments();
	} 
	@GetMapping("/Acceuil/comments/{CommId}")  
	private Commentaire ViewOnePost(@PathVariable("CommId") Long CommId)   
	{  
	return ComService.getCommentaireById(CommId);  
	}
	@DeleteMapping("/Acceuil/post/{commid}")  
	private void deletePost(@PathVariable("commid") Long commid)   
	{  
    Commentaire c= new Commentaire();
    c=ComService.getCommentaireById(commid);
 
    if(c!=null)
    { c.getPost().getComments().remove(c);
	ComService.DeleteCommentaire(c);}
    else
    System.out.println("Entité deja Supprimée/Entity already Deleted");
	}
	@PostMapping("/addcomment/{post}")  
	private Long savecommentaire(@RequestBody Commentaire comment,@PathVariable("post") Long post)   
	{  
    Post p=new Post();
    p=postService.getPostById(post);
    comment.setPost(p);
    p.getComments().add(comment);
    LocalDate localDate = LocalDate.now();
    Date date = new Date(localDate.atStartOfDay(ZoneId.of("America/New_York")).toEpochSecond() * 1000);
    comment.setDate(date);   
	ComService.AddCommentaire(comment);  
	return comment.getId() ;
	}
	@PutMapping("/UpdateComment")  
	private  Commentaire update(@RequestBody Commentaire c)   
	{  
	ComService.UpdateCommentaire(c.getId());  
	return c ;  
	}
 

}
