package com.example.entity;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Post")
public class Post {
	private static final long serialVersionUID = 1L;
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="ID")
    private long id;
	@ManyToOne
    @JoinColumn(name="author",referencedColumnName="ID",insertable=false,updatable=false)
	private User user;
	@Column(name="Contenu",columnDefinition = "varchar(255)",nullable=true)
	private String content;
	@OneToMany(mappedBy="Post")
	private List<Commentaire> Comments;
	@OneToMany(mappedBy="Post")
	private List<Reacts> Reacts;
	@OneToMany(mappedBy="Post")
	private List<Media> Medialist;
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date date;
	public Post(){
		super();
	}	
	public Post(long id, User user, String content, List<Commentaire> comments, List<com.example.entity.Reacts> reacts,
			List<Media> medialist, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		Comments = comments;
		Reacts = reacts;
		Medialist = medialist;
		this.date = date;
	}


	public void setUser(User user) {
		this.user = user;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setComments(List<Commentaire> comments) {
		Comments = comments;
	}
	public void setReacts(List<Reacts> reacts) {
		Reacts = reacts;
	}
	public void setMedialist(List<Media> medialist) {
		Medialist = medialist;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public String getContent() {
		return content;
	}
	public List<Commentaire> getComments() {
		return Comments;
	}
	public List<Reacts> getReacts() {
		return Reacts;
	}
	public List<Media> getMedialist() {
		return Medialist;
	}
	public Date getDate() {
		return date;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", user=" + user + ", content=" + content + ", Comments=" + Comments + ", Reacts="
				+ Reacts + ", Medialist=" + Medialist + ", date=" + date + "]";
	}


}
