package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.service.UserService;
import java.util.List;
import java.util.Random;

import tn.esprit.spring.entities.User;

@RestController
public class UserRestControl {
	
	
	@Autowired
	UserService userService;
	@Autowired
	BCryptPasswordEncoder cryptmdp;
	String chaine;


	// URL :http://localhost:8082/SpringMVC/servlet/RetriveAll
	@GetMapping("/RetriveAll")
	@ResponseBody
	public List<User> RetriveAll () {
		List<User> list = userService.RetriveAll();
		return list;}
	
	// URL :http://localhost:8082/SpringMVC/servlet/GetUsers/{userid}
		
    @GetMapping("/GetUsers/{userid}")
    @ResponseBody
	public User RetriveUser(@PathVariable("userid") Long userid){   	
    	return userService.getById(userid);
    }	
	
	// URL :http://localhost:8082/SpringMVC/servlet/UpdateUser

    @PostMapping ("/UpdateUser")  
    @ResponseBody
    public void AddUser (@RequestBody User u) {
     userService.updateuser (u);
    	
    }
    
    // URL :http://localhost:8082/SpringMVC/servlet/createUser
    
   @PostMapping ("/createUser")
    @ResponseBody
    public User CreateUser (@RequestBody User u) {
    	
    String pwd=u.getPassword();
 	Random rand = new Random();
	String crypt=cryptmdp.encode(pwd);
	u.setPassword(crypt);
	return userService.createuser(u);
    	
   
    }
    
    // URL :http://localhost:8082/SpringMVC/servlet/DeleteUser
    @DeleteMapping ("/DeleteUser/{userid}")
    @ResponseBody
    public void RemoveUser (@PathVariable("userid") Long userid) {
    	userService.deleteuser(userid);
       
    }
    
	
}