package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImpTest {
	
	@Autowired
	IUserSerivce us;
	
	@Test
	public void testRetrieveAllUsers() {
		List<User> listUsers = us.retrieveAllUsers();
		Assert.assertEquals(1, listUsers.size());
	}
	@Test
	public void testAddUser() throws ParseException {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 Date d = dateFormat.parse("1998-03-26");
	 User u = new User(null, "test", "tester", null, null, false, d, Role.BORROWER);
	 User UserAdded = us.addUser(u);
     Assert.assertEquals(u.getLastName(), UserAdded.getLastName());
    }
	@Test
	public void testModifyUser() throws ParseException {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 Date d = dateFormat.parse("1998-06-18");
	 User u = new User(5L, "Besma", "Fodha", null, null, false, d, Role.BORROWER);
	 User UserUpdated = us.updateUser(u);
     Assert.assertEquals(u.getLastName(), UserUpdated.getLastName());
	}
	@Test
	public void testRetrieveUser() {
		User userRetrieved = us.retrieveUser("5");
	Assert.assertEquals(5L, userRetrieved.getId().longValue());
	}
	@Test
	public void testDeleteUser() {
		us.deleteUser("5");
		Assert.assertNull(us.retrieveUser("5"));
	}
	
	
}

