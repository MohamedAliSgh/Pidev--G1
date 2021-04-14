package com.example.app.service;

import java.util.List;


import com.example.app.entity.Planfinanciere;
import com.example.app.entity.User;

public interface PlanfinancierService 
{
	public List<Planfinanciere> retriveAlldocs();
	public void Adddocument(Planfinanciere r);
	public void Deleteplan(Planfinanciere r);
	public void Updateplan(Planfinanciere r);
	public Planfinanciere getPlanfinanciereById(Long id);
	public Planfinanciere getPlanfinanciereByuser(User u);
}
