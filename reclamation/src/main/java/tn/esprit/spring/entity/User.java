package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import tn.esprit.spring.entity.Profile;


@Entity 
@Table(name ="User_Table")
public class User implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long userid;
	private String FirstName;
	private String LastName;
	private String Email ;
	private Date DateOfBirth;
	private String Gender ;
	private String Login;
	private String Password;
	@Enumerated(EnumType.STRING)
	Profile profile;
	
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
		this.Login=login;
	}
	
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String pwd) {
		this.Password=pwd;
	}
	
	public Profile getprofile() {
		return this.profile;
	}

	public void setprofile(Profile profile) {
		this.profile=profile;
	}
	
	
	public User(){}
	
	public User (String name , String lastname , String email , Date date , String gender , String login , String pswd ) 
	{
		
		this.FirstName=name;
		this.LastName=lastname;
		this.Email=email;
		this.DateOfBirth=date;
		this.Gender=gender;
		this.Login=login;
		this.Password=pswd;
	}

	public User (Long id , String name , String lastname , String email , Date date , String gender , String login , String pswd ) 
	{
		this.userid=id;
		this.FirstName=name;
		this.LastName=lastname;
		this.Email=email;
		this.DateOfBirth=date;
		this.Gender=gender;
		this.Login=login;
		this.Password=pswd;
	}

	@Override
	public String toString() {
		return "User [userid=" +userid+ ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
				+ ", DateOfBirth=" + DateOfBirth + ", Gender=" + Gender + ", Login=" + Login + ", Password=" + Password
				+ ", profile=" + profile + "]";
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="useer")
	private  Set<Message> Messages ;

}
