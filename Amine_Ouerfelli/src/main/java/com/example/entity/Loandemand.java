package com.example.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.TemporalType;

import javax.persistence.Temporal;

@Entity
@Table(name="LoanDemand")
public class Loandemand implements Serializable {
	private static final long serialVersionUID = 1L;
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="ID")
    private long id;
	@OneToMany(mappedBy="LoanDemand")
    private List<Media> Files ;
	   @ManyToOne
	   @JoinColumn(name="emprunteur",referencedColumnName="ID",insertable=false,updatable=false)	 	
    private User emprunteur;  
	   @ManyToOne
	   @JoinColumn(name="preteur",referencedColumnName="ID",insertable=false,updatable=false)
	private User preteur;
    @Column(name="date")
    @Temporal(value=TemporalType.TIMESTAMP)
	private Date date;
    
	@OneToOne
	private ProjectDetail details;
	
	public Loandemand() {
	   super();
	}

	public Loandemand(long id, User emprunteur, User preteur, Date date, Domaine domaine, ProjectDetail details) {
		this.id = id;
		this.emprunteur = emprunteur;
		this.preteur = preteur;
		this.date = date;
		this.details = details;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public List<Media> getFiles() {
		return Files;
	}

	public User getEmprunteur() {
		return emprunteur;
	}

	public User getPreteur() {
		return preteur;
	}

	public Date getDate() {
		return date;
	}


	public ProjectDetail getDetails() {
		return details;
	}

	public void setFiles(List<Media> files) {
		Files = files;
	}

	public void setEmprunteur(User emprunteur) {
		this.emprunteur = emprunteur;
	}

	public void setPreteur(User preteur) {
		this.preteur = preteur;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public void setDetails(ProjectDetail details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Loandemand [id=" + id + ", emprunteur=" + emprunteur + ", preteur=" + preteur + ", date=" + date
				+ ", details=" + details + "]";
	}
	
	
	
	
	
	
}
