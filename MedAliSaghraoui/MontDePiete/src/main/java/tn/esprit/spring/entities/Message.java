package tn.esprit.spring.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="table_Message")

public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long IdMessage ;
	private int IdSender;
	private int IdReceiver;
	private String bodyMessage;

	
	public Long getIdMessage() {
		return this.IdMessage ;
	}
	
	public void setIdMessage (Long Id) {
		this.IdMessage = Id;
		
	}
	
	public int getIdSender () {
		return this.IdSender;
	}
	public void setIdSender( int sender ) {
		this.IdSender=sender;
	}
	
	public int getIdReceiver (){
		return this.IdReceiver;
	}
	public void setIdReceiver (int receiver) {
		this.IdReceiver= receiver;
	}
	public String getBodyMessage () 
	{
		return this.bodyMessage;
	}
	public void setBodyMessage (String Message) 
	{ this.bodyMessage = Message ; }
	
	public Message(){}
	
	public Message (int IdSnd , int IdRvr, String text) {
		super();
		
		this.IdSender=IdSnd;
		this.IdReceiver=IdRvr;
		this.bodyMessage=text;
	}
	
	
	public Message (Long IdMsg ,int IdSnd , int IdRvr, String text) {
		super();
		this.IdMessage=IdMsg;
		this.IdSender=IdSnd;
		this.IdReceiver=IdRvr;
		this.bodyMessage=text;
	}
	@ManyToOne
	User useer;


	@Override
	public String toString() {
		return "Message [IdMessage=" + IdMessage + ", IdSender=" + IdSender + ", IdReceiver=" + IdReceiver
				+ ", BodyMessage=" + bodyMessage + ", useer=" + useer + "]";
	}
	
	
	
	
	
}