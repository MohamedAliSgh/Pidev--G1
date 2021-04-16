package tn.esprit.spring.service;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.ProjectDetail;



public interface ProjectDetailService {
	public ProjectDetail getJson(String projectdetail,MultipartFile[] files);

}
