package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entities.Account;
import java.util.*;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    ArrayList<Account> findAll();
    Account findById(int id);
}
