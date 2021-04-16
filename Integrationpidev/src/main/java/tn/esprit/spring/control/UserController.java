package tn.esprit.spring.control;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.UserServiceImpl;



@RestController
public class UserController {
	@Autowired  
	UserServiceImpl userService;

	@GetMapping("/Allusers") 
	@RequestMapping
	private List<User>getAllUsers()   
	{  
	  return userService.RetriveaLL();
	} 
	/*@GetMapping("/Allusers/{userid}")  
	private Post ViewOnePost(@PathVariable("userid") Long userid)   
	{  
	return userService.getPostById(userid);  
	}*/
	@DeleteMapping("/AllUsers/{userid}")  
	private void deletePost(@PathVariable("userid") Long userid)   
	{  
    User user=userService.findbyid(userid);
	userService.deleteuser(user);

	}
	@RequestMapping(value="/addUser")	
	private User savepost(@RequestBody User user)   
	{  
	  userService.createuser(user);	
	  return user;
	}
	@PutMapping("/UpdateUser")  
	private  User update(@RequestBody User user)   
	{  
	  userService.updateuser(user);
	  return user;  
	}

}
