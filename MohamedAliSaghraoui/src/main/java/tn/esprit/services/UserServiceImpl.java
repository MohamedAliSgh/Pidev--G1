package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import tn.esprit.entities.User;
import tn.esprit.repository.UserRepository;

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

}
