package tn.esprit.spring.entities;

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
	   private String name;
	   private String url;



	   public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", name=" + name + ", url=" + url + ", post=" + post + ", user=" + user + ", type="
				+ type + "]";
	}

	public String getName() {
	     return this.name;
	   }

	   public void setName(String name) {
	     this.name = name;
	   }

	   public String getUrl() {
	     return this.url;
	   }

	   public void setUrl(String url) {
	     this.url = url;
	   }
       @ManyToOne
       @JoinColumn(name="IDPost",referencedColumnName="ID",insertable=false,updatable=false)
       private Post post;
       @ManyToOne
       @JoinColumn(name="IDUser",referencedColumnName="ID",insertable=false,updatable=false)
       private User user;
    
       private String type;
       


    

       
}
