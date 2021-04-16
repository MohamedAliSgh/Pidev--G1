package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Domaine;
import tn.esprit.spring.entities.Loanoffer;
import tn.esprit.spring.entities.User;

public interface LoanOfferService {
	  public List<Loanoffer> retriveAllLoanoffers();
	  public void AddLoanoffer(Loanoffer r);
	  public void DeleteLoanoffer(Loanoffer r);
	  public void UpdateLoanoffer(long LoanofferID);
	  public Loanoffer getLoanofferById(Long id);
	  public List<Loanoffer> getLoanofferByUser(User u);
	  public List<Loanoffer> getloanofferByDomaine(Domaine d);
}
