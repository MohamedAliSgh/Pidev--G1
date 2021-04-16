package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Reacts")
public class Reacts implements Serializable {
	private static final long serialVersionUID = 1L;
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="ID")
    private long id;
    @ManyToOne
    @JoinColumn(name="Postid",referencedColumnName="ID",insertable=false,updatable=false)  
	private Post post;
	@ManyToOne
    @JoinColumn(name="User",referencedColumnName="ID",insertable=false,updatable=false)	   
	private User user;
	@Column(columnDefinition = "integer",name="type")
	private int type;
	
	public Reacts() {
		super();
	}
	public Reacts(long id, Post post, User user, int type) {
		super();
		this.id = id;
		this.post = post;
		this.user = user;
		this.type = type;
	}
	public long getId() {
		return id;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Reacts [id=" + id + ", post=" + post + ", user=" + user + ", type=" + type + "]";
	}

	
	

}
