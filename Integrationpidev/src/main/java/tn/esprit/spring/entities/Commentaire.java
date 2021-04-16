package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import javax.persistence.Temporal;
@Entity
@Table(name="Commentaire")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@ManyToOne
	@JoinColumn(name="author",referencedColumnName="ID",insertable=false,updatable=false)	   
	private User author;
	@Column(columnDefinition = "varchar(255)",name="content",length=255,nullable=false,unique=false)
	private String Content;   
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@ManyToOne
	@JoinColumn(name="Post_id",referencedColumnName="ID",insertable=false,updatable=false)	   
	private Post post;
	public Commentaire( ) {
		super();

	}
	public Commentaire(long id, User author, String content, java.sql.Date date, Post post) {
		this.id = id;
		this.author = author;
		Content = content;
		this.date = date;
		this.post = post;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", author=" + author + ", Content=" + Content + ", date=" + date
				+ ", post=" + post + "]";
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public void setContent(String content) {
		Content = content;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public User getAuthor() {
		return author;
	}

	public String getContent() {
		return Content;
	}

	public Date getDate() {
		return date;
	}

	public Post getPost() {
		return post;
	}




}
