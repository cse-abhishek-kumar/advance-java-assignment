/**
 * 
 */
package com.capgemini.lockerManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="lockers")
public class Locker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "locker_id")
	private Long lockerId;
	@Column(name="locker_number")
	private String lockerNumber;
	@Column(name = "floor")
	private int floor;
	
	
	public Locker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Locker(String lockerNumber, int floor) {
		super();
		this.lockerNumber = lockerNumber;
		this.floor = floor;
	}
	
	
	public Long getLockerId() {
		return lockerId;
	}
	public String getLockerNumber() {
		return lockerNumber;
	}
	public void setLockerNumber(String lockerNumber) {
		this.lockerNumber = lockerNumber;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	
}
