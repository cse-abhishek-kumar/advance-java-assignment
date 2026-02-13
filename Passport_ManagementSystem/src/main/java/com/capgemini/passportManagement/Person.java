/**
 * 
 */
package com.capgemini.passportManagement;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 * 
 */
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String name;
	private LocalDate dob;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passport_id",unique = true)
	private Passport passport;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getPersonId() {
		return personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
}
