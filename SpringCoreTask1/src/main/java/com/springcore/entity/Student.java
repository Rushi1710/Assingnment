package com.springcore.entity;

import java.util.ArrayList;

public class Student 
{

	private int id;
	private String name;
	private String address;
	
	public Student() {
		//System.out.println("Default Constuctor Student Class ");
	}
	
	
	
	public Student(int id, String name, String address) {
		super();
		
		this.id = id;
		this.name = name;
		this.address = address;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		
		this.id = id;
	}
	public String getName()
	{
		
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	public String getAddress() {
		
		return address;
	}
	public void setAddress(String address) {
		
		this.address = address;
	}
	
	public String reversname() 
	{
		String rev ="";
		for(int i = name.length()-1;i>=0;i--) 
		{
			rev = rev + name.charAt(i);
		}
		
		return rev;
		
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
}
