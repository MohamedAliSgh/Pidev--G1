package com.example.demo.services;

import com.example.demo.repositories.AccountRepository;
import com.example.demo.entities.Account;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class AccountService {

    @Autowired
    public AccountRepository repo;

    public Account createAccount() {
        return repo.save(new Account("foulen","benfoulen"));
    }

    public ArrayList<Account> getAccounts() {
        return repo.findAll();
    }

    public Account getAccountById(int id) {
        return repo.findById(id);
    }

    public Account createAccount(Account account) {
        return repo.save(account);
    }

    public Account update(int id, Account account) {
        Account a = repo.findById(id);
        a.update(account);
        return repo.save(a);
    }

    public String delete(int id) {
        Account account = repo.findById(id);
        repo.delete(account);
        return "deleted";
    }
}
