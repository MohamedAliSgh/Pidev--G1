package tn.esprit.entities;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Message_table")

public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long IdMessage ;
	private int IdSender;
	private int IdReceiver;
	private String BodyMessage;

	
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
		return this.BodyMessage;
	}
	public void setBodyMessage (String Message) 
	{ this.BodyMessage = Message ; }
	
	public Message (Long IdMsg ,int IdSnd , int IdRvr, String text) {
		this.IdMessage=IdMsg;
		this.IdSender=IdSnd;
		this.IdReceiver=IdRvr;
		this.BodyMessage=text;
	}
	@ManyToOne
	User useer;


	@Override
	public String toString() {
		return "Message [IdMessage=" + IdMessage + ", IdSender=" + IdSender + ", IdReceiver=" + IdReceiver
				+ ", BodyMessage=" + BodyMessage + ", useer=" + useer + "]";
	}
	
	
	
	
	
}
