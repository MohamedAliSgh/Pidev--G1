package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Message;
import tn.esprit.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageRepository messagerepo;
	
	@Override
	public List<Message> RetriveAll() {
		List<Message> dali =(List<Message>) messagerepo.findAll();
		return dali;
	}

	@Override
	public void deleteMessage(Message m) {
		messagerepo.delete(m);
		
	}

	@Override
	public void updateorsave(Message m) {
		messagerepo.save(m);
		
	}



}
