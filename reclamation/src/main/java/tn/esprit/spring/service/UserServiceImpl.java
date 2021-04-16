package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.*;
import tn.esprit.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    UserRepository userrepo;
	@Override
	public List<User> RetriveaLL() {
		List<User> users =(List<User>) userrepo.findAll();
		return users;
	}

	@Override
	public void updateuser(User u) {
		userrepo.save(u);
		
	}

	@Override
	public void deleteuser(User u) {
		
		userrepo.delete(u);
	}



	@Override
	public void createuser(User u) {
		userrepo.save(u);
		
		
	}
	
	
	@Override 
	public User getById (Long userid){
		
		
			  User user=new User();
			 try {
				user=userrepo.findById(userid).orElseThrow(()->new Exception("l'element n'existe pas"));
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
		    
		return user;
		
	}
}
