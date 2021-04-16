package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planfinanciere")
public class Planfinanciere {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")	
	private Long id;
	private float Dr;
	private float van;
	private float ip;
	private float tri;
	private User user;
	private Media financialdoc;
	private String description;
	public Planfinanciere() {
		super();
	}
	
	public Planfinanciere(Long id, float dr, float van, float ip, float tri, User user, Media financialdoc) {
		this.id = id;
		Dr = dr;
		this.van = van;
		this.ip = ip;
		this.tri = tri;
		this.user = user;
		this.financialdoc = financialdoc;
	}
	public Long getId() {
		return id;
	}
	public float getDr() {
		return Dr;
	}
	public void setDr(float dr) {
		Dr = dr;
	}
	public float getVan() {
		return van;
	}
	public void setVan(float van) {
		this.van = van;
	}
	public float getIp() {
		return ip;
	}
	public void setIp(float ip) {
		this.ip = ip;
	}
	public float getTri() {
		return tri;
	}
	public void setTri(float tri) {
		this.tri = tri;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Media getFinancialdoc() {
		return financialdoc;
	}
	public void setFinancialdoc(Media financialdoc) {
		this.financialdoc = financialdoc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	

}
