package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
@Service
public interface UserService   {
	List<User> RetriveAll();
	void deleteuser(Long userid);
	User createuser(User u);
	User updateuser(User u);
	User getById(Long userid);
	User getuserbyloginandpassword(String login,String Password);

}

