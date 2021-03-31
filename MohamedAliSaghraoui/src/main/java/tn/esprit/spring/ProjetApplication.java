package tn.esprit.spring;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.esprit.entities.Message;

@SpringBootApplication
public class ProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
		Message message = new Message((long) 2,1,1,"text");
		List<Message> test ;
		//test= RetriveAll(); 
		
	}

}
