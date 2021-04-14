package com.example.app.service;

import java.util.List;

import com.example.app.entity.User;

public interface UserService  {
	List<User> RetriveaLL();
	void deleteuser(User u);
	void createuser(User u);
	void updateuser(User u);
	User findbyid(Long id);

}
