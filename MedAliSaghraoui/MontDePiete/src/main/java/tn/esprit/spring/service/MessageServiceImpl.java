package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.MessageRepository;

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
	public void deleteMessage(Long IdMessage) {
		messagerepo.deleteById(IdMessage);
		
	}

	@Override
	public void updateorsave(Message m) {
		messagerepo.save(m);
		
	}
	
	@Override 
	public Message RetrieveById(Long id){
		
		
			  Message message=new Message();
			 try {
				message=messagerepo.findById(id).orElseThrow(()->new Exception("l'element n'existe pas"));
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
		    
		return message;
		
	}
	
	


}
