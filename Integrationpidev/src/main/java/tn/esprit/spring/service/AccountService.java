package tn.esprit.spring.service;

import java.util.Collection;

import tn.esprit.spring.entities.Account;

public interface AccountService {
	
	public abstract Collection<Account> getAccount();
	public abstract void addAccount();
	public abstract void modifyAccount();
	public abstract void deleteAccount();
	public abstract int consulterSolde(Account account);
	public abstract void informationCompte(Account account);
	public abstract void retraitMontant(Account account);
	public abstract void migrerCompte(Account account1,Account account2);
	
}
