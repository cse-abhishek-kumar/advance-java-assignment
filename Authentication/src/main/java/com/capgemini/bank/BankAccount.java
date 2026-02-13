/**
 * 
 */
package com.capgemini.bank;

/**
 * 
 */
public class BankAccount {
	private int accountNumber;
	private String accountHolderName;
	private double currentBalance;
	
	public BankAccount(int accountNumber, String accountHolderName, double currentBalance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.currentBalance = currentBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	
	
	
}
