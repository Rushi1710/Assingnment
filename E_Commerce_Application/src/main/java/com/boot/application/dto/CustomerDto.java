package com.boot.application.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDto {
	@NotEmpty
	@Size(min = 3, message = "user name size must be 3")
	private String userName;

	@NotNull(message = "is required")
	private String email;

	@NotNull(message = "is required")
	@Size(min = 5, message = "Password Size Must be 5")
	private String password;

	@NotNull(message = "is required")
	@Size(min = 10, max = 10, message = "Enter Phone number Should be 10 Digit")
	private String contact;

	@NotNull(message = "is required")
	@Size(min = 2, message = "is required")
	private String name;

	@NotNull(message = "Is Requried")
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
