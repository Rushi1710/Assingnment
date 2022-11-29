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

	@Column(name = "orderDate", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date orderDate = new Date();

	private int quantiy;

	private int price;

	public Order() {

	}

	public Order(int orderId, ProductItems productItems, Customer customer, String address, Date orderDate, int quantiy,
			int price) {
		super();
		this.orderId = orderId;
		this.productItems = productItems;
		this.customer = customer;
		this.address = address;
		this.orderDate = orderDate;
		this.quantiy = quantiy;
		this.price = price;
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

	public int getQuantiy() {
		return quantiy;
	}

	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productItems=" + productItems + ", customer=" + customer + ", address="
				+ address + ", orderDate=" + orderDate + ", quantiy=" + quantiy + ", price=" + price + "]";
	}

}
