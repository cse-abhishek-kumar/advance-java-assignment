/**
 * 
 */
package com.capgemini.banktest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.capgemini.bank.BankAccount;
import com.capgemini.bank.BankServices;

/**
 * 
 */
public class BankValidationTest {
	BankAccount ba = new BankAccount(101, "Abhishek", 6000);
	BankServices bs = new BankServices();
	@Test
	void depositcheck() {
		assertTrue(bs.deposit(ba, 6000));
	}
	@Test
	void withdrawlTest() {
		assertTrue(bs.withdraw(ba, 2000));
	}
	@Test
	void withdrawlMoreThanBal() {
		assertFalse(bs.withdraw(ba, 7000));
	}
	@Test
	void minBalTest() {
		assertTrue(bs.minBal(ba));
	}
}
