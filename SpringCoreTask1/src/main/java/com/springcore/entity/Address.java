package com.springcore.entity;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
	
	@Value("Mumbai")
	private String city;
	@Value("12145")
	private int pincode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String city, int pincode) {
		super();
		this.city = city;
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", pincode=" + pincode + "]";
	}
	
	

}
