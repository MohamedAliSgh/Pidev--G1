package tn.esprit.spring.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;

	private String firstName ;

	private String lastName ;
	
	private String email;
	
	private String password;
	
	private boolean actif;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@Enumerated (EnumType.STRING)
	Role role;

	public User() { }
 
	public User(String firstName, String lastName, String email, String password, boolean actif, Date dateNaissance, Role role ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.dateNaissance = dateNaissance;
		this.role = role;
	}
	
	public User(Long id, String firstName, String lastName, String email, String password, boolean actif, Date dateNaissance, Role role ) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.dateNaissance = dateNaissance;
		this.role = role;
	}
	

	@Override
	public String toString() {
		return "User [firstName=" + firstName +", lastName=" + lastName + ", dateNaissance=" + 
	dateNaissance + ", role=" + role + "]";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

}

