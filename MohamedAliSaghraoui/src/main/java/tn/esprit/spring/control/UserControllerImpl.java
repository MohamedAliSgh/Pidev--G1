package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.IUserSerivce;

@Scope(value = "session")
@Controller(value = "userController") // Name of the bean in Spring IoC
@ELBeanName(value = "userController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class UserControllerImpl {

	@Autowired
	IUserSerivce userService;
	private User authenticatedUser;
	private String login; 
	private String password; 
	private User user;
	private Boolean loggedIn;
	private String firstName; 
	private String lastName; 
	private String email;
	private boolean actif;
	private Role role; 
	private Date dateNaissance;
	private List<User> users;
	private Long userIdToBeUpdated;

	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser=userService.authenticate(login, password);
		if (authenticatedUser != null ) {
			if (authenticatedUser.getRole() == Role.ADMINISTRATEUR) {
		
			navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
			loggedIn = true; } 
			else { if ( authenticatedUser.getRole()==Role.LENDER) {
				navigateTo ="pages/clients/lender.xhtml?faces-redirect=true";
			}  else {
				navigateTo="pages/clients/borrower.xhtml?faces-redirect=true";
			}
				
				}
			}
		else {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

			FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
	}
	public void addUser() {
		userService.addOrUpdateUser(new User(firstName, lastName, email, password, actif, dateNaissance, role));
	}

	public Role[] getRoles() { 
		return Role.values();
	}

	public List<User> getUsers() {
		users = userService.getAllUsers();
		return users;
		}
	
	public void removeUser(String userId) {
		 userService.deleteUser(userId);
		 }
	
	public void displayUser(User user)
	{
	this.setFirstName(user.getFirstName());
	this.setLastName(user.getLastName());
	this.setActif(user.isActif());
	this.setEmail(user.getEmail());
	this.setRole(user.getRole());
	this.setDateNaissance(user.getDateNaissance());
	this.setPassword(user.getPassword());
	this.setUserIdToBeUpdated(user.getId());
	}
	public void updateUser()
	{ userService.addOrUpdateUser(new User(userIdToBeUpdated, firstName,lastName, email, password, actif, dateNaissance, role)); 
	}
	
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public User getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public long getUserIdToBeUpdated() {
		return userIdToBeUpdated;
	}
	public void setUserIdToBeUpdated(long userIdToBeUpdated) {
		this.userIdToBeUpdated = userIdToBeUpdated;
	}

}
