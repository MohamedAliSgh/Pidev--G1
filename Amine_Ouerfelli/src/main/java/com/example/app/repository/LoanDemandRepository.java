package com.example.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Loandemand;
import com.example.app.entity.User;

public interface LoanDemandRepository extends CrudRepository<Loandemand,Long>{
	public List<Loandemand> findLoandemandByPreteur(User r);
	public List<Loandemand> findLoanddemandByEmprunteur(User r);

}
