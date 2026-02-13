/**
 * 
 */
package com.capgemini.login;

/**
 * 
 */
public class Login {
	
	public static boolean isValidUsername(String username) {

        if (username == null || username.isEmpty()) {
            System.out.println("Username cannot be null or empty");
            return false;
        }

        if (!username.matches("^[A-Za-z0-9]{5,15}$")) {
            System.out.println("Username must be 5-15 characters and contain only letters and digits");
            return false;
        }

        return true;
    }
	
	 public static boolean isValidPassword(String password) {

	        if (password == null || password.isEmpty()) {
	            System.out.println("Password cannot be null or empty");
	            return false;
	        }

	        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$";

	        if (!password.matches(regex)) {
	            System.out.println("Password must be 8+ chars with alphabet, digit, and special character");
	            return false;
	        }

	        return true;
	    }
	 
//	 public static boolean login(String username, String password) {
//
//	        if (isValidUsername(username) && isValidPassword(password)) {
//	            System.out.println("Login Successful!");
//	            return true;
//	        }
//
//	        System.out.println("Invalid username or password");
//	        return false;
//	    }

}
