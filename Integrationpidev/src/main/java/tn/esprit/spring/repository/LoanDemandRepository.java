package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Loandemand;
import tn.esprit.spring.entities.User;



public interface LoanDemandRepository extends CrudRepository<Loandemand,Long>{
	public List<Loandemand> findLoandemandByPreteur(User r);
	public List<Loandemand> findLoanddemandByEmprunteur(User r);

}
