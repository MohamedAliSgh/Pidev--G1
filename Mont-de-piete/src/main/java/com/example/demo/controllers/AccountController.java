package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import com.example.demo.services.AccountService;
import com.example.demo.entities.Account;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;

import java.util.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Scope(value="session")
@Controller(value="accountController")
@ELBeanName(value="accountController")
@Join(path="/", to="/layout.jsf")
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;


    @GetMapping("/accounts")
    public ArrayList<Account> findAll() {
        return accountService.getAccounts();
    }

    @PostMapping("/accounts")
    public Account create(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/accounts/{id}")
    public Account findOne(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/accounts/{id}")
    public Account update(@PathVariable int id, @RequestBody Account account) {
        return accountService.update(id, account);
    }

    @DeleteMapping("/accounts/{id}")
    public String delete(@PathVariable int id) {
        return accountService.delete(id);
    }
}
