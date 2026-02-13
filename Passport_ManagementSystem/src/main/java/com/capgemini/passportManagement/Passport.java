/**
 * 
 */
package com.capgemini.passportManagement;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "passports")
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passportId;
	private String passportNumber;
	private LocalDate issueDate;
	private LocalDate expiryDate;
	
	@OneToOne(mappedBy = "passport")
	private Person person;
	
	
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getPassportId() {
		return passportId;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
