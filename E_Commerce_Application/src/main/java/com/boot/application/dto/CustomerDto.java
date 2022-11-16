package com.boot.application.dto;

public class CustomerDto {
	private String userName;
	private String email;
	private String password;
	private String contact;
	private String name;
	private String location;
	private String role;

	public CustomerDto() {

	}

	public CustomerDto(String userName, String email, String password, String contact, String name, String location,
			String role) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.name = name;
		this.location = location;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", email=" + email + ", password=" + password + ", contact=" + contact
				+ ", name=" + name + ", location=" + location + ", role=" + role + "]";
	}

}
