package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.*;

public interface MessageService {
	public List<Message> RetriveAll();
	void deleteMessage(Message m);
	void updateorsave(Message m);

}
