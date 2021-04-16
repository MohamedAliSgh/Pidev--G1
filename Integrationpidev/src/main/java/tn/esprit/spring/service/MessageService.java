package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.User;

public interface MessageService  {
	public List<Message> RetriveAll();
    public void deleteMessage(Long IdMessage);
    public void updateorsave(Message m);
    public Message RetrieveById(Long id);
    
	

}
