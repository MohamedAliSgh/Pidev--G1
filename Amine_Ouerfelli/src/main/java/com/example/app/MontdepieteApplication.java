package com.example.app;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.example.app.service.MediaService;


@SpringBootApplication
public class MontdepieteApplication {
	  @Resource
	  MediaService storageService;
	public static void main(String[] args) {
		SpringApplication.run(MontdepieteApplication.class, args);
	}
	  public void run(String... arg) throws Exception {
	    storageService.init();
	  }

}
