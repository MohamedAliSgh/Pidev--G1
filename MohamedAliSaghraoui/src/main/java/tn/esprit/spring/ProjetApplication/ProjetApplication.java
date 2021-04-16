package tn.esprit.spring.ProjetApplication;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import tn.esprit.entities.Message;
import tn.esprit.services.*;
import tn.esprit.repository.*;

@SpringBootApplication

public class ProjetApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
		
		
	}

	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(ProjetApplication.class);
	  }
	}


