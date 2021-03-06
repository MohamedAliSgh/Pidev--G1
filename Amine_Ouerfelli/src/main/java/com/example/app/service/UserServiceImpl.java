package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.app.entity.User;
import com.example.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired 
    UserRepository userrepo;
	@Override
	public List<User> RetriveaLL() {
		List<User> users =(List<User>) userrepo.findAll();
		return users;
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
	public void updateuser(User u) {
		userrepo.save(u);
		
	}

	@Override
	public User findbyid(Long id) {
		return userrepo.findById(id).get();
		
	}

	
}
