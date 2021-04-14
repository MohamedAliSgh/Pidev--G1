package com.example.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Domaine;
import com.example.app.entity.Loanoffer;
import com.example.app.entity.User;

public interface LoanOfferRepository extends CrudRepository<Loanoffer,Long> {
	public List<Loanoffer> findLoanofferByDomaine(Domaine D);
	public List<Loanoffer> findLoanofferByEditor(User editeur);

}
