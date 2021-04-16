package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import tn.esprit.spring.entity.Priorities;

@Entity
@Table
public class Reclamation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idClaim ;
	@Column(name="telNum",length=8)
	private int telNum;
	private String title;
	@NotNull
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	@Enumerated(EnumType.STRING)
	Priorities priorities;



	public Long getIdClaim() {
		return this.idClaim ;
	}

	public void setIdClaim ( Long idClaim) {
		this.idClaim = idClaim;

	}


	public int getTelNum() {
		return this.telNum ;
	}



	public void setTelNum ( int telNum) {
		this.telNum = telNum;

	}



	public String getTitle() {
		return this.title ;
	}

	public void setTitre ( String title) {
		this.title = title;

	}


	public String getDescription() {
		return this.description ;
	}

	public void setDescription ( String description) {
		this.description =description;

	}


	

	public Priorities getPriorities() {
		return priorities;
	}

	public void setPriorities(Priorities priorities) {
		this.priorities = priorities;
	}

	public Date getCreationDate() {
		return this.creationDate ;
	}

	public void setCreationDate ( Date creationDate) {
		this.creationDate = creationDate;

	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Reclamation (){}
	

	public Reclamation(int telNum, String title, String description, Date creationDate, Priorities priorities,
			User user) {
		super();
		this.telNum = telNum;
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.priorities = priorities;
		this.user = user;
	}
	
	
	public Reclamation(Long idClaim, int telNum, String title, String description, Date creationDate,
			Priorities priorities, User user) {
		super();
		this.idClaim = idClaim;
		this.telNum = telNum;
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.priorities = priorities;
		this.user = user;
	}



	@ManyToOne
	User user;

	@Override
	public String toString() {
		return "claim [IdClaim=" + idClaim +  ", TelNum=" + telNum + ", Title=" + title + ", Description=" + description + ", CreationDate=" + creationDate + ", Priorities=" + priorities + "]";
	}



}
