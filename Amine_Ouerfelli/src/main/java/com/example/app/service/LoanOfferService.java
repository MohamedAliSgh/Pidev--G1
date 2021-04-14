package com.example.app.service;

import java.util.List;

import com.example.app.entity.Domaine;
import com.example.app.entity.Loanoffer;
import com.example.app.entity.User;

public interface LoanOfferService {
	  public List<Loanoffer> retriveAllLoanoffers();
	  public void AddLoanoffer(Loanoffer r);
	  public void DeleteLoanoffer(Loanoffer r);
	  public void UpdateLoanoffer(long LoanofferID);
	  public Loanoffer getLoanofferById(Long id);
	  public List<Loanoffer> getLoanofferByUser(User u);
	  public List<Loanoffer> getloanofferByDomaine(Domaine d);
}
