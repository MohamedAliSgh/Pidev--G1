package tn.esprit.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Sms {

	private String to;
    private String message;
    
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
