package com.boot.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.application.dto.CustomerDto;
import com.boot.application.entity.AddCart;
import com.boot.application.entity.Customer;
import com.boot.application.map.CustomerMap;
import com.boot.application.repository.AddCartRepository;
import com.boot.application.repository.CustomerRepository;

@Service
public class Services {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddCartRepository addCartRepository;

	public String insertCustomerData(CustomerDto customerDto) {

		Customer customer = CustomerMap.insertDataInMainEntity(customerDto);
		if (!this.customerRepository.existsById(customer.getUserName())) {
			this.customerRepository.save(customer);
			return "Insert Customer Data ";
		}

		return null;

	}

	public AddCart inserItemToCart(AddCart addcart) {
		this.addCartRepository.save(addcart);
		return addcart;
	}

	public boolean validateCustomer(String userName, String password) {

		return (this.customerRepository.existsById(userName) && password != null);
	}

	public Customer servicesForAdmin(String userName) {
		Customer customer = null;
		Optional<Customer> optional = this.customerRepository.findById(userName);
		if (optional.isPresent()) {
			customer = optional.get();
		}
		return customer;

	}

		public List<AddCart> getAllCartItem() {

		List<AddCart> product = new ArrayList<>();
		this.addCartRepository.findAll().forEach(product::add);
		return product;

	}

}
