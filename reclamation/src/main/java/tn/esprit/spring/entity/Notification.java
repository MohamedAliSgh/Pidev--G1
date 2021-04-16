package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long idNotification ;
	public String email;
	public String description;
	@Temporal(TemporalType.DATE)
	public Date creationDate;
	
	public Long getIdNotification() {
		return this.idNotification ;
	}

	public void setIdNotification ( Long idNotification) {
		this.idNotification = idNotification;

	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return this.description ;
	}

	public void setDescription ( String description) {
		this.description =description;

	}


	public Date getCreationDate() {
		return this.creationDate ;
	}

	public void setCreationDate ( Date creationDate) {
		this.creationDate = creationDate;

	}
	
	public Notification(){}

	public Notification(String email, String description, Date creationDate, User user) {
		super();
		this.email = email;
		this.description = description;
		this.creationDate = creationDate;
		this.user = user;
	}

	public Notification(Long idNotification, String email, String description, Date creationDate, User user) {
		super();
		this.idNotification = idNotification;
		this.email = email;
		this.description = description;
		this.creationDate = creationDate;
		this.user = user;
	}



	@ManyToOne
	User user;
	@Override
	public String toString() {
		return "Notification [IdNotification=" + idNotification +", Email=" + email +   ", Description=" + description + ", CreationDate=" + creationDate + "]";
	}

	

}