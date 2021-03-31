package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Message;

public interface MessageService  {
	public List<Message> RetriveAll();
	void deleteMessage(Message m);
	void updateorsave(Message m);

}
