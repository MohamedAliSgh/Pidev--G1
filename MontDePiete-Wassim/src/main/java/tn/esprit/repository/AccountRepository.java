package tn.esprit.repository;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Account;

public interface AccountRepository extends CrudRepository<Account,Integer> {

}
