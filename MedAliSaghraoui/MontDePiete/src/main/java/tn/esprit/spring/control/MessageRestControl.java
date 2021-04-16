package tn.esprit.spring.control;

import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Message;
import tn.esprit.spring.service.MessageService;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
@RestController
public class MessageRestControl {
     @Autowired
	MessageService messageService;
    
	// URL :http://localhost:8082/SpringMVC/servlet/RetriveAllMsg

	@GetMapping("/RetriveAllMsg")
	@ResponseBody
	
	public List<Message> RetriveAll() {
		List<Message> list = messageService.RetriveAll();
		return list;
		}
	
	// URL :http://localhost:8082/SpringMVC/servlet/DeleteMsg/{IdMessage}
	
	@DeleteMapping("/DeleteMsg/{IdMessage}")
	@ResponseBody

	
	public void DeleteMsg(@PathVariable("IdMessage") Long IdMessage) {
		
		messageService.deleteMessage(IdMessage);
		
	}
	
	// URL :http://localhost:8082/SpringMVC/servlet/save

	@PostMapping("/save")
	@ResponseBody
	
	public void UpdateSave (@RequestBody Message m) {
		messageService.updateorsave(m);
	}
	
	// URL :http://localhost:8082/SpringMVC/servlet/byId
	@GetMapping("byId/{IdMessage}")
	@ResponseBody
	
	public Message CatchById (@PathVariable("IdMessage") Long IdMessage) {
		return  messageService.RetrieveById(IdMessage);
	}
	
	
	
	}
