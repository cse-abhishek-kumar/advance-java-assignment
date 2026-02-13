/**
 * 
 */
package com.capgemini.logintest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.capgemini.login.Login;

/**
 * 
 */
public class LoginTest {
	
	@Test
    void validUsernameTest() {
        assertTrue(Login.isValidUsername("Abhi123"));
    }
	
	@Test
	void usernameWithSpecialChar() {
		assertFalse(Login.isValidUsername("Abhi@123"));
	}
	
	@Test
	void nullUsername() {
		assertFalse(Login.isValidUsername(null));
	}
	@Test
	void emptyUsername() {
		assertFalse(Login.isValidUsername(""));
	}
	@Test
	void tooShortUsername() {
		assertFalse(Login.isValidUsername("Abi1"));
	}
	@Test
	void tooLongUsername() {
		assertFalse(Login.isValidUsername("Abhishek1234567890"));
	}
	
	@Test
	void validPasswordTest() {
	    assertTrue(Login.isValidPassword("Pass@123"));
	}

	@Test
	void passwordWithoutSpecialChar() {
	    assertFalse(Login.isValidPassword("Pass1234"));
	}

	@Test
	void passwordTooShort() {
	    assertFalse(Login.isValidPassword("P@1a"));
	}

	@Test
	void nullPasswordTest() {
	    assertFalse(Login.isValidPassword(null));
	}
}
