package tn.esprit.spring.service;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Loandemand;
import tn.esprit.spring.entities.User;

public interface LoanDemandService {
	public List<Loandemand> retriveAllLoanDemands();
	public void AddLoanDemand(Loandemand r);
	public void DeleteLoanDemand(Loandemand r);
	public void UpdateLoanDemand(long LoanDemandID);
	public Loandemand getLoanDemandById(Long id);
	public List<Loandemand> getLoanDemandByuser(User r);

	public Loandemand getJson(String loandemand, MultipartFile[] file);
}
