package tn.esprit.spring.entities;

import java.io.Serializable;
import javax.persistence.*;





import java.util.Date;
import java.util.Set;



@Entity 
@Table(name ="Table_User")
public class User implements Serializable {
	
	public User() {
		super();
		
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long userid;
	private String FirstName;
	private String LastName;
	private String Email ;
	private Date DateOfBirth;
	private String Gender ;
	private String login;
	private String Password;
	@Enumerated(EnumType.STRING)
	Role role;
	
	
	
	
	public String getFirstName() {
		return this.FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}
	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	public long getUserId() {
		return this.userid;
	}

	public void setUserId( Long id) {
		this.userid=id;
	}
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String mail) {
		this.Email=mail;
	}
	public Date getDateOfBirth() {
		return this.DateOfBirth;
	}

	public void setDateOfBirth(Date date) {
		this.DateOfBirth=date;
	}

	public String getGender() {
		return this.Gender;
	}

	public void setGender(String gendeer) {
		this.Gender=gendeer;
	}
	public String getLogin() {
		return this.Gender;
	}

	public void setLogin(String login) {
		this.login=login;
	}
	
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String pwd) {
		this.Password=pwd;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public void setRole(Role role) {
		this.role=role;
	}
	
	

	public User ( String name , String lastname , String email , Date date , String gender , String login , String pswd ) 
	{
		super();
		this.FirstName=name;
		this.LastName=lastname;
		this.Email=email;
		this.DateOfBirth=date;
		this.Gender=gender;
		this.login=login;
		this.Password=pswd;
	}

	
	
	public User (Long id , String name , String lastname , String email , Date date , String gender , String login , String pswd ) 
	{   
		super();
		this.userid=id;
		this.FirstName=name;
		this.LastName=lastname;
		this.Email=email;
		this.DateOfBirth=date;
		this.Gender=gender;
		this.login=login;
		this.Password=pswd;
	}

	@Override
	public String toString() {
		return "User [userid=" +userid+ ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
				+ ", DateOfBirth=" + DateOfBirth + ", Gender=" + Gender + ", Login=" + login + ", Password=" + Password
				+ ", role=" + role + "]";
	}
	
	

	@OneToMany(cascade=CascadeType.ALL,mappedBy="useer")
	private  Set<Message> Messages ;
}
