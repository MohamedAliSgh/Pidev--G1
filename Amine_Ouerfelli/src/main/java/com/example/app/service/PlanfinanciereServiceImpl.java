package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Planfinanciere;
import com.example.app.entity.User;
import com.example.app.repository.PlanfinanciereRepository;
@Service
public class PlanfinanciereServiceImpl implements PlanfinancierService {
    @Autowired 
    PlanfinanciereRepository  planrepo;
	@Override
	public List<Planfinanciere> retriveAlldocs() {
		return (List<Planfinanciere>) planrepo.findAll();
		
	}

	@Override
	public void Adddocument(Planfinanciere r) {
		planrepo.save(r);
		
	}

	@Override
	public void Deleteplan(Planfinanciere r) {
		
		 planrepo.delete(r);
	}

	@Override
	public void Updateplan(Planfinanciere r) {
		planrepo.save(r);
		
	}

	@Override
	public Planfinanciere getPlanfinanciereById(Long id) {
		return planrepo.findById(id).get();
	}

	@Override
	public Planfinanciere getPlanfinanciereByuser(User u) {
		
       return planrepo.findPlanfinanciereByUser(u);
	}

}
