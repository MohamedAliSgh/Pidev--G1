package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.User;

public interface UserService  {
	List<User> RetriveaLL();
	void deleteuser(User u);
	void createuser(User u);
	void updateuser(User u);

}
