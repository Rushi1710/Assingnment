package com.boot.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Order_table")
@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderId;
	@ManyToOne
	@JoinColumn(name = "productId")
	private ProductItems productItems;
	@ManyToOne
	@JoinColumn(name = "userName")
	private Customer customer;

	private String address;

	
	  @Column(name = "orderDate", nullable = false, columnDefinition =
	 "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP") private
	 Date orderDate = new Date();
	 

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, ProductItems productItems, Customer customer, String address, Date orderDate) {
		super();
		this.orderId = orderId;
		this.productItems = productItems;
		this.customer = customer;
		this.address = address;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public ProductItems getProductItems() {
		return productItems;
	}

	public void setProductItems(ProductItems productItems) {
		this.productItems = productItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productItems=" + productItems + ", customer=" + customer + ", address="
				+ address + "]";
	}

}
