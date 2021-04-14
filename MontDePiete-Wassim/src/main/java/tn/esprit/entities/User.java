package tn.esprit.entities;

public class User {
	
	int id;
	String fullname;
	
	public User(int id, String fullname) {
		super();
		this.id = id;
		this.fullname = fullname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
}
