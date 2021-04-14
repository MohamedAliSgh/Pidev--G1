package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

	@Entity 
	@Table(name ="Account_Table")

	public class Account implements Serializable {
		private static final long serialVersionUID = 1L;
		
		int AccountId;
		float Balance;
		String Type;
		
		public int getAccountId() {
			return AccountId;
		}
		public void setAccountId(int accountId) {
			AccountId = accountId;
		}
		public float getBalance() {
			return Balance;
		}
		public void setBalance(float balance) {
			Balance = balance;
		}
		public String getType() {
			return Type;
		}
		public void setType(String type) {
			Type = type;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
	}


