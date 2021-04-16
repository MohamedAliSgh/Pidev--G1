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
@Table(name="Review")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="ID")
    private long id;
	@Column(columnDefinition = "varchar(255)",name="content",length=255,nullable=false,unique=false)  
	private String content;
	@Column(columnDefinition = "integer",name="Score")
	private int score;
	@ManyToOne
	@JoinColumn(name="Reviewer",referencedColumnName="ID",insertable=false,updatable=false)	   
	private User Reviewer;
	@ManyToOne
	@JoinColumn(name="reviewed",referencedColumnName="ID",insertable=false,updatable=false)	   
	private User Reviewed;
	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + ", score=" + score + ", Reviewer=" + Reviewer
				+ ", Reviewed=" + Reviewed + "]";
	}
	public Review(long id, String content, int score, User reviewer, User reviewed) {
		super();
		this.id = id;
		this.content = content;
		this.score = score;
		Reviewer = reviewer;
		Reviewed = reviewed;
	}
	public Review() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public User getReviewer() {
		return Reviewer;
	}
	public void setReviewer(User reviewer) {
		Reviewer = reviewer;
	}
	public User getReviewed() {
		return Reviewed;
	}
	public void setReviewed(User reviewed) {
		Reviewed = reviewed;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
