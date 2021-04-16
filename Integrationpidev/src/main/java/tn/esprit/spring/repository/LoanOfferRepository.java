package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Domaine;
import tn.esprit.spring.entities.Loanoffer;
import tn.esprit.spring.entities.User;


public interface LoanOfferRepository extends CrudRepository<Loanoffer,Long> {
	public List<Loanoffer> findLoanofferByDomaine(Domaine D);
	public List<Loanoffer> findLoanofferByEditor(User editeur);

}
