package com.example.app.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.entity.ProjectDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class ProjectDetailsImpl implements ProjectDetailService {

	@Override
	public ProjectDetail getJson(String projectdetail, MultipartFile[] file) {
        ProjectDetail pjjson=new ProjectDetail();
        try{
        	ObjectMapper objectMapper =new ObjectMapper();
        	pjjson=objectMapper.readValue(projectdetail,ProjectDetail.class);    	
        }
        catch(IOException err)
        {
        	System.out.printf("Erreur",err.toString());
        }
      
        return pjjson;
	}

}
