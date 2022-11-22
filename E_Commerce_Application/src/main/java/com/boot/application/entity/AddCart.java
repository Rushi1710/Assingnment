package com.boot.application.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Table
@Entity
public class AddCart {
	@Id
	private int cartIteamId;
	private String customerEmail;
	private String cartIteamName;
	private String cartIteamImage;
	private int cartIteamPrice;
	private String cartIteamDescription;

	public AddCart() {
		// default constuctor
	}

	public AddCart(int cartIteamId, String customerEmail, String cartIteamName, String cartIteamImage,
			int cartIteamPrice, String cartIteamDescription) {
		super();
		this.cartIteamId = cartIteamId;
		this.customerEmail = customerEmail;
		this.cartIteamName = cartIteamName;
		this.cartIteamImage = cartIteamImage;
		this.cartIteamPrice = cartIteamPrice;
		this.cartIteamDescription = cartIteamDescription;
	}

	public int getCartIteamId() {
		return cartIteamId;
	}

	public void setCartIteamId(int cartIteamId) {
		this.cartIteamId = cartIteamId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCartIteamName() {
		return cartIteamName;
	}

	public void setCartIteamName(String cartIteamName) {
		this.cartIteamName = cartIteamName;
	}

	public String getCartIteamImage() {
		return cartIteamImage;
	}

	public void setCartIteamImage(String cartIteamImage) {
		this.cartIteamImage = cartIteamImage;
	}

	public int getCartIteamPrice() {
		return cartIteamPrice;
	}

	public void setCartIteamPrice(int cartIteamPrice) {
		this.cartIteamPrice = cartIteamPrice;
	}

	public String getCartIteamDescription() {
		return cartIteamDescription;
	}

	public void setCartIteamDescription(String cartIteamDescription) {
		this.cartIteamDescription = cartIteamDescription;
	}

	@Override
	public String toString() {
		return "AddCart [cartIteamId=" + cartIteamId + ", customerEmail=" + customerEmail + ", cartIteamName="
				+ cartIteamName + ", cartIteamImage=" + cartIteamImage + ", cartIteamPrice=" + cartIteamPrice
				+ ", cartIteamDescription=" + cartIteamDescription + "]";
	}
	

}
