package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Planfinanciere;
import tn.esprit.spring.entities.User;



public interface PlanfinancierService 
{
	public List<Planfinanciere> retriveAlldocs();
	public void Adddocument(Planfinanciere r);
	public void Deleteplan(Planfinanciere r);
	public void Updateplan(Planfinanciere r);
	public Planfinanciere getPlanfinanciereById(Long id);
	public Planfinanciere getPlanfinanciereByuser(User u);
}
