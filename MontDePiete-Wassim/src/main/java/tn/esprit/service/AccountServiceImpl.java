package tn.esprit.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.entities.Account;
import tn.esprit.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository ar;
	Account account=new Account();
	@Override
	public Collection<Account> getAccount() {
		// TODO Auto-generated method stub
		Collection <Account> ca = (Collection<Account>)ar.findAll();
		return null;
	}

	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		ar.save(account);
	}

	@Override
	public void modifyAccount() {
		// TODO Auto-generated method stub
		
		ar.save(account);
	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub
		
		ar.delete(account);
	}

	@Override
	public int consulterSolde(Account account) {
		// TODO Auto-generated method stub
		ar.findOne(account.getAccountId());
		
		return (int)account.getBalance();
	}

	@Override
	public void informationCompte(Account account) {
		// TODO Auto-generated method stub
		ar.findOne(account.getAccountId());
		switch (account.getType())
		{
			case "Particulier" : System.out.println("le montant de retrait possible est de 700dt");
			case "Professionnel" : System.out.println("le montant de retrait possible est de 1000dt");
		}
			
	}

	@Override
	public void retraitMontant(Account account) {
		// TODO Auto-generated method stub
		float retrait = 500;
		account.setBalance(account.getBalance()-retrait);
		
	}

	@Override
	public void migrerCompte(Account account1, Account account2) {
		// TODO Auto-generated method stub
		account1.setBalance(account2.getBalance());
		account2.setBalance(account1.getBalance());
	}

}
