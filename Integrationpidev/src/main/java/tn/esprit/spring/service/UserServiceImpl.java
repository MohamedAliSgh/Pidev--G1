package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    UserRepository userrepo;
	@Override
	public List<User> RetriveAll() {
		List<User> users =(List<User>) userrepo.findAll();
		return users;
	}

	@Override
	public User updateuser(User u) {
		return userrepo.save(u);
		
		
	}

	@Override
	public void deleteuser(Long userid) {
		
		userrepo.deleteById(userid);
	}



	@Override
	public User createuser(User u) {
		 return userrepo.save(u);
		
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

	@Override
	public User getuserbyloginandpassword(String login, String Password) {
		return userrepo.authetificate(login, Password);
		
	}
	

}

