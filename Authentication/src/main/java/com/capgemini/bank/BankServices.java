/**
 * 
 */
package com.capgemini.bank;

/**
 * 
 */
public class BankServices {
	
	public boolean deposit(BankAccount accountNumber,double amount) {
		if(amount<0) {
			return false;
		}
		double bal = accountNumber.getCurrentBalance()+amount;
		accountNumber.setCurrentBalance(bal);
		return true;
	}
	
	public boolean withdraw(BankAccount accountNumber,double amount) {
		double bal = accountNumber.getCurrentBalance();
		if(amount>bal) {
			return false;
		}else {
		accountNumber.setCurrentBalance(bal-amount);
		return true;
		}
	}
	
	public boolean minBal(BankAccount accountNumber) {
		if(accountNumber.getCurrentBalance()<1000) {
			return false;
		}
		return true;
	}
}
