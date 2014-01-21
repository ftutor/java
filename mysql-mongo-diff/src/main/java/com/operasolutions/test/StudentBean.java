package com.operasolutions.test;

import com.google.common.collect.ComparisonChain;

public class StudentBean implements Comparable<StudentBean> {

	private int rollNumber;
	private String firstName;
	private String secondName;
	private String division;
	private String address;

	@Override
	public String toString() {
		return "StudentBean [rollNumber=" + rollNumber + ", firstName="
				+ firstName + ", secondName=" + secondName + ", division="
				+ division + ", address=" + address + "]";
	}

	public StudentBean(int rollNumber, String firstName, String secondName,
			String division, String address) {
		super();
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.secondName = secondName;
		this.division = division;
		this.address = address;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// private int rollNumber;
	// private String firstName;
	// private String secondName;
	// private String division;
	// private String address;
	@Override
	public int compareTo(StudentBean o) {
		return ComparisonChain.start().compare(this.rollNumber, o.rollNumber)
				.compare(this.firstName, o.firstName)
				.compare(this.secondName, o.secondName)
				.compare(this.division, o.division)
				.compare(this.address, o.address).result();
	}

}