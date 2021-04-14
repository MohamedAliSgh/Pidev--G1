package com.example.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.app.entity.ProjectDetail;

public interface ProjectDetailRepository extends CrudRepository<ProjectDetail,Long> {

}
