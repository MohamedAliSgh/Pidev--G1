package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name ="Media")
public class Media implements Serializable {
	private static final long serialVersionUID = 1L;
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="ID")
       private long id;
	   @Column(name="Content",length=255,nullable=true)
       private String content;   
       @ManyToOne
       @JoinColumn(name="IDPost",referencedColumnName="ID",insertable=false,updatable=false)
       private Post post;
       @ManyToOne
       @JoinColumn(name="IDUser",referencedColumnName="ID",insertable=false,updatable=false)
       private User user;
       @Enumerated(EnumType.STRING)
       private Mediatype type;
       
    public Media(){
    	super();
    }

	public Media(long id, String content, Post post, User user) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
		this.user = user;
	}


	@Override
	public String toString() {
		return "Media [id=" + id + ", content=" + content + ", post=" + post + ", user=" + user + "]";
	}
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


    

       
}
