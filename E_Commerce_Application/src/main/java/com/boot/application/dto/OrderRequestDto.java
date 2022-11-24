package com.boot.application.dto;

public class OrderRequestDto {

	private int productId;
	private String customerEmail;

	public OrderRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderRequestDto(int productId, String customerEmail) {
		super();
		this.productId = productId;
		this.customerEmail = customerEmail;
	}

}
