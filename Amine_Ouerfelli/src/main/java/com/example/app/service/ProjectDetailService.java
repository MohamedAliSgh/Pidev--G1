package com.example.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.entity.ProjectDetail;

public interface ProjectDetailService {
	public ProjectDetail getJson(String projectdetail,MultipartFile[] files);

}
