package com.example.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CommentaireServiceImpl;

@RestController  
public class CommentaireController {
	@Autowired  
	CommentaireServiceImpl booksService;
 

}
