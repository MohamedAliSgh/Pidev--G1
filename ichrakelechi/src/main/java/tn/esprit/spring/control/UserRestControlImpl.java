package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserService;
@RestController
public class UserRestControlImpl {
	@Autowired
	UserService UserService ;
	
	// URL: http://localhost:8081/SpringMVC/servlet/retrieve-all-User
	@GetMapping("/retrieve-all-User")
	@ResponseBody
	public List<User> retriveAllUsers(){
		List<User> list = UserService.RetriveaLL();
		return list;
		}
	
	
	// URL: http://localhost:8081/SpringMVC/Servlet/deleteUser
	//@DeleteMapping("/deleteUser")  
	//public void deleteuser(@PathVariable("userId") int userId)   
	//{  
    //User u= new User();
   // u=UserService.getById(userId);
   // if(r!=null)
	//ReclamationService.deleteReclamation(r);
   // else
   // System.out.println("Reclamation deja Supprimée/claim already Deleted");
	//}
	
	// URL: 

	
	
	@PostMapping("/addUser")  
	public User savepost(@RequestBody User u)   
	{  
	UserService.createuser(u);  
	return u ;
	}
	
	// URL: http://localhost:8081/SpringMVC/Servlet/UpdateUser
	@PutMapping("/Updateuseer")  
	public User update(@RequestBody User u)   
	{  
	UserService.updateuser(u);  
	return u;  
	}

}
