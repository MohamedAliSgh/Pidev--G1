package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.*;

public interface UserService {
	List<User> RetriveaLL();
	void deleteuser(User u);
	void createuser(User u);
	void updateuser(User u);
	User getById(Long userId);

}
