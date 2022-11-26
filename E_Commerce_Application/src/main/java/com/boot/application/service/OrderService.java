package com.boot.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.application.entity.Customer;
import com.boot.application.entity.Order;
import com.boot.application.entity.ProductItems;
import com.boot.application.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	Services service;

	@Autowired
	ProductService productService;

	@Autowired
	OrderRepository orderRepository;

	// save All data in order_table
	public Order buyProduct(String userName, int productId) {
		Customer customer = this.service.getCustomerById(userName);
		ProductItems product = this.productService.getProductById(productId);
		int productQuantity = product.getQuantity();
		if (productQuantity > 0) {
			Order order = new Order();
			order.setCustomer(customer);
			order.setProductItems(product);
			String location = this.service.getCustomerById(userName).getLocation();
			order.setAddress(location);
			this.orderRepository.save(order);
			int deductedquantity = productQuantity - 1;
			this.productService.deductQuantity(deductedquantity, productId);
			return order;
		}
		return null;
	}

	public boolean checkOutOfStocks(int productId) {
		int productQuantity = this.productService.getQuantity(productId);
		return (productQuantity > 0);

	}

	public List<Order> getAllOrderByUserName(Customer customer) {
		return this.orderRepository.findAllByCustomerUserName(customer.getUserName());
	}

	public List<Order> grtOrderbyuserName() {
		List<Order> orders = new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}

}
