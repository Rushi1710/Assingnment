package com.boot.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.application.dto.CustomerDto;
import com.boot.application.entity.Customer;
import com.boot.application.map.CustomerMap;
import com.boot.application.repository.CustomerRepository;

@Service
public class Services {

	@Autowired
	private CustomerRepository customerRepository;

	public String insertCustomerData(CustomerDto customerDto) {

		Customer customer = CustomerMap.insertDataInMainEntity(customerDto);
		if (!this.customerRepository.existsById(customer.getUserName())) {
			this.customerRepository.save(customer);
			return "Insert Customer Data ";
		}

		return null;

	}

	public boolean validateCustomer(String userName, String password) {

		if(this.customerRepository.existsById(userName) && password != null) {
			return true;
		}
		return false;	
	}
	
	public Customer servicesForAdmin(String userName) {
		Customer customer = null;
		Optional<Customer> optional = this.customerRepository.findById(userName);
		if(optional.isPresent()) {
		customer = optional.get();
		}
		return customer;
		
	}
	
}
