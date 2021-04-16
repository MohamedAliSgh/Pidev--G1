package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {

	public User findUserByLogin(String login);
	@Query("SELECT u FROM User u WHERE u.login=?1 AND u.Password=?2")
	User authetificate(String login,String pass);

}
