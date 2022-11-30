package com.boot.application.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.application.entity.Customer;
import com.boot.application.entity.Order;
import com.boot.application.entity.ProductItems;
import com.boot.application.repository.OrderRepository;

//order service class using for performing order_table operation
@Service
public class OrderService {
	private static Logger logger = Logger.getLogger(OrderService.class);

	@Autowired
	Services service;

	@Autowired
	ProductService productService;

	@Autowired
	OrderRepository orderRepository;

	// save All data in order_table
	public Order buyProduct(String userName, int productId, int quantity) {
		Customer customer = this.service.getCustomerById(userName);

		ProductItems product = this.productService.getProductById(productId);
		int totalPrice = quantity * product.getPrice();
		logger.info("Stored all customer data in order_table " + customer);
		logger.info("Stored all product  Details in order_table " + product);
		int productQuantity = product.getQuantity();
		if (productQuantity > 0) {
			Order order = new Order();
			order.setPrice(totalPrice);
			order.setCustomer(customer);
			order.setProductItems(product);
			order.setQuantiy(quantity);
			String location = this.service.getCustomerById(userName).getLocation();
			order.setAddress(location);
			this.orderRepository.save(order);
			int deductedquantity = productQuantity - quantity;
			this.productService.deductQuantity(deductedquantity, productId);
			return order;
		}
		return null;
	}

	// collect product quantity from product table if quantity is > 0 then return true else flase .
	public boolean checkOutOfStocks(int productId) {
		int productQuantity = this.productService.getQuantity(productId);
		logger.info("check quantity of product " + productQuantity);
		return (productQuantity > 0);

	}
 
	// get order items by customer userName .
	public List<Order> getAllOrderByUserName(Customer customer) {
		return this.orderRepository.findAllByCustomerUserName(customer.getUserName());
	}

	public List<Order> grtOrderbyuserName() {
		List<Order> orders = new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}

}
