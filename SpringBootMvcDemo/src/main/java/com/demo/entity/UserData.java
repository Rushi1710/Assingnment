package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public  class UserData 
{

	@Id
	private String username;
	private String name;
	private String password;
	private String email;
	private String mobile;
	private String address;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserData(String username, String name, String password, String email, String mobile, String address) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserData [username=" + username + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + ", address=" + address + "]";
	}

	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
