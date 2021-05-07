package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserSerivce {
	
	@Autowired
    UserRepository userRepository;
	
	@Override
	public User authenticate(String login, String password) {
	return userRepository.getUserByEmailAndPassword(login, password);
	}

	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	@Override
	public List<User> retrieveAllUsers() {
		List<User> users=(List<User>) userRepository.findAll();
		for (User user : users){
			L.info("user +++ :" + user);
		}
		return users;
	}

	@Override
	public User addUser(User u) {
		
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public User updateUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public long addOrUpdateUser(User u) {
	userRepository.save(u);
	return u.getId();
	}
	
	@Override
	public List<User> getAllUsers() {
	return (List<User>) userRepository.findAll();
	}
	
	@Override
	public User retrieveUser(String id) {
		L.info( "in retrieveUser id ="+id);
		User u =userRepository.findById(Long.parseLong(id)).orElse(null);
		L.info( "user returned ="+u);
		return u;
	}

}
