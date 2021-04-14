package com.example.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Planfinanciere;
import com.example.app.entity.User;

public interface PlanfinanciereRepository extends CrudRepository<Planfinanciere,Long>{
        public Planfinanciere findPlanfinanciereByUser(User u);
}
