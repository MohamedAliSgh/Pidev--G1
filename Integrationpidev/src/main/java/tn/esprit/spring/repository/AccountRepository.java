package tn.esprit.spring.repository;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Account;

public interface AccountRepository extends CrudRepository<Account,Integer> {

}
