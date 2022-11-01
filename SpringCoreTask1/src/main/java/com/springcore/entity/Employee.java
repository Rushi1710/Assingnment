package com.springcore.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	@Value("Rushikesh")
	private String ename;

	@Value("101")
	private int id;

	@Autowired
	private Address address;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String ename, int id, Address address) {
		super();
		this.ename = ename;
		this.id = id;
		this.address = address;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// Check Id is Palindrom or not

	public void checkeIdPalindrom() {
		int reversedNum = 0, remainder;

		// store the number to originalNum
		int originalNum = id;

		while (id != 0) {
			remainder = id % 10;
			reversedNum = reversedNum * 10 + remainder;
			id /= 10;
		}

		// check if reversedNum and originalNum are equal
		if (originalNum == reversedNum) {
			System.out.println("Id is Palindrom");
		} else
			System.out.println("Id is Not Palindrom");

	}

	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", id=" + id + ", address=" + address + "]";
	}

}
